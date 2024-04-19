package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    /**
     * request
     * respone
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity <Book> findOneById(@PathVariable Long id){
        Optional<Book> booOpt= bookRepository.findById(id);
       //Opcion 1

        if (booOpt.isPresent()){
            return ResponseEntity.ok(booOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }
        //opcion 2 = hace lo mismo que la primera opcion
        //return booOpt.orElse(null);
      }
    //crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book){
        //Guardar libro recibido por parametro en la base de datos
        return bookRepository.save(book);
    }
    //actualizar un libro existente en base de datos
    //borrar un libro en base de datos

}
