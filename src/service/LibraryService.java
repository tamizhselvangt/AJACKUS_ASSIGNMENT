package service;

import models.Book;

import java.util.List;

public interface LibraryService {

    public void addBook(Book book);
    public Book getBookByID(int id);
    public List<Book> getBookByTitle(String title);
    public void updateBook(int id, Book book);
    public void deleteBook(int id);
    public void getAllBooks();
    public boolean isBookPresent (int id);
}
