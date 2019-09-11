package com.example.businessdemo.entity;

import lombok.Data;

@Data
public class Book {

    private int id;
    private String name;
    private String author;
    private int year;
    private double price;

    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", year=" + year + ", price=" + price + "]";
    }
}
