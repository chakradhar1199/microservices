package com.chakri.microservices.webservices.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {


    private static List<UserEntity> userEntityList = new ArrayList<>();
    private static int i;

    static{
        i = 0;
        userEntityList.add(new UserEntity("chakri", ++i, "cse", 20000, new Date(1996,06,11)));
        userEntityList.add(new UserEntity("veena", ++i, "eee", 30000, new Date(1997,11,9)));
        userEntityList.add(new UserEntity("padmaja rani", ++i, "Teaching", 50000, new Date(1968,10,01)));
        userEntityList.add(new UserEntity("rama subba reddy", ++i, "BA", 100000, new Date(1963,01,11)));
    }

    public List<UserEntity> getUserEntityList(){
        return userEntityList;
    }

    public UserEntity getUserById(Integer id){
        return userEntityList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void addUser(UserEntity user){

        user.setId(++i);
        userEntityList.add(user);
//        return user;

    }


}
