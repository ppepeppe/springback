package com.example.back3.data.repository;

import com.example.back3.data.entity.Stack;
import com.example.back3.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackRepository extends JpaRepository<Stack, Integer> {
    List<Stack> findAllByUser(User user);
    List<Stack> findAllByStackNm(String stackNm);

}
