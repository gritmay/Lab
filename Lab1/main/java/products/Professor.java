package products;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Professor extends User {

    private String fullName;
    private ArrayList<Book> books = new ArrayList<>();

    public Professor(String fullName) {
        super(fullName);

    }

    @Override
    public void takeBook(ArrayList<Book> books) {
        ArrayList<Book> bk = new ArrayList<>(books);
        int quantityOfBooks = (int) Math.round(Math.random() * (10 - 3) + 3);
        for (int i = 1; i <= quantityOfBooks; i++) {
            int numberOfBook = (int) Math.round(Math.random() * (bk.size() - 1));
            this.books.add(bk.get(numberOfBook));
            bk.remove(numberOfBook);
        }

    }

    public MutableTreeNode getNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getFullName());
        for (Book book : this.books) {
            node.add(new DefaultMutableTreeNode(book.getFullName()));
        }
        return node;
    }
}
