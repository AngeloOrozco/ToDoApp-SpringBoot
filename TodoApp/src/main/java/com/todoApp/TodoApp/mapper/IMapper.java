package com.todoApp.TodoApp.mapper;

public interface IMapper <I, O>{
    public  O map(I in);
}
