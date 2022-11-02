package com.springrest.makemyevent.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Admin_Details")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long adminId;
    private String adminName;
    private String adminEmail;
    private long adminNumber;
    private String role;

}
