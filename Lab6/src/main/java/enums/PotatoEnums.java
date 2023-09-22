package enums;

import java.util.Random;

public class PotatoEnums {

    public static final Random random = new Random();

    public enum Size {
        SMALL("Малый"),
        MEDIUM("Стандартный"),
        LARGE("Большой");

        public final String value;

        Size(String value) {
            this.value = value;
        }

        public static Size randomSize() {
            Size[] sizes = Size.values();
            return sizes[random.nextInt(sizes.length)];
        }
    }

    public enum Sauce {
        THOUSANDISLANDS("1000 островов"),
        MUSTARD("Горчичный"),
        BBQ("Барбекю"),
        SOURSPICY("Кисло-острый");

        public final String value;

        Sauce(String value) {
            this.value = value;
        }

        public static Sauce randomSauce() {
            Sauce[] sauces = Sauce.values();
            return sauces[random.nextInt(sauces.length)];
        }
    }
}
