package com.brunojustino.restapi.controller;

import java.util.List;

import com.brunojustino.restapi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunojustino.restapi.repository.UsersRepository;

@RestController
public class UsersController {
	
	@Autowired
	UsersRepository repo;
	//get all the users
	//localhost:8080/users
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		 List<Users> users = repo.findAll();
		  return users;
	}
	
	//localhost:8080/users/1
	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable int id) {
		Users users = repo.findById(id).get();
		
		return users;
		
	}
	
	@PostMapping("/users/add")
	public ResponseEntity<Users> createUser(@RequestBody Users users) {
		Users newUsers = repo.save(users);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUsers);
		
	}
	
	@PutMapping("/users/update/{id}")
	public Users updateUsers(@PathVariable int id) {
	   Users users = repo.findById(id).get();
	   users.setName("poonam");
	   repo.save(users);
	   return users;
		
	}
	@DeleteMapping("/users/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeUser(@PathVariable int id) {
		Users users = repo.findById(id).get();
		repo.delete(users);
	}

}
