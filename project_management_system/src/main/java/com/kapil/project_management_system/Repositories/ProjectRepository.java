package com.kapil.project_management_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.project_management_system.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	boolean existsById(Long id);
}
