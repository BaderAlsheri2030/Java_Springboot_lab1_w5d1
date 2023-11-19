package com.example.javaspringboot_lab1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentSystem {
    private String name;
    private int age;
    private String degree;
    private String status;
}
