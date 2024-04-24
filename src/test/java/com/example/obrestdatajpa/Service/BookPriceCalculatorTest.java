package com.example.obrestdatajpa.Service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        //Configuracion de la prueba
        //Crear los escenarios para mirar comportamiento de testing
        Book book = new Book(1L, "El señor de los anillos","Author",10000, 20.90, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();
        //se ejecuta el comportamiento del testing
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        //Comprobaciones de que todos este bien aserciones
         assertTrue(price > 0);
         assertEquals(23.89000000, price);

    }
}