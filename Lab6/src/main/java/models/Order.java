package models;

import products.Beer;
import products.Drink;
import products.Pizza;
import products.Potato;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private int id;
    private String client;
    private String address;
    private boolean isReady;
    private HashMap<Pizza, Integer> pizzas;
    private HashMap<Drink, Integer> drinks;
    private HashMap<Beer, Integer> beers;
    private HashMap<Potato, Integer> potatoes;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", address='" + address + '\'' +
                ", isReady=" + isReady +
                ", pizzas=" + pizzas +
                ", drinks=" + drinks +
                ", beers=" + beers +
                ", potatoes=" + potatoes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void setPizzas(HashMap<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public void setDrinks(HashMap<Drink, Integer> drinks) {
        this.drinks = drinks;
    }

    public void setBeers(HashMap<Beer, Integer> beers) {
        this.beers = beers;
    }

    public void setPotatoes(HashMap<Potato, Integer> potatoes) {
        this.potatoes = potatoes;
    }

    public HashMap<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public HashMap<Drink, Integer> getDrinks() {
        return drinks;
    }

    public HashMap<Beer, Integer> getBeers() {
        return beers;
    }

    public HashMap<Potato, Integer> getPotatoes() {
        return potatoes;
    }
}
