package enums;

public class BeerEnum {

    public enum brand{
        AFANASIY("Афанасий"),
        HEINEKEN("Хайникен"),
        VASILEOSTROVSKAYABREWERY("Василеостровская пивоварня"),
        SALDENS("Salden's");

        public final String value;

        brand(String value) {
            this.value = value;
        }
    }

    public enum container{
        GLASS("Стекло"),
        ALUMINUM("Алюминий");

        public final String value;

        container(String value) {
            this.value = value;
        }
    }

    public enum sort{
        LAGER("Лагер"),
        PORTER("Портер"),
        STOUT("Стаут"),
        IPA("Ипа"),
        BARLEYWINE("Барлейвайн"),
        WEISSBIR("Вайсбир");

        public final String value;

        sort(String value) {
            this.value = value;
        }
    }

    public enum volume{
        SMALL(0.33f),
        MEDIUM(0.66f),
        LARGE(1.66f);

        public final float litres;

        volume(float litres) {
            this.litres = litres;
        }
    }
}
