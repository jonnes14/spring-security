package com.jonnes.spring_security.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    private int rollno;
    private String name;
    private String tech;
}
