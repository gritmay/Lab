package products;

import enums.DrinksEnums;

import java.util.Objects;

public class Drink {

    private DrinksEnums.type type;
    private DrinksEnums.taste taste;
    private DrinksEnums.volume volume;

    @Override
    public String toString() {
        if (type == DrinksEnums.type.KVASS) {
            return type.value + ", " + volume.litres + " литра";
        } else return type.value + ", вкус " + taste.value + ", " + volume.litres + " литра";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return type == drink.type && taste == drink.taste && volume == drink.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, taste, volume);
    }

    public DrinksEnums.type getType() {
        return type;
    }

    public void setType(DrinksEnums.type type) {
        this.type = type;
    }

    public DrinksEnums.taste getTaste() {
        return taste;
    }

    public void setTaste(DrinksEnums.taste taste) {
        this.taste = taste;
    }

    public DrinksEnums.volume getVolume() {
        return volume;
    }

    public void setVolume(DrinksEnums.volume volume) {
        this.volume = volume;
    }
}
