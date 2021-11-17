package com.northwest.habit_reminder.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Habit {
    @Id
    private int id;
    private String habit;
    private String description;
}
