package com.cjx.spring.tx.service.impl;

import com.cjx.spring.tx.service.BookService;
import com.cjx.spring.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    // 一次性购买多本书
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(bookId,userId);
        }
    }
}
