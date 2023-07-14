package com.example.imtahantask2.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {
    private Long id ;
    private String name ;
    private String surname;
    private Date birth_date;
    private  String job_name;

}
