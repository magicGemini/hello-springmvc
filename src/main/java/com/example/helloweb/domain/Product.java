package com.example.helloweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    private String description;
    private float price;

}
