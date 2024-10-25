package com.kapil.project_management_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.project_management_system.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
