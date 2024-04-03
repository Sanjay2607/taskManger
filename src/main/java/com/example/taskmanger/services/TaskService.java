package com.example.taskmanger.services;

import com.example.taskmanger.entities.TaskEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService
{
    private ArrayList<TaskEntity> tasks=new ArrayList<>();

    private  int taskId=1;
      public TaskEntity addtasks(String Title, String Description, String deadline){
        TaskEntity task=new TaskEntity();
        task.setId(taskId);
        task.setTitle(Title);
        task.setDescription(Description);
//        task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        taskId++;
        return  task;
    }

    public ArrayList<TaskEntity> getTasks(){
          return tasks;
    }

    public TaskEntity getTaskbyID(int Id){
//            tasks.stream().findAny().filter(task->task.getId()==Id).orElse(null)
          for (TaskEntity task:tasks ){
              if(task.getId()==Id)
                    return  task;
          }
          return null;

    }

}
