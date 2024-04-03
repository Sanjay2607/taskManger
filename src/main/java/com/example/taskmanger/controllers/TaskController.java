package com.example.taskmanger.controllers;

import com.example.taskmanger.dtos.CreateTaskDTO;
import com.example.taskmanger.entities.TaskEntity;
import com.example.taskmanger.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private  final TaskService taskService ;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks=taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TaskEntity> getTaskById(@PathVariable("id" ) Integer id){
        var task=taskService.getTaskbyID(id);
        if(task==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping()
    public  ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO taskDTO){
        var task=taskService.addtasks(taskDTO.getTitle(),taskDTO.getDescription(),taskDTO.getDeadline());
        return  ResponseEntity.ok(task);
    }
}
