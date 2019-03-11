package com.curs.Curs8.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curs.Curs8.entity.Book;
import com.curs.Curs8.iservice.BookIService;
import com.curs.Curs8.repository.BookRepository;

@Service
public class BookService implements BookIService {
	@Autowired
	private BookRepository br;

	@Override
	public Iterable<Book> findAll() {
		return br.findAll();
	}

	@Override
	public Book save(Book entity) {
		return br.save(entity);
	}

	@Override
	public Optional<Book> findById(Long primaryKey) {
		return br.findById(primaryKey);
	}

	@Override
	public Long count() {
		return br.count();
	}

	@Override
	public void delete(Book entity) {
		br.delete(entity);
	}

	@Override
	public boolean exists(Long primaryKey) {
		return br.existsById(primaryKey);
	}

}
