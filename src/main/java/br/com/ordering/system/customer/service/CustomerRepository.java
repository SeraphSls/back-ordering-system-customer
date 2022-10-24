package br.com.ordering.system.customer.service;

import br.com.ordering.system.customer.domain.CustomerDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDTO, String > {

    @Query(value = "{ 'cpf' : ?0 }", fields = "{ 'cpf' : 0 }")
    CustomerDTO findByCPF(String cpf);
}
