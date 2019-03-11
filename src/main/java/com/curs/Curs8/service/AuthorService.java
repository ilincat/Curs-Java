package com.curs.Curs8.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curs.Curs8.entity.Author;
import com.curs.Curs8.iservice.AuthorIService;
import com.curs.Curs8.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorIService {
	@Autowired
	private AuthorRepository ar;

	@Override
	public Iterable<Author> findAll() {
		return ar.findAll();
	}

	@Override
	public Author save(Author entity) {
		return ar.save(entity);
	}

	@Override
	public Optional<Author> findById(Long primaryKey) {
		return ar.findById(primaryKey);
	}

	@Override
	public Long count() {
		return ar.count();
	}

	@Override
	public void delete(Author entity) {
		ar.delete(entity);
	}

	@Override
	public boolean exists(Long primaryKey) {
		return ar.existsById(primaryKey);
	}

}
