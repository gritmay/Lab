package inform;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import products.Book;
import products.*;

public class Library {

    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Professor> professors = new ArrayList<>();

    public MutableTreeNode getSudentNodes() {
        DefaultMutableTreeNode studentnodes = new DefaultMutableTreeNode("Студенты");
        for (Student student : students) {
            studentnodes.add(student.getNode());
        }
        return studentnodes;
    }

    public MutableTreeNode getTeachersNodes() {
        DefaultMutableTreeNode professornodes = new DefaultMutableTreeNode("Преподаватели");
        for (Professor professor : professors) {
            professornodes.add(professor.getNode());
        }
        return professornodes;
    }
}
