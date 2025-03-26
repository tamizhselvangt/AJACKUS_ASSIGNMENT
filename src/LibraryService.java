import models.Book;

import java.util.ArrayList;

public interface LibraryService {

    public Book addBook(Book book);
    public Book getBookByID(int id);
    public Book getBookByTitle(String title);
    public Book updateBook(int id, Book book);
    public Book deleteBook(int id);
    public ArrayList<Book> getAllBooks();
}
