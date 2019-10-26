package com.zhku.mh.validation_demo.entities;

import com.zhku.mh.validation_demo.ValidateGroup.ValidationGroup1;
import com.zhku.mh.validation_demo.ValidateGroup.ValidationGroup2;

import javax.validation.constraints.*;

public class People {
    private Integer id;

    @Size( min= 5,max = 10,message = "{user.name.size}",
            groups = ValidationGroup1.class)
    private String name;

    @NotBlank(message = "{user.address.notnull}",groups = ValidationGroup2.class)
    private String address;

    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "120",message = "{user.age.size}")
    private String age;
    @Email(message = "{user.email.pattern}")
    @NotBlank(message = "{user.email.notnull}"
            ,groups = {ValidationGroup2.class,ValidationGroup1.class})
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
