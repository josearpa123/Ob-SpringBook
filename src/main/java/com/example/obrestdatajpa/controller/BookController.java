package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    //Atributos
    private BookRepository bookRepository;
    //Constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //CRUD sobre la entidad Book

    //Buscar todos los libros(Lista de libros)
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //recuperar y devolver los libros de base base de datos
        return bookRepository.findAll();
    }
    //Buscar un solo libro en base de datos
    //public Book findOneById(Long id){

    //}
    //crear un nuevo libro en base de datos
    //actualizar un libro existente en base de datos
    //borrar un libro en base de datos

}
