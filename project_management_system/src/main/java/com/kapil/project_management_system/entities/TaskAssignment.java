package com.kapil.project_management_system.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "taskassignment")
public class TaskAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource; // Updated to Resource if that is the correct class name

	@Column(name = "allocation_date")
	private LocalDateTime allocationDate;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Resource getResource() {
		return resource; // Updated to Resource
	}

	public void setResource(Resource resource) {
		this.resource = resource; // Updated to Resource
	}

	public LocalDateTime getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(LocalDateTime allocationDate) {
		this.allocationDate = allocationDate;
	}
}
