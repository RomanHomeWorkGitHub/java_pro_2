package com.example.java_pro_2.dto;

import lombok.Data;

@Data
public class Employee {
    private final String name;
    private final Integer age;
    private final String function;

    public Employee(String name, Integer age, String function) {
        this.name = name;
        this.age = age;
        this.function = function;
    }
}
