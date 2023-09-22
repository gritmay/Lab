package enums;

public class PotatoEnums {

    public enum size{
        SMALL("Малый"),
        MEDIUM("Стандартный"),
        LARGE("Большой");

        public final String value;

        size(String value) {
            this.value = value;
        }
    }

    public enum sauce{
        THOUSANDISLANDS("1000 островов"),
        MUSTARD("Горчичный"),
        BBQ("Барбекю"),
        SOURSPICY("Кисло-острый");

        public final String value;

        sauce(String value) {
            this.value = value;
        }
    }
}
