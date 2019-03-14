package com.curs.Curs9.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curs.Curs9.entity.Author;
import com.curs.Curs9.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByAuthor(Author author, Pageable pageable);

}
