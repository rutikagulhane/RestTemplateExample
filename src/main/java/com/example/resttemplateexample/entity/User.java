package com.example.resttemplateexample.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String type;
    private String setup;
    private String punchline;
}
