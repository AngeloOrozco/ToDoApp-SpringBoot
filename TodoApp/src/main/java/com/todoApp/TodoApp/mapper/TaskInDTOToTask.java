package com.todoApp.TodoApp.mapper;

import com.todoApp.TodoApp.persistence.entity.Task;
import com.todoApp.TodoApp.persistence.entity.TaskStatus;
import com.todoApp.TodoApp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{
    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now().toLocalDate());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
