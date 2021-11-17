package com.northwest.habit_reminder.repository;

import com.northwest.habit_reminder.entities.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Integer> {
    void deleteById(int id);
}
