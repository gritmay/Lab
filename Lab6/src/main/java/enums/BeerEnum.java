package enums;

public class BeerEnum {

    public enum brand{
        AFANASIY("Афанасий"),
        HEINEKEN("Хайникен"),
        VASILEOSTROVSKAYABREWERY("Василеостровская пивоварня"),
        SALDENS("Salden's");

        brand(String DESC) {
        }
    }

    public enum container{
        GLASS("Стекло"),
        ALUMINUM("Алюминий");

        container(String DESC) {
        }
    }

    public enum sort{
        LAGER("Лагер"),
        PORTER("Портер"),
        STOUT("Стаут"),
        IPA("Ипа"),
        BARLEYWINE("Барлейвайн"),
        WEISSBIR("Вайсбир");

        sort(String DESC) {
        }
    }

    public enum volume{
        SMALL(0.33f),
        MEDIUM(0.66f),
        LARGE(1.66f);

        volume(float litres) {
        }
    }
}
