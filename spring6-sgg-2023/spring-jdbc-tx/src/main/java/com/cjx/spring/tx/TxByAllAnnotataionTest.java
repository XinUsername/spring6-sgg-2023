package com.cjx.spring.tx;

import com.cjx.spring.tx.config.SpringConfig;
import com.cjx.spring.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxByAllAnnotataionTest {

    @Test
    public void testTxAllAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        bookController.buyBook(1,1);
    }
}
