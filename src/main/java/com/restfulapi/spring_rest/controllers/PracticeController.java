package com.restfulapi.spring_rest.controllers;

import com.restfulapi.spring_rest.Modals.Order;
import org.springframework.web.bind.annotation.*;
@RestController
public class PracticeController {
    @GetMapping(value = "/hello")
    public String sayHelloRest(){
        return "Hello World!";
    }
    @PostMapping(value = "/order-details")
    public String orderDetails(@RequestBody Order order){
        return order.toString();
    }
    @GetMapping(value = "/sayHello/{user-name}")
    public String pathHello(@PathVariable("user-name") String name){
        return "HIIIIIII "+name;

    }
    @GetMapping(value = "/action")
    public String requestParam(
            @RequestParam("user-name") String firstName,
            @RequestParam("user-state") String state
    ){
        return "The username is "+firstName+" and the user lives in "+state;
    }
}
