package factories;

import products.Book;

public interface BookFactory {

    Book createFiction();

    Book creatTextBook();
}
