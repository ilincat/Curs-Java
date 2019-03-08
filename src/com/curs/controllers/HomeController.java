package com.curs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curs.beans.Author;
import com.curs.beans.Book;
import com.curs.beans.User;
import com.curs.db.DbConnection;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("invalid", null);
		model.addAttribute("duplicate", null);
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
		return "userPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model) {
		DbConnection.getInstance();
		if (DbConnection.exists(user.getUsername())
				&& DbConnection.getPassword(user.getUsername()).equals(user.getPassword()))
			return "redirect: user";
		else {
			model.addAttribute("invalid", "Username or password is invalid.");
			return "home";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, Model model) {
		DbConnection.getInstance();
		if (!DbConnection.exists(user.getUsername())) {
			DbConnection.addUser(user.getUsername(), user.getPassword());
			return "redirect: user";
		} else {
			model.addAttribute("duplicate", "Username already exists.");
			return "home";
		}
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	public String newBook(Book book, Model model) {
		DbConnection.getInstance();
		DbConnection.addBook(book.getTitle(), book.getAuthorId(), book.getYear());
		return "redirect: user";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook(Book book, Model model) {
		return "addBook";

	}

	@RequestMapping(value = "/newAuthor", method = RequestMethod.POST)
	public String newAuthor(Author author, Model model) {
		DbConnection.getInstance();
		DbConnection.addAuthor(author.getFirstName(), author.getLastName());
		return "redirect: user";
	}

	@RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
	public String addAuthor(Author author, Model model) {
		return "addAuthor";

	}

	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
	public String listBooks(Model model) {
		DbConnection.getInstance();
		model.addAttribute("books", DbConnection.getAllBooks());
		return "listBooks";

	}

	@RequestMapping(value = "/listAuthors", method = RequestMethod.GET)
	public String listAuthors(Model model) {
		DbConnection.getInstance();
		model.addAttribute("authors", DbConnection.getAllAuthors());
		return "listAuthors";

	}
}
