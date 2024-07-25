package com.example.crudexercise.Controller;

import com.example.crudexercise.Api.ApiResponse;
import com.example.crudexercise.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

   // Display all tasks .
    @GetMapping("/get")
    public ArrayList <Task> displayTasks() {
        return tasks;
    }

  //Create a new task.
    @PostMapping("/add")
    public ApiResponse CreateTask (@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse("Task successfully added!");
    }

   //Update a task
    @PutMapping("/update/{index}")
    public ApiResponse updateTask (@PathVariable int index,@RequestBody Task task) {
        tasks.set(index,task);
        return new ApiResponse("Task successfully updated!");
    }

//Delete a task
@DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("Task successfully deleted!");
    }


//Change the task status as done or not done
 @PutMapping("/update/status/{index}")
    public ApiResponse updateTaskStatus(@PathVariable int index,@RequestParam String status) {
       if (index >= 0 && index < tasks.size()) {
           Task task =tasks.get(index);

           if (status.equalsIgnoreCase("Done")|| status.equalsIgnoreCase("Not Done")) {
               task.setStatus("Done");
               return new ApiResponse("Task status successfuly update!");
           }

       }
       return  new ApiResponse("Task not found at index:"+index);
    }

    //Search for a task by given title
    @GetMapping("/searchtask")
    public ApiResponse getTaskBytitle (@RequestParam String title) {

        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return new ApiResponse("Task found: "+"Title: " + task.getTitle() +" Id: " +task.getId() +" Description: " +task.getDescription() + " Status: " +task.getStatus());
            }
        }
        return new ApiResponse("Task with title:  "+ title + "  not found!");
    }





}
