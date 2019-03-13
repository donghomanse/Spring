package com.dongho.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongho.accounts.entity.UserInfo;
import com.dongho.accounts.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/create")
    public UserInfo create() {
    	UserInfo users = new UserInfo();
    	
    	users.setUsername("donghomanse");
    	users.setPassword("rlaehdgh1!");
    	
    	return userService.create(users);
    }
    
}
