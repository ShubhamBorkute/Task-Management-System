package com.kapil.project_management_system.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
//@Table(name = "resource")
public class Resource {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "status")
	    private ResourceStatus status;

	    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<TaskAssignment> taskAssignments;
	    
	    public enum ResourceStatus {
	        AVAILABLE, UNAVAILABLE
	    }

	    public Resource() {
	        this.id = 0L;
	        this.name = "";
	        this.status = ResourceStatus.AVAILABLE; // Set a default status
	        this.taskAssignments = new ArrayList<>(); // Initialize with an empty list
	    }

	    
		public Resource(Long id, String name, ResourceStatus status, List<TaskAssignment> taskAssignments) {
			super();
			this.id = id;
			this.name = name;
			this.status = status;
			this.taskAssignments = (List<TaskAssignment>) taskAssignments;
		}


		// Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public ResourceStatus getStatus() {
	        return status;
	    }

	    public void setStatus(ResourceStatus status) {
	        this.status = status;
	    }

	    public List<TaskAssignment> getTaskAssignments() {
	        return taskAssignments;
	    }

	    public void setTaskAssignments(List<TaskAssignment> taskAssignments) {
	        this.taskAssignments = taskAssignments;
	    }
	    
	    
	}

