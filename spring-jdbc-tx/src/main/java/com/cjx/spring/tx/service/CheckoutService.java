package com.cjx.spring.tx.service;

public interface CheckoutService {
    void checkout(Integer[] bookIds, Integer userId);
}
