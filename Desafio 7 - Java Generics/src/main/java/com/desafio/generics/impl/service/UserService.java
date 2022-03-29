package com.desafio.generics.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.generics.generic.service.GenericService;
import com.desafio.generics.impl.entity.User;
import com.desafio.generics.impl.repository.UserRepository;

@Service
public class UserService extends GenericService<User, Long> {

	@Autowired
	public UserService(UserRepository repository) {
		super(repository);
	}	

}
