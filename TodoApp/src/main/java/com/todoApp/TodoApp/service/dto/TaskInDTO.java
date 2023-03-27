package com.todoApp.TodoApp.service.dto;

import com.todoApp.TodoApp.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDate eta;

}
