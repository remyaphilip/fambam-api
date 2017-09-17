package com.fambam.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fambam.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
