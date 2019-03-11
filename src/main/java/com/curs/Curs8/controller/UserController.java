package com.curs.Curs8.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curs.Curs8.entity.User;
import com.curs.Curs8.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService us;

	@RequestMapping("/User/all")
	@ResponseBody
	public Iterable<User> findall() {
		return us.findAll();
	}

	@RequestMapping(value="/User/save", method = RequestMethod.POST)
	@ResponseBody
	public User save(@RequestBody User entity) {
		return us.save(entity);
	}

	@RequestMapping("/User/find/{id}")
	@ResponseBody
	public Optional<User> findById(@PathVariable("id") Long id){
		return us.findById(id);
	}

	@RequestMapping("/User/count")
	@ResponseBody
	public Long count() {
		return us.count();
	}

	@RequestMapping("/User/delete")
	public void delete(@RequestBody User entity) {
		us.delete(entity);
	}

	@RequestMapping("/User/exists/{id}")
	@ResponseBody
	public boolean exists(@PathVariable("id") Long id) {
		return us.exists(id);
	}
}
