package com.kapil.project_management_system;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.project_management_system.Services.ProjectService;
import com.kapil.project_management_system.Services.TaskService;
import com.kapil.project_management_system.entities.Project;
import com.kapil.project_management_system.entities.Task;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService ts;

	@Autowired
	private ProjectService projectService;

	@GetMapping("/showTask")
	public ArrayList<Task> getAllTask() {
		
		return ts.findAllTask();
	}

//    @PostMapping("/createTask")
//    public ResponseEntity<String> createTask(@Valid @RequestBody Task task) {
//        // Validate project ID existence
//        if (task.getProject() == null || !ts.existsById(task.getProject().getId())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Invalid project ID or project does not exist.");
//        }
//
//        try {
//            Task createdTask = ts.saveTask(task);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully with ID: " + createdTask.getId());
//        } catch (Exception e) {
//            // Handle exception
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Error creating task: " + e.getMessage());
//            }
//        }

	@PostMapping("/createTask/{id}")
	public ResponseEntity<String> createTask(@Valid @RequestBody Task taskRequest, @PathVariable Long id) {

		System.out.println(taskRequest);

		System.out.println(id);
		// Validate project ID existence

		if (!projectService.existsById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid project ID or project does not exist.");
		}

		try {
			Task task = new Task();
			
			Optional<Project> optionalProject = projectService.findById(id);

			if (optionalProject.isPresent()) {
				Project project = optionalProject.get();
				System.out.println(project);
				task.setProject(project);
				task.setName(taskRequest.getName());
				task.setDescription(taskRequest.getDescription());

				// Convert status from String to TaskStatus enum
				try {
					Task.TaskStatus status = Task.TaskStatus.PENDING;// values(task.getStatus()) ;//
																		// (taskRequest.getStatus());
					task.setStatus(status);
				} catch (IllegalArgumentException e) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid status value.");
				}

				Task createdTask = ts.saveTask(task);
				System.out.println(createdTask);
				return ResponseEntity.status(HttpStatus.CREATED)
						.body("Task created successfully with ID: " + createdTask.getId());
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Project not found.");
			}
		} catch (Exception e) {
			// Handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error creating task: " + e.getMessage());
		}
	}

	@GetMapping("/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        try {
            Task task = ts.getTaskById(id);  
            return ResponseEntity.ok(task);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);  // Or return a custom error message
        }
    }

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		try {
			ts.deleteTask(id);
			return ResponseEntity.ok("Task with ID " + id + " was successfully deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with ID " + id + " not found.");
		}
	}
}
