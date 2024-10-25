package com.bit.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.entity.TaskEntity;
import com.bit.entity.TaskStatus;
import com.bit.entity.UserEntity;
import com.bit.service.TaskService;
import com.bit.service.UserEntityService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserEntityService userEntityService;
    
    @PostMapping("/addtask")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
    	task.setStatus  (TaskStatus.CREATED.toString());
        TaskEntity createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskEntity>> getAllTasks(Model model) {
        List<TaskEntity> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks); // Add tasks to the model
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }


    @GetMapping("/task/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id, Model model) {
        Optional<TaskEntity> task = taskService.getTaskById(id);
        return new ResponseEntity<>(task.get(),HttpStatus.OK);
    }


    @PutMapping("task/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @RequestBody TaskEntity updatedTask) {
        TaskEntity task = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
    	
        return new ResponseEntity<>(userEntityService.addUser(user), HttpStatus.CREATED);
    }
    
    
    @PostMapping("task/{taskId}/users")
    public ResponseEntity<TaskEntity> assignUsers(@PathVariable Long taskId, @RequestBody Set<Long> userIds) {
        TaskEntity updatedTask = taskService.assignUsersToTask(taskId, userIds);
        return ResponseEntity.ok(updatedTask);
    }
}
