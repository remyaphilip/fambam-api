package com.fambam.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fambam.api.model.User;
import com.fambam.api.repository.UserRepository;
import com.fambam.api.web.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/admin/user/")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(UserDTO.build(users), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/user/")
	public ResponseEntity<List<UserDTO>> getAllUserDTO() {
		List<User> users = userRepository.findAll();
		log.info("Getting all users...");
		if (users.isEmpty()) {
			log.warn("no users in database");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		log.info(users.size() +" users found!");
		return new ResponseEntity<>(
				UserDTO.build(users), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/admin/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
	public ResponseEntity<UserDTO> getUserDTO(@PathVariable("id") Long id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(UserDTO.build(user), HttpStatus.OK);
	}

	@RequestMapping(method = { RequestMethod.POST }, path = "/user/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> save(@RequestBody User user) {
		
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = { RequestMethod.DELETE }, path = "/user/{id}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void delete(@PathVariable("id") Long id) {
		userRepository.delete(id);
	}
	
}
