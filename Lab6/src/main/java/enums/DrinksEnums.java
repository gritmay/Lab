package enums;

public class DrinksEnums {

    public enum type{
        LEMONADE("Лимонад"),
        KVASS("Квас");

        public final String value;

        type(String value) {
            this.value = value;
        }
    }

    public enum taste{
        LINGONBERRY("Брусника"),
        TANGERINE("Мандарин"),
        AVOCADO("Авокадо");

        public final String value;
        taste(String value) {
            this.value = value;
        }
    }

    public enum volume{
        SMALL(0.3f),
        MEDIUM(0.5f),
        LITER(1),
        ONEANDHALF(1.5f),
        TWOLITRES(2);

        public final float litres;

        volume(float litres) {
            this.litres = litres;
        }
    }
}
