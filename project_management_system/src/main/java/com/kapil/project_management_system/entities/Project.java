package com.kapil.project_management_system.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	 
	 @Column(name="name")
	 private String name;
	 
	 @Column(name="description")
	 private String description;

     @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
     private Set<Task> tasks;
     
     
     
	 public Project() {
		id=0L;
		name="";
		description="";
	 }
	 
	 
	 public Project(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.tasks = tasks;
	 }



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

	 public String getDescription() {
		return description;
	 }

	 public void setDescription(String description) {
		this.description = description;
	 }

	 public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	 }
	 
	 public Set<Task> getTasks() {
	 		return tasks;
	 }


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", tasks=" + tasks + "]";
	}
	     
 
	}

