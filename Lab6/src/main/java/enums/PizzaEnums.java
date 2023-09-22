package enums;

public class PizzaEnums {

    public enum sort{
        PEPERONI("Пеперони"),
        MARGARITA("Маргарита"),
        HAWAIIAN("Гавайская"),
        THREECHEESES("Три сыра");

        public final String desc;

        sort(String desc) {
            this.desc = desc;
        }
    }

    public enum diameter{
        SMALL(20),
        MEDIUM(26),
        LARGE(30);

        public final int value;

        diameter(int value) {
            this.value = value;
        }
    }

    public enum dough{
        THIN("Тонкое"),
        CLASSIC("Классическое");

        public final String type;

        dough(String type) {
            this.type = type;
        }
    }
}
