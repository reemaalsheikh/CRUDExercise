package com.example.crudexercise.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Task Class : ID , title , description , status
@Data
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;
}
