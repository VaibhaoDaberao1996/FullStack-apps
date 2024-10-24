package com.SmallRestApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SmallRestApp.Entity.User;
import com.SmallRestApp.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust according to your React app URL
@RequestMapping("/userForm/apis")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create
	@PostMapping("/users")
	public ResponseEntity<String> create_user(@RequestBody User user) {
		return ResponseEntity.ok(userService.save_user(user));
	}
	
	//show-single
	@GetMapping("/users/{email}")
	public ResponseEntity<User> show_user(@PathVariable String email) {
		return ResponseEntity.ok(userService.get_user(email));
	}
	
	//show-all
	@GetMapping("/users")
	public ResponseEntity<List<User>> show_allUser() {
		return ResponseEntity.ok(userService.get_allUsers());
	}
	
	//update
	@PatchMapping("/users/{email}")
	public ResponseEntity<User> update_user(@RequestBody User user, @PathVariable String email){
		return ResponseEntity.ok(userService.update_user(user, email));
	}
	
	//delete
	@DeleteMapping("/users/{email}")
	public ResponseEntity<String> delete_user(@PathVariable String email){
		return ResponseEntity.ok(userService.delete_user(email));
	}
}
