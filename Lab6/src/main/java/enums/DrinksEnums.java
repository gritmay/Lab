package enums;

import java.util.Random;

public class DrinksEnums {

    public static final Random random = new Random();

    public enum Type {
        LEMONADE("Лимонад"),
        KVASS("Квас");

        public final String value;

        Type(String value) {
            this.value = value;
        }

        public static Type randomType() {
            Type[] types = Type.values();
            return types[random.nextInt(types.length)];
        }
    }

    public enum Taste {
        LINGONBERRY("Брусника"),
        TANGERINE("Мандарин"),
        AVOCADO("Авокадо");

        public final String value;

        Taste(String value) {
            this.value = value;
        }

        public static Taste randomTaste() {
            Taste[] tastes = Taste.values();
            return tastes[random.nextInt(tastes.length)];
        }
    }

    public enum Volume {
        SMALL(0.3f),
        MEDIUM(0.5f),
        LITER(1),
        ONEANDHALF(1.5f),
        TWOLITRES(2);

        public final float litres;

        Volume(float litres) {
            this.litres = litres;
        }

        public static Volume randomVolume() {
            Volume[] volumes = Volume.values();
            return volumes[random.nextInt(volumes.length)];
        }
    }
}
