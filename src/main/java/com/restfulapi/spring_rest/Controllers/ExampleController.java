package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.Order.OrderProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {
    @GetMapping(value = "/sayHello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHelloToWorld(){
        return "Hello World";
    }

    @PostMapping(value= "/storeMessage")
    public ResponseEntity<String> storeMessage(@RequestBody  String message){
        if(message!=null) {
        return new ResponseEntity<>("The message "+message+" is stored in the database",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("The message is null",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value= "/post-order")
    public ResponseEntity<String> storeOrder(@RequestBody OrderProduct order){
        if(order!=null) {
            return new ResponseEntity<>("The order => "+order.toString()+" is stored in the database",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("The order is null",HttpStatus.BAD_REQUEST);
        }
    }

}
