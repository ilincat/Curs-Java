package com.curs.Curs9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curs.Curs9.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}