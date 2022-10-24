package br.com.ordering.system.customer.controller;


import br.com.ordering.system.customer.domain.CustomerDTO;
import br.com.ordering.system.customer.request.CustomerRequest;
import br.com.ordering.system.customer.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;


    @PostMapping(value = "/insert")
    public ResponseEntity<Object> insertCustomer(@RequestBody CustomerRequest customer){
        CustomerDTO cliente = repository.findByCPF(customer.getCpf());
        if(cliente != null){
            return new ResponseEntity<>("CPF ja cadastrado!", HttpStatus.BAD_REQUEST);
        }else {
            repository.insert(new CustomerDTO(
                    null,
                    customer.getCpf(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getState(),
                    customer.getCity(),
                    customer.getCep(),
                    customer.getStreet(),
                    customer.getNumber()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/recover")
    public ResponseEntity<Object> getCustomer(){
        return new ResponseEntity<>( repository.findAll(),HttpStatus.OK);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequest customer){
        CustomerDTO cliente = repository.findByCPF(customer.getCpf());
        if(cliente == null){
            return new ResponseEntity<>("Cliente nao encontrado!", HttpStatus.BAD_REQUEST);
        }else {
            repository.save(new CustomerDTO(
                    cliente.getId(),
                    customer.getCpf(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getState(),
                    customer.getCity(),
                    customer.getCep(),
                    customer.getStreet(),
                    customer.getNumber()));
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<Object> deleteCustomer(@RequestBody CustomerRequest customer){
        CustomerDTO cliente = repository.findByCPF(customer.getCpf());
        if(cliente == null){
            return new ResponseEntity<>("Cliente nao encontrado!", HttpStatus.BAD_REQUEST);
        }else {
            repository.delete(new CustomerDTO(
                    cliente.getId(),
                    customer.getCpf(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getState(),
                    customer.getCity(),
                    customer.getCep(),
                    customer.getStreet(),
                    customer.getNumber()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
