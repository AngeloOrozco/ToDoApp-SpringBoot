package com.todoApp.TodoApp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate createdDate;
    private LocalDate eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
