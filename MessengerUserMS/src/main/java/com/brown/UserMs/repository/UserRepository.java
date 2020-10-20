package com.brown.UserMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brown.UserMs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
}
