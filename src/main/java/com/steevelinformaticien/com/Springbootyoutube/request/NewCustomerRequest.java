package com.steevelinformaticien.com.Springbootyoutube.request;

import lombok.Data;

@Data
public class NewCustomerRequest {
    private String name;
    private String email;
    private Integer age;
}
