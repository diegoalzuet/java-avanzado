package com.desafio.generics.impl.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.generics.generic.controller.GenericController;
import com.desafio.generics.generic.service.GenericService;
import com.desafio.generics.impl.entity.User;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User,Long> {

	protected UserController(GenericService<User, Long> service) {
		super(service);		
	}	
	
}
