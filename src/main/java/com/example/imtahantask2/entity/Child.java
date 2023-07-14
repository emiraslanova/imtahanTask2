package com.example.imtahantask2.entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Child {
    private long id ;
    private String name;
    private Date birth_date;



}
