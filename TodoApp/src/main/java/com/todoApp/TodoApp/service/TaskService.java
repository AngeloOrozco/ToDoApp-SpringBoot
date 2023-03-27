package com.todoApp.TodoApp.service;

import com.todoApp.TodoApp.exceptions.ToDoExceptions;
import com.todoApp.TodoApp.mapper.TaskInDTOToTask;
import com.todoApp.TodoApp.persistence.entity.Task;
import com.todoApp.TodoApp.persistence.entity.TaskStatus;
import com.todoApp.TodoApp.persistence.repository.TaskRepository;
import com.todoApp.TodoApp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mappper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mappper) {
        this.repository = repository;
        this.mappper = mappper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = this.mappper.map(taskInDTO);
        return this.repository.save(task);

    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void taskAsFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
