package com.bit.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.entity.TaskEntity;
import com.bit.entity.UserEntity;
import com.bit.repository.TaskRepository;
import com.bit.repository.UserRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	public TaskEntity createTask(TaskEntity task) {
		return taskRepository.save(task);
	}

	public List<TaskEntity> getAllTasks() {
		return taskRepository.findAll();
	}

	public Optional<TaskEntity> getTaskById(Long id) {
		return taskRepository.findById(id);
	}

	public TaskEntity updateTask(Long id, TaskEntity updatedTask) {
		updatedTask.setTaskId(id);
		return taskRepository.save(updatedTask);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	
	
	 public TaskEntity assignUsersToTask(Long taskId, Set<Long> userIds) {
	        TaskEntity task = taskRepository.findById(taskId).orElseThrow();
	        Set<UserEntity> users = userIds.stream()
	                                  .map(userRepository::findById)
	                                  .filter(Optional::isPresent)
	                                  .map(Optional::get)
	                                  .collect(Collectors.toSet());
	        task.setUsers(users);
	        return taskRepository.save(task);
	    }
}
