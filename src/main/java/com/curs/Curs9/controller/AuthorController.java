package com.curs.Curs9.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curs.Curs9.entity.Author;
import com.curs.Curs9.repository.AuthorRepository;

@RestController
public class AuthorController {
	@Autowired
	private AuthorRepository ar;

	@GetMapping("/authors")
	public Page<Author> getAllAuthors(Pageable pageable) {
		return ar.findAll(pageable);
	}

	@PostMapping("/authors")
	public Author createAuthor(@Valid @RequestBody Author author) {
		return ar.save(author);
	}

	@PostMapping("/authors/{id}")
	public Author updateAuthor(@PathVariable Long id, @Valid @RequestBody Author uAuthor) {
		Optional<Author> author = ar.findById(id);
		if (author.isPresent()) {
			if (uAuthor.getFirstName() != null && !uAuthor.getFirstName().equals(""))
				author.get().setFirstName(uAuthor.getFirstName());
			if (uAuthor.getLastName() != null && !uAuthor.getLastName().equals(""))
				author.get().setLastName(uAuthor.getLastName());
			return ar.save(author.get());
		} else
			throw new NoSuchElementException("No author with id " + id + " was found");
	}

	@GetMapping("/authors/{id}/delete")
	public void deleteAuthor(@PathVariable Long id) {
		ar.deleteById(id);
	}
	
	@GetMapping("/authors/{id}")
	public Optional<Author> getAuthor(@PathVariable Long id) {
		return ar.findById(id);
	}
}
