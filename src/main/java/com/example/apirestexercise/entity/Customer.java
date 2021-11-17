package com.example.apirestexercise.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    private String dni;
    private String name;

    public Customer() {
    }

    public Customer(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }
}
