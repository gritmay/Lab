package products;

import java.util.ArrayList;

public abstract class User {

    private String fullName;
    private ArrayList<Book> books = new ArrayList<>();

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    abstract void takeBook(ArrayList<Book> books);

}
