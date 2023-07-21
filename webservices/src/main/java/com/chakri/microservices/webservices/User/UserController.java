package com.chakri.microservices.webservices.User;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.chakri.microservices.webservices.Exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    public EntityModel<UserEntity> getUserById(@PathVariable int id){
        var user = userDaoService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("id = "+id);
        }
        //build an entity model
        EntityModel<UserEntity> entityModel = EntityModel.of(user);

        // build a web mvc builder
        WebMvcLinkBuilder link  = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("see all users"));
        return entityModel;
    }
//    put

//    post
    @PostMapping("/users/adduser/")
    public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user){
        userDaoService.addUser(user);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

    @DeleteMapping("users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUser(id);

    }

//    delete
}
