package com.ashu.user.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {

    @Id
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "about")
    private String about;


    @Transient//This annotation use when we do not want to store that in db
    private List<Rating> ratings=new ArrayList<>();

}