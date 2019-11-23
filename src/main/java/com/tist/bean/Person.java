package com.tist.bean;

import lombok.Data;

/**
 * @author Jack Lin
 */
@Data
public class Person {

    private Integer age;

    private String name;

    {
        age = 0;
        name = "";
    }
}
