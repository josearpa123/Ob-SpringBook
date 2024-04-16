package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);
        //CRUD
        //crear un libro
        Book book = new Book(null, "Homo Deus", "Yuval noah",
                450, 29.92,
                LocalDate.of(2024,04,12), true);

        Book book2 = new Book(null, "Homo Sapiens", "Yuval noah",
                450, 19.92,
                LocalDate.of(2013,04,12), true);
        System.out.println("numero de libros: "+ repository.count());
        //almacenar un libro
        repository.save(book);
        repository.save(book2);
        //recuperar todos los libros
        System.out.println("Numero de libros: "+repository.count());

        //borrar un libro
        //repository.deleteById(1L);
        System.out.println(repository.count());

    }

}
