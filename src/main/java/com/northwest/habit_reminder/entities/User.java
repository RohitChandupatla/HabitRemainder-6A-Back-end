package com.northwest.habit_reminder.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}
