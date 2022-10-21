package br.com.ordering.system.customer.service;

import br.com.ordering.system.customer.domain.CustomerDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDTO, String > {

}
