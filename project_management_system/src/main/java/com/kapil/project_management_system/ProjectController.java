package com.kapil.project_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kapil.project_management_system.Services.ProjectService;
import com.kapil.project_management_system.entities.Project;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService ps;
    
//    @GetMapping("/home")
//    public String home() {
//    	return "index.jsp";
//    }
    
    @GetMapping("/show")
    public ArrayList<Project> showProjects() {
    	
    	
        return ps.findAll();
    }

    @PostMapping("/add/data")
    public Project addProject(@RequestBody Project project) {
        return ps.saveProject(project);
    }

    
	/*
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<String>
	 * deleteProject(@PathVariable Long id) { try { ps.deleteProject(id); return
	 * ResponseEntity.ok("Project with ID " + id + " was successfully deleted."); }
	 * catch (Exception e) { return ResponseEntity.status(HttpStatus.NOT_FOUND)
	 * .body("Project with ID " + id + " not found."); } }
	 */
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        // Check if the project exists first
        if (ps.existsById(id)) {
            ps.deleteProject(id); // Delete if it exists
            return ResponseEntity.ok("Project with ID " + id + " was successfully deleted.");
        } else {
            // If project doesn't exist, return not found message
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID " + id + " not found.");
        }
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return ps.existsById(id) 
            ? ResponseEntity.ok("Project updated successfully.") 
            : ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Project with ID " + id + " not found.");
    }

}


