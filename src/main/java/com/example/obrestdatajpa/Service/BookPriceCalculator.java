package com.example.obrestdatajpa.Service;

import com.example.obrestdatajpa.entities.Book;

public class BookPriceCalculator {
    public double calculatePrice(Book book){
        double price = book.getPrice();
        if (book.getPrice() > 300){
            price += 5;
        }
        price += 2.99;
        return price;
    }
}
