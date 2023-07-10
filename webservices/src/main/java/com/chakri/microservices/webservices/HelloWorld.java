package com.chakri.microservices.webservices;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("this is new Hello World bean");
    }

//    path parameters
    @RequestMapping("hello-world-path-parameter/{name}")
    public HelloWorldBean helloWorldPathParameters(@PathVariable String name){
        return new HelloWorldBean("Hello World this is "+name);
    }

}
