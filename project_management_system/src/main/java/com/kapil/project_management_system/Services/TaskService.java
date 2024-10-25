package com.kapil.project_management_system.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.kapil.project_management_system.Repositories.ResourceRepository;
import com.kapil.project_management_system.Repositories.TaskAssignmentRepository;
import com.kapil.project_management_system.Repositories.TaskRepository;
import com.kapil.project_management_system.entities.Project;
import com.kapil.project_management_system.entities.Task;
import com.kapil.project_management_system.entities.TaskAssignment;
import com.kapil.project_management_system.entities.Resource;
import com.kapil.project_management_system.entities.Resource.ResourceStatus;

@Service
public class TaskService {

    @Autowired
    private TaskRepository tr;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    public TaskAssignment assignResourceToTask(Long taskId, Long resourceId) {
        Resource resource = (Resource) resourceRepository.findById(resourceId)
            .orElseThrow(() -> new NoSuchElementException("Resource not found"));

        Task task = tr.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
        
//     // Ensure the resource is available
//        if (resource.getStatus() != ResourceStatus.AVAILABLE) {
//            throw new IllegalStateException("Resource is available.");
//        }
        
        // Check resource status
        if (resource.getStatus() == ResourceStatus.UNAVAILABLE) {
            throw new IllegalStateException("Resource is not available for assignment");
        }
        
        
     // Find existing assignments for the resource in the same project
        List<TaskAssignment> assignments = taskAssignmentRepository.findByResourceAndTask_Project(resource, task.getProject());


        // Check current assignments
        long activeAssignments = taskAssignmentRepository.countByResourceIdAndTaskProjectId(resourceId, task.getProject().getId());
        if (activeAssignments >= 2) {
            throw new IllegalStateException("Resource already assigned to 2 tasks in the project.");
        }

        // Assign resource to task
        TaskAssignment assignment = new TaskAssignment();
        assignment.setTask(task);
        assignment.setResource(resource);
        return taskAssignmentRepository.save(assignment);
        
    }


    public ArrayList<Task> findAllTask() {
        return (ArrayList<Task>) tr.findAll();
    }

    public Task saveTask(Task task) {
        return tr.save(task);
    }

    public void deleteTask(Long id) {
        if (!tr.existsById(id)) {
            throw new ResourceNotFoundException("Task with ID " + id + " not found.");
        }
        tr.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return tr.existsById(id);
    }
    
    public Task getTaskById(Long id) {
        return tr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found."));
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (tr.existsById(id)) {
            updatedTask.setId(id); 
            return tr.save(updatedTask);
        }
        throw new ResourceNotFoundException("Task with ID " + id + " not found.");
    }
}
