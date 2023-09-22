package enums;

public class DrinksEnums {

    public enum type{
        LEMONADE("Лимонад"),
        KVASS("Квас");

        type(String DESC) {
        }
    }

    public enum taste{
        LINGONBERRY("Брусника"),
        TANGERINE("Мандарин"),
        AVOCADO("Авокадо");

        taste(String DESC) {
        }
    }

    public enum volume{
        SMALL(0.3f),
        MEDIUM(0.5f),
        LITER(1),
        ONEANDHALF(1.5f),
        TWOLITRES(2);

        volume(float litres) {
        }
    }
}
