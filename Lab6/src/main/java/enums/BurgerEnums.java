package enums;

import java.util.Random;

public class BurgerEnums {

    public static final Random random = new Random();

    public enum Type {
        HAMBURGER("Гамбургер"),
        CHEESEBURGER("Чизбургер"),
        CHICKENBURGER("Чикенбургер");

        public final String value;

        Type(String value) {
            this.value = value;
        }

        public static Type randomType() {
            Type[] types = Type.values();
            return types[random.nextInt(types.length)];
        }
    }

    public enum Size {
        STANDARD(250),
        BIG(350);

        public final int gram;

        Size(int gram) {
            this.gram = gram;
        }

        public static Size randomSize() {
            Size[] sizes = Size.values();
            return sizes[random.nextInt(sizes.length)];
        }
    }

    public enum ExtraSauce {
        BBQ("Барбекю"),
        KETCHUP("Кетчуп"),
        CHEESY("Сырный"),
        NONE("Без доп соуса");

        public final String value;

        ExtraSauce(String value) {
            this.value = value;
        }

        public static ExtraSauce randomExtraSauce() {
            ExtraSauce[] extraSauces = ExtraSauce.values();
            return extraSauces[random.nextInt(extraSauces.length)];
        }
    }
}