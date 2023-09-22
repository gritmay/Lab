package products;

import enums.PotatoEnums;

import java.util.Objects;

public class Potato {

    private PotatoEnums.Size size;
    private PotatoEnums.Sauce sauce;

    public Potato() {
        this.size = PotatoEnums.Size.randomSize();
        this.sauce = PotatoEnums.Sauce.randomSauce();
    }

    @Override
    public String toString() {
        return size.value + " картофель с соусом " + sauce.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potato potato = (Potato) o;
        return size == potato.size && sauce == potato.sauce;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, sauce);
    }

    public PotatoEnums.Size getSize() {
        return size;
    }

    public void setSize(PotatoEnums.Size size) {
        this.size = size;
    }

    public PotatoEnums.Sauce getSauce() {
        return sauce;
    }

    public void setSauce(PotatoEnums.Sauce sauce) {
        this.sauce = sauce;
    }
}
