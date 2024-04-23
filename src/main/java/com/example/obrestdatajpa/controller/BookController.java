package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
    //Atributos
    private BookRepository bookRepository;
    //Constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //CRUD sobre la entidad Book

    //Buscar todos los libros que hay en bases de datos(arraylist(Lista de libros)
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
    @Operation(summary = "Buscar un libro por clave primaria id Long")//Da instrucciones en la Api sobre lo que hace
    public ResponseEntity <Book> findOneById(@Parameter(description = "Clave primaria tipo long") @PathVariable Long id){
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

    /**
     * Crear un nuevo libro en base de datos
     *Metodo POST, no colisiona con FindAll porque son diferentes metodos HTTP
     * @param book
     * @param Headers
     * @return
     */
    //crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders Headers){
        //Guardar libro recibido por parametro en la base de datos
        System.out.println(Headers.get("User-Agent"));
        if (book.getId() != null) {//Quiere decir que el id existe y por lo tanto no es una creacion
            log.warn("trying to creaare a book with id");
            System.out.println("trying to creaare a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);//se genera el libro devuelto con la primary key
    }

    /**
     * Actualizar un libro en bases de datos
     */
    //actualizar un libro existente en base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null){//si no tiene id quiere decir que si es una creacion
            log.warn("Trying to update a non ecistent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
       // return bookRepository.save(book);
        return ResponseEntity.ok(result);
    }
    @Hidden
    @DeleteMapping("/api/books/{id}")//borrar un libro en base de datos
    public ResponseEntity<Book> deleted(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @Hidden//Se esconde el metodo para que no aparezca en la documentacion de swagger
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> Deleteall(){
        log.info("REST Request for deleta all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
