package products;

import enums.PizzaEnums;

import java.util.Objects;

public class Pizza {

    private PizzaEnums.Sort sort;
    private PizzaEnums.Diameter diameter;
    private PizzaEnums.Dough dough;

    public Pizza() {
        this.sort = PizzaEnums.Sort.randomSort();
        this.diameter = PizzaEnums.Diameter.randomDiameter();
        this.dough = PizzaEnums.Dough.randomDough();
    }

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

    public PizzaEnums.Sort getSort() {
        return sort;
    }

    public void setSort(PizzaEnums.Sort sort) {
        this.sort = sort;
    }

    public PizzaEnums.Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(PizzaEnums.Diameter diameter) {
        this.diameter = diameter;
    }

    public PizzaEnums.Dough getDough() {
        return dough;
    }

    public void setDough(PizzaEnums.Dough dough) {
        this.dough = dough;
    }
}
