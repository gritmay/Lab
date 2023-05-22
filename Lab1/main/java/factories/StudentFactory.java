package factories;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Student;
import products.User;

public class StudentFactory implements UserFactory {

    @Override
    public Student createUser() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String name = null;
        String surname = null;
        String fullName = null;
        try {
            this.provider.openFile();
            int sex = random.nextInt(2);
            if (sex == 0) {
                name = this.provider.getValue("maleNames");
                surname = this.provider.getValue("maleSurnames");
            } else {
                name = this.provider.getValue("femaleNames");
                surname = this.provider.getValue("femaleSurnames");
            }
            fullName = stringBuilder.append(surname)
                    .append(" ")
                    .append(name)
                    .toString();
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Student(fullName);
    }

}
