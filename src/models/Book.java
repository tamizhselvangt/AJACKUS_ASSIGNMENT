package models;

public class Book {

   int id;
   String title;
   String author;
   String genre;
   AvailableStatus availableStatus;

    public Book (int id, String title, String author, String genre, AvailableStatus availableStatus) {

        if(title.isEmpty() || author.isEmpty() ) {
            System.out.println("Invalid input");
            System.out.println("Fields cannot be empty");
            return;
        }
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableStatus = availableStatus;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public String getGenre () {
        return genre;
    }

    public void setGenre (String genre) {
        this.genre = genre;
    }

    public AvailableStatus getAvailableStatus () {
        return availableStatus;
    }

    public void setAvailableStatus (AvailableStatus availableStatus) {
        this.availableStatus = availableStatus;
    }

    @Override
    public String toString () {
        return "Book(" +
                "ID: " + id +
                ", Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Genre: '" + genre + '\'' +
                ", Available Status: " + availableStatus +
                ')';

    }
}
