package models;

public class Book {
    private String isbn; //(unique id)
    private String title;
    private String author;
    private String genre;
    private int copies;

    public Book(String isbn, String title, String author, String genre, int copies) {
        if (isbn.isEmpty() || isbn == null) {
            throw new IllegalArgumentException("ISBN is null or empty");
        }
        if(copies < 0) {
            throw new IllegalArgumentException("Copies is negative");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.copies = copies;
    }
//    public Book(String title, String author, String genre) {
//        this("00000", title, author, genre,0);
//    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        if(isbn.isEmpty() || isbn == null) {
            System.out.println("Invalid ISBN");
        }
        else {
            this.isbn = isbn;
        }
    }
    public int getCopies(){
        return this.copies;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public void setCopies(int copies){
        if(copies < 0){
            System.out.println("Invalid number of copies");
        }
        else{
            this.copies = copies;
        }
    }
    public void setTitle(String title) {
        if(title.isEmpty() || title == null) {
            System.out.println("Invalid title");
        }
        else {
            this.title = title;
        }
    }
    public void setAuthor(String author) {
        if(author.isEmpty() || author == null) {
            System.out.println("Invalid author");
        }
        else {
            this.author = author;
        }
    }
    public void setGenre(String genre) {
        if(genre.isEmpty() || genre == null) {
            System.out.println("Invalid genre");
        }
        else {
            this.genre = genre;
        }
    }
    @Override
    public boolean equals(Object obj){
        // If both the objects are referencing to the same memory address then return true
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return this.isbn.equals(book.isbn);
    }
    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }
    @Override
    public String toString() {
        return "Book[" + this.title + ", " + this.author + ", " + this.genre + "]" + "isbn: " +  this.isbn;
    }
}

