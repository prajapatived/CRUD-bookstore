package com.main.Bookstore.service;

import com.main.Bookstore.entity.Book;
import com.main.Bookstore.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private Repository repository;

    public void save(Book b){
        repository.save(b);
    }

    public List<Book> getAllBook(){
        return repository.findAll();
    }

    public void deleteByID(int id){
       repository.deleteById(id);
    }

    public Book getBoodById(int id){
        return repository.findById(id).get();
    }
}
