package com.example.obrestdatajpa.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Books")
public class Book {
    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Clave ficticia autoincremental tipo Long")
    private Long id;
    private String title;
    private  String author;
    private Integer pages;
    @Schema(description = "Precion en  rupias, con dos decimeales utilizando . como separador")
    private Double price;
    private LocalDate realseDate;
    private Boolean online;
    //Constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate realseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.realseDate = realseDate;
        this.online = online;
    }
    //Getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRealseDate() {
        return realseDate;
    }

    public void setRealseDate(LocalDate realseDate) {
        this.realseDate = realseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
//tostring
}
