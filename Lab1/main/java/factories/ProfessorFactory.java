package factories;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Professor;
import products.User;

public class ProfessorFactory implements UserFactory {

    @Override
    public Professor createUser() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String name = null;
        String surname = null;
        String secondName = null;
        String fullName = null;
        String end = null;
        try {
            this.provider.openFile();
            secondName = this.provider.getValue("secondNames");

            int sex = random.nextInt(1);
            if (sex == 0) {
                end = "ич";
                name = this.provider.getValue("maleNames");
                surname = this.provider.getValue("maleTSurnames");

            } else {
                end = "на";
                name = this.provider.getValue("femaleNames");
                surname = this.provider.getValue("femaleTSurnames");
            }
            fullName = stringBuilder.append(surname)
                    .append(" ")
                    .append(name)
                    .append(" ")
                    .append(secondName)
                    .append(end)
                    .toString();
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(ProfessorFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Professor(fullName);
    }

}
