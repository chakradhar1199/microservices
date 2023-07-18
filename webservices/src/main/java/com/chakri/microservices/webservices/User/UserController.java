package com.chakri.microservices.webservices.User;

import com.chakri.microservices.webservices.Exception.UserNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserDaoService userDaoService;
//
//
    @GetMapping("/users")
    public List<UserEntity> getUsers(){
        return userDaoService.getUserEntityList();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id){
        var user = userDaoService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("id = "+id);
        }
        return ResponseEntity.ok().body(user);
    }
//    put

//    post
    @PostMapping("/users/adduser/")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        userDaoService.addUser(user);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

//    delete
}
