package com.example.project3.controller;

import com.example.project3.model.API;
import com.example.project3.model.MyUser;
import com.example.project3.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;

    Logger logger = LoggerFactory.getLogger(MyUserController.class);
    @GetMapping
    public ResponseEntity<List<MyUser>> getUsers(){
        logger.info("Get Users");
        return ResponseEntity.status(200).body(myUserService.getUsers());
    }

    @PostMapping
    public ResponseEntity<API> addUser(@RequestBody @Valid MyUser myUser){
        logger.info("Add new user");
        myUserService.addUser(myUser);
        return ResponseEntity.status(201).body(new API("User added",201));
    }
}
