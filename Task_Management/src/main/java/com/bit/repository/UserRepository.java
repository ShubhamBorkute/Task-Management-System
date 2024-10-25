package com.bit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
