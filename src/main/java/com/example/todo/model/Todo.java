package com.example.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity(name = "todo")
@Table(name = "todos")
@Getter
@Setter
@ToString
public class Todo implements Serializable {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(nullable = false, updatable = true, unique = true, length = 36)
    private UUID todoId = UUID.randomUUID();

    @Column(nullable = false, updatable = true, unique = true, length = 512)
    private String todoName;

    @Column(nullable = true, updatable = false, unique = false)
    private Date dueDate;

    @Column(nullable = false, updatable = true)
    private Boolean completed;

    @Column(nullable = false, updatable = true)
    private Date updatedAt = new Date();

    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    public Todo() {
    }

    public Todo(Long id, UUID todoId, String todoName, Date dueDate, Boolean completed, Date updatedAt, Date createdAt) {
        this.id = id;
        this.todoId = todoId;
        this.todoName = todoName;
        this.dueDate = dueDate;
        this.completed = completed;
        this.updatedAt = new Date();
        this.createdAt = new Date();
    }

    public Todo(String todoName, Date dueDate, Boolean completed) {
        this.todoName = todoName;
        this.dueDate = dueDate;
        this.completed = completed;
        this.updatedAt = new Date();
        this.createdAt = new Date();
    }
}
