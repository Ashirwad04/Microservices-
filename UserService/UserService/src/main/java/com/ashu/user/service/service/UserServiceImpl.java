package com.ashu.user.service.service;

import com.ashu.user.service.entity.Hotel;
import com.ashu.user.service.entity.Rating;
import com.ashu.user.service.entity.User;
import com.ashu.user.service.exception.ResourceNotFoundException;
import com.ashu.user.service.repo.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;




@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with the given id not found on the server!! : " + userId));

        // Fetch rating of the above user from the rating service
        // http://localhost:8083/rating/users/{userId}
        Rating[] ratingOfUSer = restTemplate.getForObject("http://RATINGSERVICE/rating/users/" + userId, Rating[].class);
        logger.info("Ratings: {}", ratingOfUSer);
        List<Rating> ratings= Arrays.stream(ratingOfUSer).toList();
        List<Rating> ratingList =ratings.stream().map(rating->{
            //api call to hotel service to get the hotel
                        //http://localhost:8082/hotels/83d57a8c-46be-4207-82c3-74aed983c820
            ResponseEntity<Hotel>   forEntity=  restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("responce status code:{}",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}



















