package com.example.oauth.oauthserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
}
