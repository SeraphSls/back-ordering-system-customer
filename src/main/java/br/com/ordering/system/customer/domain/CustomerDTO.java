package br.com.ordering.system.customer.domain;


import br.com.ordering.system.customer.request.CustomerRequest;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("customer")
public class CustomerDTO {

    @MongoId(FieldType.OBJECT_ID)
    private String cpf;
    private String name;
    private String email;
    private String state;
    private String city;
    private String cep;
    private String street;
    private String number;

    public CustomerDTO(String cpf, String name, String email, String state, String city, String cep, String street, String number) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.state = state;
        this.city = city;
        this.cep = cep;
        this.street = street;
        this.number = number;
    }





}
