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
import com.curs.Curs9.entity.Book;
import com.curs.Curs9.repository.AuthorRepository;
import com.curs.Curs9.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository br;
	@Autowired
	private AuthorRepository ar;

	@GetMapping("/books")
	public Page<Book> getAllAuthors(Pageable pageable) {
		return br.findAll(pageable);
	}

	@GetMapping("/authors/{id}/books")
	public Page<Book> getAllBooks(Pageable pageable, @PathVariable Long id) {
		Optional<Author> author = ar.findById(id);
		if (author.isPresent()) 
			return br.findByAuthor(author.get(), pageable);
		return null;
	}

	@PostMapping("/authors/{authorId}/books")
	public Book createBook(@PathVariable Long authorId, @Valid @RequestBody Book book) {
		Optional<Author> author = ar.findById(authorId);
		if (author.isPresent()) {
			book.setAuthor(author.get());
			return br.save(book);
		} else
			throw new NoSuchElementException("No author with id " + authorId + " was found");
	}

	@PostMapping("/books/{id}")
	public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book uBook) {
		Optional<Book> book = br.findById(id);
		if (book.isPresent()) {
			if (uBook.getTitle() != null && !uBook.getTitle().equals(""))
				book.get().setTitle(uBook.getTitle());
			if (uBook.getYear() != null)
				book.get().setYear(uBook.getYear());
			return br.save(book.get());
		} else
			throw new NoSuchElementException("No book with id " + id + " was found");
	}

	@GetMapping("/books/{id}/delete")
	public void deleteBook(@PathVariable Long id) {
		br.deleteById(id);
	}
}
