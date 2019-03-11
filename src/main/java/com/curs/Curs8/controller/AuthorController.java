package com.curs.Curs8.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curs.Curs8.entity.Author;
import com.curs.Curs8.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService as;

	@RequestMapping("/Author/all")
	@ResponseBody
	public Iterable<Author> findall() {
		return as.findAll();
	}

	@RequestMapping(value="/Author/save", method = RequestMethod.POST)
	@ResponseBody
	public Author save(@RequestBody Author entity) {
		return as.save(entity);
	}

	@RequestMapping("/Author/find/{id}")
	@ResponseBody
	public Optional<Author> findById(@PathVariable("id") Long id){
		return as.findById(id);
	}

	@RequestMapping("/Author/count")
	@ResponseBody
	public Long count() {
		return as.count();
	}

	@RequestMapping("/Author/delete")
	public void delete(@RequestBody Author entity) {
		as.delete(entity);
	}

	@RequestMapping("/Author/exists/{id}")
	@ResponseBody
	public boolean exists(@PathVariable("id") Long id) {
		return as.exists(id);
	}
}
