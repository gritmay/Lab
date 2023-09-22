package products;

import enums.BeerEnums;

import java.util.Objects;

public class Beer {

    private BeerEnums.Brand brand;
    private BeerEnums.Sort sort;
    private BeerEnums.Container container;
    private BeerEnums.Volume volume;

    public Beer() {
        this.brand = BeerEnums.Brand.randomBrand();
        this.sort = BeerEnums.Sort.randomSort();
        this.container = BeerEnums.Container.randomContainer();
        this.volume = BeerEnums.Volume.randomVolume();
    }

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

    public BeerEnums.Brand getBrand() {
        return brand;
    }

    public void setBrand(BeerEnums.Brand brand) {
        this.brand = brand;
    }

    public BeerEnums.Sort getSort() {
        return sort;
    }

    public void setSort(BeerEnums.Sort sort) {
        this.sort = sort;
    }

    public BeerEnums.Container getContainer() {
        return container;
    }

    public void setContainer(BeerEnums.Container container) {
        this.container = container;
    }

    public BeerEnums.Volume getVolume() {
        return volume;
    }

    public void setVolume(BeerEnums.Volume volume) {
        this.volume = volume;
    }
}
