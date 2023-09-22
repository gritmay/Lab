package products;

import enums.PotatoEnums;

import java.util.Objects;

public class Potato {

    private PotatoEnums.size size;
    private PotatoEnums.sauce sauce;

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

    public PotatoEnums.size getSize() {
        return size;
    }

    public void setSize(PotatoEnums.size size) {
        this.size = size;
    }

    public PotatoEnums.sauce getSauce() {
        return sauce;
    }

    public void setSauce(PotatoEnums.sauce sauce) {
        this.sauce = sauce;
    }
}
