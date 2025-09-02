package org.fran.todoappspringboot.controller;

import org.fran.todoappspringboot.entity.ToDo;
import org.fran.todoappspringboot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController
{
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo)
    {
        return toDoService.createToDo(toDo);
    }

    @GetMapping
    public List<ToDo> getAllToDo()
    {
        return toDoService.getAllToDos();
    }
}
