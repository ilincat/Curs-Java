package com.curs.Curs8.iservice;

import java.util.Optional;

import com.curs.Curs8.entity.User;

public interface UserIService {
	public Iterable<User> findAll();

	public User save(User entity);

	public Optional<User> findById(Long primaryKey);

	public Long count();

	public void delete(User entity);

	public boolean exists(Long primaryKey);
}
