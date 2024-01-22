package com.main.Bookstore.repository;

import com.main.Bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Book, Integer> {
}
