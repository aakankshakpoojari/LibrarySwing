package model;
import java.util.Objects;

public abstract class Book {
    private String isbn, title, author;
    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn; this.title = title; this.author = author;
    }
    
    
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    
    public abstract String getCategory();  // Abstraction
    
    @Override
    public boolean equals(Object o) {  // Polymorphism via override
        return o instanceof Book && isbn.equals(((Book)o).isbn;
    }
    
    @Override
    public String toString() {
        return title + " by " + author + " [" + getCategory() + "]";
    }
}

