package com.bit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
