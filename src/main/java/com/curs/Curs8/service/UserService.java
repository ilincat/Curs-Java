package com.curs.Curs8.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curs.Curs8.entity.User;
import com.curs.Curs8.iservice.UserIService;
import com.curs.Curs8.repository.UserRepository;

@Service
public class UserService implements UserIService {
	@Autowired
	private UserRepository ur;

	@Override
	public Iterable<User> findAll() {
		return ur.findAll();
	}

	@Override
	public User save(User entity) {
		return ur.save(entity);
	}

	@Override
	public Optional<User> findById(Long primaryKey) {
		return ur.findById(primaryKey);
	}

	@Override
	public Long count() {
		return ur.count();
	}

	@Override
	public void delete(User entity) {
		ur.delete(entity);
	}

	@Override
	public boolean exists(Long primaryKey) {
		return ur.existsById(primaryKey);
	}

}
