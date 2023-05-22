package factories;

import inform.ExcelProvider;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Book;
import products.RussianFiction;
import products.RussianTextBook;

public class RussianFactory implements BookFactory {

    ExcelProvider provider = new ExcelProvider("src\\main\\java\\inform\\Российские названия.xlsx");

    @Override
    public Book createFiction() {
        StringBuilder stringBuilder = new StringBuilder();
        String fullName = null;
        String type = null;
        String subject = null;
        try {
            this.provider.openFile();
            subject = provider.getValue("subject");
            type = provider.getValue("type");
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(EnglishFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        fullName = stringBuilder.append(type)
                .append(" по ")
                .append(subject)
                .toString();
        return new RussianFiction(fullName);
    }

    @Override
    public Book creatTextBook() {
        String fullName = null;
        Random random = new Random();
        String adjective = null;
        String noun = null;
        String hero = null;
        StringBuilder stringBuilder = new StringBuilder();
        int fromInfo = random.nextInt(2);
        try {
            this.provider.openFile();
            if (fromInfo == 0) {
                fullName = this.provider.getValue("completeNames");
            } else {
                adjective = this.provider.getValue("adjective");
                noun = this.provider.getValue("noun");
                hero = this.provider.getValue("hero");
                fullName = stringBuilder.append(adjective)
                        .append(" ")
                        .append(noun)
                        .append(" ")
                        .append(hero)
                        .toString();
            }
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(EnglishFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new RussianTextBook(fullName);
    }

}
