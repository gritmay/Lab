package products;

import enums.BurgerEnums;

import java.util.Objects;

public class Burger {

    private BurgerEnums.Type type;
    private BurgerEnums.Size size;
    private BurgerEnums.ExtraSauce sauce;

    public Burger() {
        this.type = BurgerEnums.Type.randomType();
        this.size = BurgerEnums.Size.randomSize();
        this.sauce = BurgerEnums.ExtraSauce.randomExtraSauce();
    }

    @Override
    public String toString() {
        return type.value + ", вес: " + size.gram + ", доп соус: " + sauce.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burger burger = (Burger) o;
        return type == burger.type && size == burger.size && sauce == burger.sauce;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, sauce);
    }

    public BurgerEnums.Type getType() {
        return type;
    }

    public void setType(BurgerEnums.Type type) {
        this.type = type;
    }

    public BurgerEnums.Size getSize() {
        return size;
    }

    public void setSize(BurgerEnums.Size size) {
        this.size = size;
    }

    public BurgerEnums.ExtraSauce getSauce() {
        return sauce;
    }

    public void setSauce(BurgerEnums.ExtraSauce sauce) {
        this.sauce = sauce;
    }
}
