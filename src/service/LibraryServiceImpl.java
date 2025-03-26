package service;

import models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {

     Map<Integer, Book> library_books = new HashMap<>();

     //* Add the Book to the Library
    @Override
    public void addBook (Book book) {
        //Check if the Book is existing or Not
        if(library_books.containsKey(book.getId())){
            System.out.println("Book already exists");
            return;
        }

        // Empty or Invalid String Validation
        if(book.getTitle().isEmpty() || book.getAuthor().isEmpty() ) {
            System.out.println("Invalid input");
            System.out.println("Fields cannot be empty");
            return;
        }

        library_books.put(book.getId(), book);
        System.out.println("Successfully Added Book: " + book);
    }


    @Override
    public Book getBookByID (int id) {
        //Check the book is Present or Not.
        if(!library_books.containsKey(id)){
            System.out.println("Book does not exist");
            return null;
        }
        return library_books.get(id);
    }

    @Override
    public boolean isBookPresent (int id) {
        return library_books.containsKey(id);
    }

    @Override
    public List<Book> getBookByTitle (String title) {
        //Trim the White spaces if any
        String searchTitle = title.trim();

        //Create List for store all the Books with same Name
        List<Book> booksByTitle = new ArrayList<>();
        for(Book book : library_books.values()){
            // Check without cases
            if(book.getTitle().equalsIgnoreCase(searchTitle)){
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    @Override
    public void updateBook (int id, Book book) {
        //Check the Book Presence
        if(!library_books.containsKey(id)){
            System.out.println("Book does not exist");
            return;
        }
        //update the new Book
        library_books.put(id, book);
        System.out.println("Successfully Updated Book: " + book);
        library_books.get(id);
    }

    @Override
    public void deleteBook (int id) {
        // Check if the Book is Present
        if(!library_books.containsKey(id)){
            System.out.println("Book does not exist");
            return;
        }
        Book existingBook = library_books.get(id);
        library_books.remove(id);
        System.out.println("Successfully Deleted Book: " + existingBook);
    }

    @Override
    public void getAllBooks () {
        // Check Empty Books
        if(library_books.isEmpty()){
            System.out.println("There is no books in the library");
            return;
        }
        System.out.println();
        for (Book book : library_books.values()) {
            System.out.println(book);
        }

        System.out.println("Successfully Retrieved All Books");
    }


}
