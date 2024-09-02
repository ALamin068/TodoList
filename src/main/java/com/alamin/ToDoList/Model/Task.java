package com.alamin.ToDoList.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "task", nullable = false)
    private String chore;

    @Column(name = "status")
    private boolean completed;

    @Column(name="date")
    private LocalDateTime date;


    public Task(String chore, boolean completed, LocalDateTime date){
        this.chore = chore;
        this.completed = completed;
        this.date = date;
    }

    public Task() {
    }

    public String getChore() {
        return chore;
    }

    public void setChore(String chore) {
        this.chore = chore;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getTaks() {
//        return chore;
//    }
//
//    public void setTaks(String taks) {
//        this.chore = taks;
//    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", Task='" + chore + '\'' +
                ", Status='" + completed + '\'' +
                ", date=" + date +
                '}';
    }




}
