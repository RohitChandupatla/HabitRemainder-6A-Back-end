package com.northwest.habit_reminder.controller;

import com.northwest.habit_reminder.entities.Habit;
import com.northwest.habit_reminder.repository.HabitRepository;
import com.northwest.habit_reminder.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
public class ReminderController {
    @Autowired
    private HabitRepository repository;

    @GetMapping("/habit")
    Optional<Habit> getHabit() {
        long count = repository.count();
        return repository.findById(CommonUtils.getRandomNumber(1, count));
    }
    @GetMapping("/allHabit")
    List<Habit> getAllHabit() {
        return (List<Habit>) repository.findAll();
    }

    @PostMapping("/habit")
    ResponseEntity createHabit(@RequestBody Habit habit) {
        try {
            repository.save(habit);
            return new ResponseEntity("Added " + habit.getHabit(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/habit/{id}")
    ResponseEntity deleteHabit(@PathVariable int id){
        try {
            Optional<Habit> habit = repository.findById(id);
            repository.deleteById(id);
            return new ResponseEntity("Deleted " + habit.get().getHabit() , HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
