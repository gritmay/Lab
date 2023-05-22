package factories;

import inform.ExcelProvider;
import products.User;

public interface UserFactory {

    ExcelProvider provider = new ExcelProvider("src\\main\\java\\inform\\ФИО.xlsx");

    User createUser();
}
