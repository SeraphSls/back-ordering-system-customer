package br.com.ordering.system.customer.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/customer")
public class CustomerController {

    @GetMapping(value = "/recover")
    public ResponseEntity<Object> getCustomer(){
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
