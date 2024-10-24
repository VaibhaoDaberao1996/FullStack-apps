package com.SmallRestApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmallRestApp.Entity.User;
import com.SmallRestApp.UserRepository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository user_repo;
	
	//save
	public String save_user(User user) {
		 user_repo.save(user);
		 return "User with email :"+user.getEmail()+" saved successfully";
	}
	
	//get-single
	public User get_user(String email) {
		return user_repo.findByEmail(email).orElse(null);
	}
	
	//get-all
	public List<User> get_allUsers(){
		return user_repo.findAll();
	}
	
	//delete
	public String delete_user(String email) {
		User user = get_user(email);
		user_repo.delete(user);
		return "User with email :"+email+" is deleted succesfully";
	}
	
	//update
	public User update_user(User user,String email) {
		User dbUser = get_user(email);
		dbUser.setName(user.getName());
		dbUser.setEmail(user.getEmail());
		dbUser.setAge(user.getAge());
		dbUser.setCity(user.getCity());
		
		 return user_repo.save(dbUser);
	
	}
	
}
