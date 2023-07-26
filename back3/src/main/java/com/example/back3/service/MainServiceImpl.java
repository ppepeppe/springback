package com.example.back3.service;

import com.example.back3.data.entity.Equipment;
import com.example.back3.data.entity.Stack;
import com.example.back3.data.entity.User;
import com.example.back3.data.repository.EquipmentRepository;
import com.example.back3.data.repository.StackRepository;
import com.example.back3.data.repository.UserRepository;
import com.example.back3.dto.request.SignUpUserRequest;
import com.example.back3.dto.request.StackNewRequest;
import com.example.back3.dto.response.AllResponse;
import com.example.back3.dto.response.UserAllResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Getter
@Setter
@AllArgsConstructor

public class MainServiceImpl implements MainService{
    private final UserRepository userRepository;
    private final StackRepository stackRepository;
    private final EquipmentRepository equipmentRepository;
    @Override
    public String getUserName(Long userId) {
        User user = userRepository.findByUserId(userId);
        return user.getUserNm();
    }

    @Override
    public List<String> getUserStack(Long userId) {
        User user = userRepository.findByUserId(userId);
        List<Stack> stackList = stackRepository.findAllByUser(user);

        List<String> stacks = new ArrayList<>();
        for (Stack stack : stackList) {
            stacks.add(stack.getStackNm());
        }

        return stacks;
    }

    @Override
    public List<String> getUserEquip(Long userId) {
        User user = userRepository.findByUserId(userId);
        List<Equipment> equipmentList = equipmentRepository.findAllByUser(user);
        List<String> equips = new ArrayList<>();
        for (Equipment eq : equipmentList) {
            equips.add(eq.getEquipmentNm());
        }

        return equips;
    }
    @Override
    public AllResponse getUserAll(Long userId) {
        User user = userRepository.findByUserId(userId);
        String userNm = user.getUserNm();
        List<Stack> stackList = stackRepository.findAllByUser(user);
        List<Equipment> equipmentList = equipmentRepository.findAllByUser(user);

        List<String> stacks = new ArrayList<>();
        List<String> equips = new ArrayList<>();

        for (Stack stack : stackList) {
            stacks.add(stack.getStackNm());
        }

        for (Equipment equipment : equipmentList ){
            equips.add(equipment.getEquipmentNm());
        }

        return new AllResponse(userNm, stacks, equips);
    }
    @Override
    public Set<String> getStackUserNm(String stackNm) {
        List<Stack> stackList = stackRepository.findAllByStackNm(stackNm);
        Set<String> stackUserSet = new HashSet<>();

        for (Stack stack : stackList) {
            stackUserSet.add(stack.getUser().getUserNm());
        }
        return stackUserSet;
    }

    @Override
    public UserAllResponse getUserAllName() {
        List<User> userList = userRepository.findAll();

        List<AllResponse> userall = new ArrayList<>();
        for (User user : userList){
            userall.add(getUserAll(user.getUserId()));

        }

        return new UserAllResponse(userall);
    }

    @Override
    @Transactional
    public void signUpUser(SignUpUserRequest signUpUserRequest) {
        User newUser = new User();
        newUser.setUserNm(signUpUserRequest.getUserNm());
        userRepository.save(newUser);

    }

    @Override
    @Transactional
    public void stackNew(StackNewRequest stackNewRequest) {
        Stack newStack = new Stack();
        newStack.setStackNm(stackNewRequest.getStackNm());
        newStack.setUser(userRepository.findByUserId(stackNewRequest.getUserIdFk()));
        stackRepository.save(newStack);

    }


}

