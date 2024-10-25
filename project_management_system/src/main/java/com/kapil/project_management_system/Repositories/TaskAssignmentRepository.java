package com.kapil.project_management_system.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.project_management_system.entities.Project;
import com.kapil.project_management_system.entities.Resource;
import com.kapil.project_management_system.entities.TaskAssignment;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {
	long countByResourceIdAndTaskProjectId(Long resourceId, Long projectId);
	List<TaskAssignment> findByResourceAndTask_Project(Resource resource, Project project);
}
