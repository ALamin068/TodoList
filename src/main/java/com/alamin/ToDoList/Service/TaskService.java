package com.alamin.ToDoList.Service;


import com.alamin.ToDoList.Model.Task;
import com.alamin.ToDoList.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    @Autowired
    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task createNewTask(Task task){
        Task fullObject = new Task(task.getChore(),task.isCompleted(), LocalDateTime.now());
        System.out.println(fullObject.toString());
        return taskRepo.save(fullObject);
    }

    public Optional<Task> getTaskById(Long id){
        Optional<Task> task = taskRepo.findById(id);
        return task;
    }

    public List<Task> getAllTask(){
        return taskRepo.findAll();
    }

    public Task updateTask(Task task, long id){
        Task updateTask = taskRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Task Not Found !"));

        updateTask.setChore(task.getChore());
        updateTask.setCompleted(task.isCompleted());

        return  taskRepo.save(updateTask);


    }

    public void deleteTask(long id){
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
        }else{
            System.out.println("No task found");
        }

    }


}


