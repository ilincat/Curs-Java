package com.curs.Curs8.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curs.Curs8.entity.Book;
import com.curs.Curs8.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bs;

	@RequestMapping("/Book/all")
	@ResponseBody
	public Iterable<Book> findall() {
		return bs.findAll();
	}

	@RequestMapping(value = "/Book/save", method = RequestMethod.POST)
	@ResponseBody
	public Book save(@RequestBody Book entity) {
		return bs.save(entity);
	}

	@RequestMapping("/Book/find/{id}")
	@ResponseBody
	public Optional<Book> findById(@PathVariable("id") Long id) {
		return bs.findById(id);
	}

	@RequestMapping("/Book/count")
	@ResponseBody
	public Long count() {
		return bs.count();
	}

	@RequestMapping("/Book/delete")
	public void delete(@RequestBody Book entity) {
		bs.delete(entity);
	}

	@RequestMapping("/Book/exists/{id}")
	@ResponseBody
	public boolean exists(@PathVariable("id") Long id) {
		return bs.exists(id);
	}
}
