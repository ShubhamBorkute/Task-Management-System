package com.kapil.project_management_system.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.project_management_system.Repositories.ResourceRepository;
import com.kapil.project_management_system.entities.Project;
import com.kapil.project_management_system.entities.Resource;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository rrepo;

    public ArrayList<Resource> findAll() {
        return (ArrayList<Resource>) rrepo.findAll();
    }
    
    public Resource saveResource(Resource resource) {
        return rrepo.save(resource);
    }
    
    public void deleteResource(Long id) {
        rrepo.deleteById(id);
    }
    
    
    public Resource updateResource(Long id, Resource updatedResource) {
        if (rrepo.existsById(id)) {
            (updatedResource).setId(id); // Ensure the ID is set for the update operation
            return rrepo.save(updatedResource);
        }
        return null; // Or handle the case where the resource does not exist
    }
    
    
    public boolean existsById(Long id) {
        return rrepo.existsById(id);
    }
}
