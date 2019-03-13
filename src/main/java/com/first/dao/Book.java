 package com.first.dao;

 import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data

@Entity
 public class Book {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;

     @ManyToOne
     @JoinColumn
     private BookCategory bookCategory;

     public Book(String name) {
         this.name = name;
     }
 }
