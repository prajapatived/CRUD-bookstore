package com.main.Bookstore.controller;

import com.main.Bookstore.entity.Book;
import com.main.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public ModelAndView home(){
        List<Book> list= service.getAllBook();
        ModelAndView m=new ModelAndView();
        m.setViewName("home");
        m.addObject("book", list);
        return m;
    }

    @GetMapping("/save")
    public String save(){
        return "savebook";
    }

    @PostMapping("/saveuser")
    public String saveuser(@ModelAttribute Book book){
        service.save(book);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        service.deleteByID(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editbook(@PathVariable("id") int id, Model model){
        Book b=service.getBoodById(id);
        model.addAttribute("book",b);
        return "edit";
    }
}
