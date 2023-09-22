package products;

import enums.BeerEnum;

import java.util.Objects;

public class Beer {

    private BeerEnum.brand brand;
    private BeerEnum.sort sort;
    private BeerEnum.container container;
    private BeerEnum.volume volume;

    @Override
    public String toString() {
        return sort.value + " \"" + brand.value + "\", тара: " + container.value + ", " + volume.litres + " литра";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return brand == beer.brand && sort == beer.sort && container == beer.container && volume == beer.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, sort, container, volume);
    }

    public BeerEnum.brand getBrand() {
        return brand;
    }

    public void setBrand(BeerEnum.brand brand) {
        this.brand = brand;
    }

    public BeerEnum.sort getSort() {
        return sort;
    }

    public void setSort(BeerEnum.sort sort) {
        this.sort = sort;
    }

    public BeerEnum.container getContainer() {
        return container;
    }

    public void setContainer(BeerEnum.container container) {
        this.container = container;
    }

    public BeerEnum.volume getVolume() {
        return volume;
    }

    public void setVolume(BeerEnum.volume volume) {
        this.volume = volume;
    }
}
