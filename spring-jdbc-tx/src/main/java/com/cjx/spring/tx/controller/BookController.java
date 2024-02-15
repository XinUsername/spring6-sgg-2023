package com.cjx.spring.tx.controller;

import com.cjx.spring.tx.service.BookService;
import com.cjx.spring.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class BookController{

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }

    public void checkout(Integer[] bookIds, Integer userId){
        checkoutService.checkout(bookIds,userId);
    }
}
