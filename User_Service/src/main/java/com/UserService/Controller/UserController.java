package com.UserService.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Value("${app.message}")
	private String msg;
	@GetMapping("/hello")
	public String getHelloUser() {
		return "Hello from user of " +msg;
	}
}
