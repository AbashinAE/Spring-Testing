package ru.gb.Spring.Testing.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.Spring.Testing.model.Task;
import ru.gb.Spring.Testing.model.TaskStatus;


public interface TaskRepository  extends JpaRepository<Task, Long>{
    List<Task> findByStatus(TaskStatus status);
}