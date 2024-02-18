package com.cjx.spring.tx;

import com.cjx.spring.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TxByAnnotataionTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
//        bookController.buyBook(1,1);
        Integer[] bookids = {1,2};
        bookController.checkout(bookids,1);
    }

}
