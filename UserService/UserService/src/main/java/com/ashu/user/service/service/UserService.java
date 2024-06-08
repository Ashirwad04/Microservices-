package com.ashu.user.service.service;

import com.ashu.user.service.entity.User;

import java.util.List;

public interface UserService {

    //user operations

    //create user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get user by id
    User getUser(String userId);


    //todo:delete
    //todo:update

}
