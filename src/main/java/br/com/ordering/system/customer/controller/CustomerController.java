package br.com.ordering.system.customer.controller;


import br.com.ordering.system.customer.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;


    @GetMapping(value = "/")
    public ResponseEntity<Object> getCustomer(){

        repository.findAll();


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
