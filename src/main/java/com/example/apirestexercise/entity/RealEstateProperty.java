package com.example.apirestexercise.entity;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateProperty {
    private int code;
    private String address;
    private double amount;
}
