package com.kapil.project_management_system.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity

@Table(name = "task")  // Ensure the table name matches your database table name
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JsonIgnore 
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

	/*
	 * @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private Set<TaskAssignment> taskAssignments;
	 */

    // No-argument constructor
    public Task() {
    }

    // Parameterized constructor
    public Task(Long id, Project project, String name, String description, TaskStatus status,
                Set<TaskAssignment> taskAssignments) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.description = description;
        this.status = status;
       // this.taskAssignments = taskAssignments;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

	/*
	 * public Set<TaskAssignment> getTaskAssignments() { return taskAssignments; }
	 * 
	 * public void setTaskAssignments(Set<TaskAssignment> taskAssignments) {
	 * this.taskAssignments = taskAssignments; }
	 */

    public enum TaskStatus {
        PENDING, IN_PROGRESS, COMPLETED, task
    }

	@Override
	public String toString() {
		return "Task [id=" + id + ", project=" + project + ", name=" + name + ", description=" + description
				+ ", status=" + status + "]";
	}
    
    
    
}
