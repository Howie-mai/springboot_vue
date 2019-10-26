package com.zhku.mh.validation_demo.entities;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

public class User {

    private Integer id;

    @Size(min = 5, max = 10, message = "{user.name.size}")
    private String name;

    @NotBlank(message = "{user.address.notnull}")
    private String address;

    @DecimalMin(value = "1", message = "{user.age.size}")
    @DecimalMax(value = "150", message = "{user.age.size}")
    private Integer age;

    @Email(message = "{user.email.pattern}")
    @NotBlank(message = "{user.email.notnull}")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
