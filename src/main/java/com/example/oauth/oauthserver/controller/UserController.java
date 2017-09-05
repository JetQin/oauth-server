package com.example.oauth.oauthserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	UserRepository repository;
	

	@ResponseBody
	@RequestMapping("/findByName")
	public User getUser(@RequestParam(name="username")String username){
		return repository.findByName(username);
	}
}
