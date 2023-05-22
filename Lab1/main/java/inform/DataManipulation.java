package inform;

import factories.EnglishFactory;
import factories.ProfessorFactory;
import factories.RussianFactory;
import factories.StudentFactory;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import products.Professor;
import products.Student;
import products.Book;

public class DataManipulation {
    Library lib; 

    public void createData(int quantityOfStudents, int quantityOfProfessors) {
        lib = new Library();
        EnglishFactory ef = new EnglishFactory();
        RussianFactory rf = new RussianFactory();
        for (int i = 0; i < 25; i++) {
            lib.books.add(ef.creatTextBook());
            lib.books.add(ef.createFiction());
            lib.books.add(rf.creatTextBook());
            lib.books.add(rf.createFiction());
        }
        StudentFactory sf = new StudentFactory();
        ProfessorFactory pf = new ProfessorFactory();
        for (int i = 0; i < quantityOfStudents; i++) {
            Student student = sf.createUser();
            student.takeBook(lib.books);
            lib.students.add(student);
        }
        for (int i = 0; i < quantityOfProfessors; i++) {
            Professor professor = pf.createUser();
            professor.takeBook(lib.books);
            lib.professors.add(professor);
//            professor.getBooks().forEach(book -> System.out.println(book.getFullName()));
        }

    }

    public TreeNode addInfotoGUI() {
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Пользователи");
        main.add(lib.getSudentNodes());
        main.add(lib.getTeachersNodes());
        return main;
    }
}
