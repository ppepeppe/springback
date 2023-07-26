package com.example.back3.controller;


import com.example.back3.data.entity.Stack;
import com.example.back3.data.entity.User;
import com.example.back3.data.repository.StackRepository;
import com.example.back3.dto.request.*;
import com.example.back3.dto.response.*;
import com.example.back3.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    private final StackRepository stackRepository;
    @PostMapping("/user")
    private ResponseEntity<?> getUserNm(@RequestBody UserRequest userRequest){
        try {
            String userNm = mainService.getUserName(userRequest.getUserId());
            return new ResponseEntity<> (new UserResponse(userNm), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/stack")
    private ResponseEntity<?> getUserStack(@RequestBody StackRequest stackRequest) {
        try {
            List<String> stacks = mainService.getUserStack(stackRequest.getUserId());
            return new ResponseEntity<> (new StackResponse(stacks), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/equipment")
    private ResponseEntity<?> getUserEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        try {
            List<String> equips = mainService.getUserEquip(equipmentRequest.getUserId());
            return new ResponseEntity<> (new EquipmentResponse(equips), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/all")
    private ResponseEntity<?> getUserAll(@RequestBody AllRequest allRequest) {
        try {
            AllResponse allResponse = mainService.getUserAll(allRequest.getUserId());
            return new ResponseEntity<> (allResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/stackuser")
    private ResponseEntity<?> getStackUserNm(@RequestBody StackNameRequest stackNameRequest) {
        try {
            Set<String> stackUsers = mainService.getStackUserNm(stackNameRequest.getStackNm());
            UserAllResponse userAllResponse = mainService.getUserAllName();
            System.out.println(userAllResponse.toString());
            return new ResponseEntity<> (new StackNameResponse(stackUsers), HttpStatus.OK);
//            return new ResponseEntity<> (userAllResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    private ResponseEntity<?> getUserAll(){
        try {
            UserAllResponse userAllResponse = mainService.getUserAllName();
            return new ResponseEntity<> (userAllResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    private ResponseEntity<?> signUpUser(@RequestBody SignUpUserRequest signUpUserRequest){
        try {
            mainService.signUpUser(signUpUserRequest);
            return new ResponseEntity<> (new SingUpUserResponse("good"), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/stacknew")
    public ResponseEntity<?> stackNew(@RequestBody StackNewRequest stackNewRequest) {
        try {
            mainService.stackNew(stackNewRequest);
            return new ResponseEntity<> (new StackNewResponse("good"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
