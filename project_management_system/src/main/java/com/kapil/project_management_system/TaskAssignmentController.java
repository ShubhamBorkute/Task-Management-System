package com.kapil.project_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.project_management_system.Services.TaskService;

@RestController
@RequestMapping("/taskassignments")
public class TaskAssignmentController {
	
	@Autowired
    private TaskService taskService;

    @PostMapping("/assign-task")
    public ResponseEntity<String> assignResourceToTask(@RequestParam Long taskId,@RequestParam Long resourceId) 
    {
        try {
            taskService.assignResourceToTask(taskId, resourceId);
            return ResponseEntity.ok("Resource assigned to task successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
