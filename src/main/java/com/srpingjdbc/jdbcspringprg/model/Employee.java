package com.srpingjdbc.jdbcspringprg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;
    private String city;

    private Department department;
}
