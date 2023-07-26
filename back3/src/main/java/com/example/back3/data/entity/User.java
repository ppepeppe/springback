package com.example.back3.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_table")

public class User {
//    @Builder
//    public User(long userId, String userNm){
//        this.userId = userId;
//        this.userNm = userNm;
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;

    @Column(name="user_nm")
    private String userNm;
}
