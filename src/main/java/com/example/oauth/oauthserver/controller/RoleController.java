package com.example.oauth.oauthserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oauth.oauthserver.domain.Role;
import com.example.oauth.oauthserver.repository.RoleRepository;

@Controller
@RequestMapping("/role")
public class RoleController {

	
	@Autowired
	RoleRepository repository;
	
	@ResponseBody
	@RequestMapping("/create")
	public Role createUser(@RequestParam(name="role",required=true,defaultValue="")String roleName,
			@RequestParam(name="description",required=true,defaultValue="")String description){
		Role role = new Role();
		role.setRoleName(roleName);
		role.setRoleDescription(description);
		return repository.save(role);
	}

	@ResponseBody
	@RequestMapping("/list")
	public List<Role> getRole(){
		return repository.findAll();
	}
	
	
}
