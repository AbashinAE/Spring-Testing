package ru.gb.Spring.Testing.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.gb.Spring.Testing.aspects.TrackUserAction;
import ru.gb.Spring.Testing.model.Task;
import ru.gb.Spring.Testing.model.TaskStatus;
import ru.gb.Spring.Testing.repositories.TaskRepository;

@Service

public class DataProcessingService {
    private TaskRepository taskRepository;

    public DataProcessingService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @TrackUserAction
    public List<Task> getListTasks() {
        return taskRepository.findAll();
    }

    @TrackUserAction
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @TrackUserAction
    public List<Task> getListTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTaskStatusWithId(Long id, TaskStatus status) {
        Task updatedTask = taskRepository.getReferenceById(id);
        updatedTask.setStatus(status);
        updatedTask.setLastUpdateTime(LocalDateTime.now());
        return taskRepository.saveAndFlush(updatedTask);
    }

    @TrackUserAction
    public void deleteTaskWithId(Long id) {
        taskRepository.delete(taskRepository.getReferenceById(id));
    }
}