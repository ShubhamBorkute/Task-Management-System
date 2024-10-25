package com.kapil.project_management_system;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kapil.project_management_system.Services.ResourceService;
import com.kapil.project_management_system.entities.Project;
import com.kapil.project_management_system.entities.Resource;


@RestController
@RequestMapping("/resources")
public class ResourceController {

	 @Autowired
	 private ResourceService rs;
	 
	 	@GetMapping("/show")
	    public ArrayList<Resource> showResource() {
	        // Logic to fetch all projects from the database
	        return rs.findAll();
	    }

	    @PostMapping("/add/resource")
	    public Resource addResource(@RequestBody Resource resource) {
	        return rs.saveResource(resource);
	    }

	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
	        try {
	            rs.deleteResource(id);
	            return ResponseEntity.ok("Resource with ID " + id + " was successfully deleted.");
	        } catch (Exception e) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("Resource with ID " + id + " not found.");        }
	    }
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
	        return rs.existsById(id) 
	            ? ResponseEntity.ok("Resource updated successfully.") 
	            : ResponseEntity.status(HttpStatus.NOT_FOUND)
	                            .body("Resource with ID " + id + " not found.");
	    }
}
