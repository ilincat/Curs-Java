package com.curs.Curs8.iservice;

import java.util.Optional;

import com.curs.Curs8.entity.Author;

public interface AuthorIService {
	public Iterable<Author> findAll();

	public Author save(Author entity);

	public Optional<Author> findById(Long primaryKey);

	public Long count();

	public void delete(Author entity);

	public boolean exists(Long primaryKey);
}
