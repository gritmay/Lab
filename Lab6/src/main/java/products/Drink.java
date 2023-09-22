package products;

import enums.DrinksEnums;

import java.util.Objects;

public class Drink {

    private DrinksEnums.Type type;
    private DrinksEnums.Taste taste;
    private DrinksEnums.Volume volume;

    public Drink() {
        this.type = DrinksEnums.Type.randomType();
        this.taste = DrinksEnums.Taste.randomTaste();
        this.volume = DrinksEnums.Volume.randomVolume();
    }

    @Override
    public String toString() {
        if (type == DrinksEnums.Type.KVASS) {
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

    public DrinksEnums.Type getType() {
        return type;
    }

    public void setType(DrinksEnums.Type type) {
        this.type = type;
    }

    public DrinksEnums.Taste getTaste() {
        return taste;
    }

    public void setTaste(DrinksEnums.Taste taste) {
        this.taste = taste;
    }

    public DrinksEnums.Volume getVolume() {
        return volume;
    }

    public void setVolume(DrinksEnums.Volume volume) {
        this.volume = volume;
    }
}
