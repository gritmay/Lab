package products;

import enums.BeerEnum;

public class Beer {

    private BeerEnum.brand brand;
    private BeerEnum.sort sort;
    private BeerEnum.container container;
    private BeerEnum.volume volume;

    @Override
    public String toString() {
        return "Beer{" +
                "brand=" + brand +
                ", sort=" + sort +
                ", container=" + container +
                ", volume=" + volume +
                '}';
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
