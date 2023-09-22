package enums;

public class PizzaEnums {

    public enum sort{
        PEPERONI("Пеперони"),
        MARGARITA("Маргарита"),
        HAWAIIAN("Гавайская"),
        THREECHEESES("Три сыра");

        sort(String DESC) {
        }
    }

    public enum diameter{
        SMALL(20),
        MEDIUM(20),
        LARGE(20);

        diameter(int value) {
        }
    }

    public enum dough{
        THIN("Тонкое"),
        CLASSIC("Классическое");

        dough(String type) {
        }
    }
}
