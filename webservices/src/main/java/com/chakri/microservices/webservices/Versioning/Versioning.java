package com.chakri.microservices.webservices.Versioning;

import com.chakri.microservices.webservices.Exception.UserNotFoundException;
import com.chakri.microservices.webservices.User.UserDaoService;
import com.chakri.microservices.webservices.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Versioning {

    @Autowired
    private UserDaoService userDaoService;
    @GetMapping("/v1/user/{id}")
    public ResponseEntity<UserName> getUserNameByID(@PathVariable int id){
        UserEntity user = userDaoService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("id = "+id);
        }
        UserName u = new UserName(user.getName());
        return ResponseEntity.ok().body(u);
    }

    @GetMapping("/v2/user/{id}")
    public ResponseEntity<UserName> getUserNameByIDVersion2(@PathVariable int id){
        UserEntity user = userDaoService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("id = "+id);
        }
        String[] names = user.getName().split(" ");
        UserName u = null;
        if(names.length == 2){
             u = new UserName(names[0], names[1]);}
        else{
             u = new UserName(names[0], "");}

        return ResponseEntity.ok().body(u);
    }
}
