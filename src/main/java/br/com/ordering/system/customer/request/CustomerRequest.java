package br.com.ordering.system.customer.request;

import lombok.Data;

@Data
public class CustomerRequest {

    private String name;
    private String cpf;
    private String email;
    private String state;
    private String city;
    private String cep;
    private String street;
    private String number;

}
