package com.springrest.makemyevent.model.dto;

import lombok.Data;

import javax.persistence.Transient;

@Data
public class UserDto {

    private String userEmail;
    private String userPassword;
    private String userName;
    private long userNumber;
    private String userRole;
}
