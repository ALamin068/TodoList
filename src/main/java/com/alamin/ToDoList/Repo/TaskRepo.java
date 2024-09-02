package com.alamin.ToDoList.Repo;


import com.alamin.ToDoList.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

}
