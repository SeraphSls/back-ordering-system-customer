package br.com.ordering.system.customer.domain;


import br.com.ordering.system.customer.request.CustomerRequest;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("customer")
public class CustomerDTO {

    @MongoId(FieldType.STRING)
    private String cpf;
    private String name;
    private String email;
    private String state;
    private String city;
    private String cep;
    private String street;
    private String number;

    public CustomerDTO(CustomerRequest customer) {
        this.cpf = customer.getCpf();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.state = customer.getState();
        this.city = customer.getCity();
        this.cep = customer.getCep();
        this.street = customer.getStreet();
        this.number = customer.getNumber();
    }


}
