package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.beans.User;
import com.rest.dao.UserDAO;


@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/users")
	public List getCustomers() {
		return userDAO.list();
	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity getUser(@PathVariable("id") Integer id) {

		User user = userDAO.getUser(id);
		if (user == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping(value = "/createuser")
	public ResponseEntity createUser(@RequestBody User user) {

		userDAO.create(user);

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {

		if (null == userDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user) {

		user = userDAO.update(id, user);

		if (null == user) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

}