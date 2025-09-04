package org.fran.todoappspringboot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class ToDo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;

    public ToDo()
    {
    }

    public ToDo(Long id, String title, String description, LocalDateTime createdDate)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDateTime getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getDateWithCustomTimeFormat()
    {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(createdDate);
    }

    //Basically ovo se napravi prije spremanja u bazu
    //tj u json requestu za POST ne treba createdDate jer se tu automatski napravi
    @PrePersist
    public void prePersist()
    {
        createdDate = LocalDateTime.now();
    }
}
