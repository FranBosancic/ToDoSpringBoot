package org.fran.todoappspringboot.service;

import org.fran.todoappspringboot.entity.ToDo;
import org.fran.todoappspringboot.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService
{
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo)
    {
        return toDoRepository.save(toDo);
    }

    public List<ToDo> getAllToDos()
    {
        return toDoRepository.findAll();
    }
}
