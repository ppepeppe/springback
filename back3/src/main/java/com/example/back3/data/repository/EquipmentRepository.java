package com.example.back3.data.repository;

import com.example.back3.data.entity.Equipment;
import com.example.back3.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> findAllByUser(User user);
}
