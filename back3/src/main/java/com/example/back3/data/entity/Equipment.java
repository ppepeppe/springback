package com.example.back3.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private int equipmentId;

    @Column(name="equipment_nm")
    private String equipmentNm;

    @ManyToOne
    @JoinColumn(name="user_id_fk")
    private  User user;

}
