package enums;

import java.util.Random;

public class PizzaEnums {

    public static final Random random = new Random();

    public enum Sort {
        PEPERONI("Пеперони"),
        MARGARITA("Маргарита"),
        HAWAIIAN("Гавайская"),
        THREECHEESES("Три сыра");

        public final String desc;


        Sort(String desc) {
            this.desc = desc;
        }

        public static Sort randomSort() {
            Sort[] sorts = Sort.values();
            return sorts[random.nextInt(sorts.length)];
        }
    }

    public enum Diameter {
        SMALL(20),
        MEDIUM(26),
        LARGE(30);

        public final int value;

        Diameter(int value) {
            this.value = value;
        }

        public static Diameter randomDiameter() {
            Diameter[] diameters = Diameter.values();
            return diameters[random.nextInt(diameters.length)];
        }
    }

    public enum Dough {
        THIN("Тонкое"),
        CLASSIC("Классическое");

        public final String type;

        Dough(String type) {
            this.type = type;
        }

        public static Dough randomDough() {
            Dough[] doughs = Dough.values();
            return doughs[random.nextInt(doughs.length)];
        }
    }
}
