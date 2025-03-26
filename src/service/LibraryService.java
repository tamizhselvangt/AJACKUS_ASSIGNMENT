package service;

import models.Book;

import java.util.List;

public interface LibraryService {
    /* * Add the Book to Library*/
    public void addBook(Book book);
    // * Find the Book By Book ID
    public Book getBookByID(int id);
    // * Find the Book By Book Title
    public List<Book> getBookByTitle(String title);
    // * Update the Book By Book ID
    public void updateBook(int id, Book book);
    // * Delete the Book By Book ID
    public void deleteBook(int id);
    // * Find All Books in the Library
    public void getAllBooks();
    // * Check the Book is Present or Not
    public boolean isBookPresent (int id);
}
