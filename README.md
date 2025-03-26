# Library Management System

## Overview
This is a simple Java-based **Library Management System** that allows users to manage books in a library. Users can **add, update, delete, and search** for books.

## Features
- **Add a new book** with details like title, author, genre, and availability status.
- **Update book information** (title, author, genre, or availability status).
- **Delete a book** from the system.
- **View all books** in the library.
- **Search for books** by ID or title.

## Technologies Used
- **Java** (Core Java, OOP concepts)
- **Collections Framework** (HashMap for storage)
- **Scanner (User Input Handling)**

## Installation & Running the Application

### Prerequisites
- Install **Java 8 or later**

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/library-management.git
   cd library-management
   ```
2. **Compile the Java Files**
   ```sh
   javac -d out src/*.java
   ```
3. **Run the Application**
   ```sh
   java -cp out Main
   ```
   
## Example Usage
```
Enter Book ID to be Updated: 101
Which Field should you want to update?
1. Book Title
2. Book Author
3. Book Genre
4. Book Availability
5. Finish Update
Enter Choice: 1
Enter New Book Title: The Great Gatsby
Finish Update
```


