package enums;

public class PotatoEnums {

    public enum size{
        SMALL("Малый"),
        MEDIUM("Стандартный"),
        LARGE("Большой");

        size(String DESC) {
        }
    }

    public enum sauce{
        THOUSANDISLANDS("1000 островов"),
        MUSTARD("Горчичный"),
        BBQ("Барбекю"),
        SOURSPICY("Кисло-острый");

        sauce(String DESC) {
        }
    }
}
