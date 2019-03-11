package com.curs.Curs8.iservice;

import java.util.Optional;

import com.curs.Curs8.entity.Book;

public interface BookIService {
	public Iterable<Book> findAll();

	public Book save(Book entity);

	public Optional<Book> findById(Long primaryKey);

	public Long count();

	public void delete(Book entity);

	public boolean exists(Long primaryKey);

}
