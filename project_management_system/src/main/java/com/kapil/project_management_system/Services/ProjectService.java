package com.kapil.project_management_system.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.project_management_system.Repositories.ProjectRepository;
import com.kapil.project_management_system.entities.Project;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository pr;;

    public ArrayList<Project> findAll() {
        return (ArrayList<Project>) pr.findAll();
    }
    
    public Project saveProject(Project project) {
        return pr.save(project);
    }
    
    public void deleteProject(Long id) {
        pr.deleteById(id);
    }
    
    
    public Project updateProject(Long id, Project updatedProject) {
        if (pr.existsById(id)) {
            updatedProject.setId(id); // Ensure the ID is set for the update operation
            return pr.save(updatedProject);
        }
        return null; // Or handle the case where the project does not exist
    }

 // Method to check if a project exists by its ID
    public boolean existsById(Long id) {
        return pr.existsById(id);
    }

    // Method to find a project by its ID
    public Optional<Project> findById(Long id) {
        return pr.findById(id);
    }
}
