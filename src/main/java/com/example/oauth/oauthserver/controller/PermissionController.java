package com.example.oauth.oauthserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oauth.oauthserver.domain.Permission;
import com.example.oauth.oauthserver.repository.PermissionRepository;

@Controller
@RequestMapping("/perm")
public class PermissionController {

	@Autowired
	PermissionRepository repository;
	
	@ResponseBody
	@RequestMapping("/create")
	public Permission create(@RequestParam(name="name",defaultValue="",required=true)String permissionName){
		Permission permission = new Permission();
		permission.setPermissionName(permissionName);
		permission.setPermissionDescription(permissionName);
		repository.saveAndFlush(permission);
		return permission;
	}
}
