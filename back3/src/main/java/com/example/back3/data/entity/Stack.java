package com.example.back3.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="stack")
public class Stack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stack_id")
    private int stackId;

    @Column(name="stack_nm")
    private String stackNm;

    @ManyToOne
    @JoinColumn(name="user_id_fk")
    private User user;
}
