package products;

import enums.DrinksEnums;

public class Drink {

    private DrinksEnums.type type;
    private DrinksEnums.taste taste;
    private DrinksEnums.volume volume;

    @Override
    public String toString() {
        return "Drink{" +
                "type=" + type +
                ", taste=" + taste +
                ", volume=" + volume +
                '}';
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
