package br.com.ordering.system.customer.controller;


import br.com.ordering.system.customer.domain.CustomerDTO;
import br.com.ordering.system.customer.request.CustomerRequest;
import br.com.ordering.system.customer.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;


    @PostMapping(value = "/insert")
    public ResponseEntity<Object> insertCustomer(@RequestBody CustomerRequest customer){
        repository.insert(new CustomerDTO(
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

    @GetMapping(value = "/recover")
    public ResponseEntity<Object> getCustomer(){
        return new ResponseEntity<>( repository.findAll(),HttpStatus.OK);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequest customer){

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
