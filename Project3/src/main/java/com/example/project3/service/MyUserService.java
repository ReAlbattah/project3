package com.example.project3.service;

import com.example.project3.model.MyUser;
import com.example.project3.repo.MyUserRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class MyUserService {
    private final MyUserRepo myUserRepo;

    public List<MyUser> getUsers(){
      return myUserRepo.findAll();
    }

    public void addUser(MyUser myUser){
        myUserRepo.save(myUser);
    }

    public MyUser getUser(Integer userid) {
        return myUserRepo.findById(userid).get();
    }
}
