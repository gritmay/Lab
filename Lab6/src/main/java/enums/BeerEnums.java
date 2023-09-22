package enums;

import java.util.Random;

public class BeerEnums {

    public static final Random random = new Random();

    public enum Brand {
        AFANASIY("Афанасий"),
        HEINEKEN("Хайникен"),
        VASILEOSTROVSKAYABREWERY("Василеостровская пивоварня"),
        SALDENS("Salden's");

        public final String value;

        Brand(String value) {
            this.value = value;
        }

        public static Brand randomBrand() {
            Brand[] brands = Brand.values();
            return brands[random.nextInt(brands.length)];
        }
    }

    public enum Container {
        GLASS("Стекло"),
        ALUMINUM("Алюминий");

        public final String value;

        Container(String value) {
            this.value = value;
        }

        public static Container randomContainer() {
            Container[] containers = Container.values();
            return containers[random.nextInt(containers.length)];
        }
    }

    public enum Sort {
        LAGER("Лагер"),
        PORTER("Портер"),
        STOUT("Стаут"),
        IPA("Ипа"),
        BARLEYWINE("Барлейвайн"),
        WEISSBIR("Вайсбир");

        public final String value;

        Sort(String value) {
            this.value = value;
        }

        public static Sort randomSort() {
            Sort[] sorts = Sort.values();
            return sorts[random.nextInt(sorts.length)];
        }
    }

    public enum Volume {
        SMALL(0.33f),
        MEDIUM(0.66f),
        LARGE(1.66f);

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
