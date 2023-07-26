package com.example.back3.service;

import com.example.back3.data.entity.Stack;
import com.example.back3.data.entity.User;
import com.example.back3.dto.request.SignUpUserRequest;
import com.example.back3.dto.request.StackNewRequest;
import com.example.back3.dto.response.AllResponse;
import com.example.back3.dto.response.UserAllResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service

public interface MainService {
    String getUserName(Long userId);

    List<String> getUserStack(Long userId);

    List<String> getUserEquip(Long userId);

    AllResponse getUserAll(Long userId);
    Set<String> getStackUserNm(String stackNm);

    UserAllResponse getUserAllName();

    void signUpUser(SignUpUserRequest signUpUserRequest);

    void stackNew(StackNewRequest stackNewRequest);


}
