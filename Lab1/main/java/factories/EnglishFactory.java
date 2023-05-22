package factories;

import inform.ExcelProvider;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Book;
import products.EnglishFiction;
import products.EnglishTextBook;

public class EnglishFactory implements BookFactory {

    ExcelProvider provider = new ExcelProvider("src\\main\\java\\inform\\английские названия.xlsx");

    @Override
    public Book createFiction() {
        String fullName = null;
        try {
            this.provider.openFile();
            fullName = this.provider.getValue("fiction");
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(EnglishFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new EnglishFiction(fullName);
    }

    @Override
    public Book creatTextBook() {
        String subject = null;
        String university = null;
        String author = null;
        String level = null;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int randLevel = random.nextInt(2);
        if (randLevel == 0) {
            level = "undergraduate";
        } else {
            level = "magistracy";
        }

        String fullName = null;
        try {
            this.provider.openFile();
            subject = this.provider.getValue("subject");
            university = this.provider.getValue("university");
            author = this.provider.getValue("author");
            fullName = stringBuilder.append(subject)
                    .append(", author: ")
                    .append(author)
                    .append(", ")
                    .append(university)
                    .append(", level: ")
                    .append(level)
                    .toString();
            this.provider.close();
        } catch (IOException ex) {
            Logger.getLogger(EnglishFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new EnglishTextBook(fullName);
    }

}
