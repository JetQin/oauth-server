package com.example.oauth.oauthserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oauth.oauthserver.domain.User;
import com.example.oauth.oauthserver.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository repository;
	
	@ResponseBody
	@RequestMapping("/create")
	public User createUser(@RequestParam(name="username",required=true,defaultValue="")String username,
			@RequestParam(name="password",required=true,defaultValue="")String password){
		User user = new User();
		user.setUsername(username);
		user.setPassword(encoder.encode(password));
		return repository.save(user);
	}

	@ResponseBody
	@RequestMapping("/findByName")
	public User getUserByName(@RequestParam(name="username")String username){
		return repository.findByName(username);
	}
	
	@ResponseBody
	@RequestMapping("/findById")
	public User getUserById(@RequestParam(name="id")Long id){
		return repository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<User> listUser(){
		return repository.findAll();
	}
	
}
