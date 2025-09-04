package org.fran.todoappspringboot.controller;

import org.fran.todoappspringboot.entity.ToDo;
import org.fran.todoappspringboot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class ToDoController
{

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public String listTodos(Model model)
    {
        model.addAttribute("todos", toDoService.getAllToDos());
        return "todo-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model)
    {
        model.addAttribute("todo", new ToDo());
        return "todo-form";
    }

    @PostMapping
    public String createTodo(@ModelAttribute ToDo todo)
    {
        toDoService.createToDo(todo);
        return "redirect:/todos";
    }
}
