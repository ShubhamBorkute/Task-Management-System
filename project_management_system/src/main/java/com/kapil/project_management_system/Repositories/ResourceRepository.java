package com.kapil.project_management_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.project_management_system.entities.Resource;

//@Repository
//public interface ResourceRepository extends JpaRepository<Resource, Long> {
//	
//	
//}


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.kapil.project_management_system.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    // Define query methods if needed
}
