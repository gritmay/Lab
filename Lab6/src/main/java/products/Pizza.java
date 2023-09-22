package products;

import enums.PizzaEnums;

import java.util.Objects;

public class Pizza {

    private PizzaEnums.sort sort;
    private PizzaEnums.diameter diameter;
    private PizzaEnums.dough dough;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return sort == pizza.sort && diameter == pizza.diameter && dough == pizza.dough;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sort, diameter, dough);
    }

    @Override
    public String toString() {
        return "Пицца " + sort.desc + ", " + diameter.value + " см, тесто: " + dough.type;
    }

    public PizzaEnums.sort getSort() {
        return sort;
    }

    public void setSort(PizzaEnums.sort sort) {
        this.sort = sort;
    }

    public PizzaEnums.diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(PizzaEnums.diameter diameter) {
        this.diameter = diameter;
    }

    public PizzaEnums.dough getDough() {
        return dough;
    }

    public void setDough(PizzaEnums.dough dough) {
        this.dough = dough;
    }
}
