package com.restfulapi.spring_rest.controllers;

import com.restfulapi.spring_rest.Modals.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping(value = "/hello")
    public String sayHelloRest(){
        return "Hello World!";
    }
    @PostMapping(value = "/storeMessage")
    public String storeMessage(@RequestBody String message){
        return "The message : "+message+" has been stored in the database";
    }

    @PostMapping(value = "/order-details")
    public String orderDetails(@RequestBody Order order){
        return order.toString();
    }
}
