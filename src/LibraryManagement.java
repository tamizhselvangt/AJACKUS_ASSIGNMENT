import models.AvailableStatus;
import models.Book;
import service.LibraryService;
import service.LibraryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    final LibraryService libraryService;

    //Constructor For injecting Library Service
    public LibraryManagement() {
        this.libraryService = new LibraryServiceImpl();
    }


    //Update Book Method
    public void updateBookFromClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to be Update: ");


        int bookId = scanner.nextInt();
        Book oldBook = libraryService.getBookByID(bookId);

        if(oldBook == null){
            return;
        }
        // Store the Old Values.
        String bookTitle = oldBook.getTitle();
        String bookAuthor = oldBook.getAuthor();
        String bookGenre = oldBook.getGenre();
        AvailableStatus bookAvailability = oldBook.getAvailableStatus();


        boolean flag = true;
        while(flag){
            System.out.println("Which Field should you want to update?");
            System.out.println("1. Book Title");
            System.out.println("2. Book Author");
            System.out.println("3. Book Genre");
            System.out.println("4. Book Availability");
            System.out.println("5. Finish Update");
            System.out.print("Enter Choice: ");
            int val = scanner.nextInt();
            //Avoid the Unwanted Scanner behaviour.
            scanner.nextLine();
            switch(val){
                case 1:
                    System.out.print("Enter Book Title: ");
                    bookTitle = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Book Author: ");
                    bookAuthor = scanner.nextLine();
                    break;
                case 3:
                   System.out.print("Enter Book Genre: ");
                   bookGenre = scanner.nextLine();
                   break;
                case 4:
                   System.out.print("Enter Book Availability choice:\n ");
                   System.out.printf("1. %s | 2. %s \n", AvailableStatus.Available,AvailableStatus.CheckedOut);
                   int availability = scanner.nextInt();
                   bookAvailability =  availability==1 ?
                       AvailableStatus.Available : AvailableStatus.CheckedOut ;
                   break;
                case 5:
                    System.out.println("Finish Update");
                    flag = false;
                    break;
                default:
                   System.out.println("Invalid Input. Retry");
                   break;
            }
        }


        //Update the new Value.
        oldBook.setTitle(bookTitle);
        oldBook.setAuthor(bookAuthor);
        oldBook.setGenre(bookGenre);
        oldBook.setAvailableStatus(bookAvailability);
        libraryService.updateBook(bookId, oldBook);

    }

    //Get Details from the Client
    public void storeBookFromClient() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (libraryService.isBookPresent(bookId)) {
                System.out.println("Book already exists");
                return;
            }

            System.out.print("Enter the book title: ");
            String bookTitle = scanner.nextLine().trim();

            System.out.print("Enter the book author: ");
            String bookAuthor = scanner.nextLine().trim();

            System.out.print("Enter the book genre: ");
            String bookGenre = scanner.nextLine().trim();

            System.out.printf("Choose the book availability status \n(1.%s | 2.%s): ",
                    AvailableStatus.Available, AvailableStatus.CheckedOut);
            int availability = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (availability < 1 || availability > 2) {
                System.out.println("Invalid choice for availability");
                return;
            }

            Book newBook = new Book(
                    bookId,
                    bookTitle,
                    bookAuthor,
                    bookGenre,
                    availability == 1 ? AvailableStatus.Available : AvailableStatus.CheckedOut
            );

            libraryService.addBook(newBook);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public static void main(String[] args){
        LibraryManagement libraryManagement = new LibraryManagement();

        Scanner sc = new Scanner(System.in);
        System.out.println("******* Welcome to the Library Management System *******");

        //Main Menu
        while (true){
            System.out.println("1. Add Book to a Library");
            System.out.println("2. Search Book by ID");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book from a Library");
            System.out.println("6. View All Books");
            System.out.println("7. Exit\n");
            System.out.print("Please enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                // * Add the new Book
                case 1:
                    libraryManagement.storeBookFromClient();
                    break;
                case 2:
                    // * Find By ID
                    System.out.print("Enter the book ID: ");
                    int bookId = sc.nextInt();
                    System.out.println(
                            libraryManagement.libraryService.getBookByID(bookId)
                    );
                    break;
                case 3:
                    // * Find By Title
                    sc.nextLine();
                    System.out.print("Enter the book title: ");
                    String bookTitle = sc.nextLine().trim();  // Read actual input
                    List<Book> foundBooks = libraryManagement.libraryService.getBookByTitle(bookTitle);

                    if (foundBooks.isEmpty()) {
                        System.out.println("No books found with title: " + bookTitle);
                    } else {
                        System.out.println("Books Found: " + foundBooks);
                    }
                    break;
                case 4:
                    // * Update Old Book
                    libraryManagement.updateBookFromClient();
                    break;
                case 5:
                    // * Delete Old Book
                    System.out.print("Enter the book ID for deletion: ");
                    int id = sc.nextInt();
                    libraryManagement.libraryService.deleteBook(id);
                    break;
                case 6:
                    // * View All Books
                    libraryManagement.libraryService.getAllBooks();
                    break;
                case 7:
                    // * Close the System
                    System.out.println("Thank you for using Library Management System");
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    // * Wrong Input
                    System.out.println("Wrong choice");
                    System.out.println("System Exiting...");
                    sc.close();
                    System.exit(0);

            }
            System.out.println();
        }
    }
}
