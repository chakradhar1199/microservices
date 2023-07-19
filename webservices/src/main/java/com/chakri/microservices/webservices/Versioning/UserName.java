package com.chakri.microservices.webservices.Versioning;

public class UserName {
    private String name;
    private String firstName;
    private String lastName;
    public UserName(String name) {
        this.name = name;
    }

    public UserName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public String toString(String s){

//    }
}
