package models;

import products.Beer;
import products.Burger;
import products.Drink;
import products.Pizza;
import products.Potato;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Order {

    private int id;
    private String client;
    private String address;
    private boolean isReady;
    private HashMap<Pizza, Position> pizzas = new HashMap<>();
    private HashMap<Drink, Position> drinks = new HashMap<>();
    private HashMap<Beer, Position> beers = new HashMap<>();
    private HashMap<Potato, Position> potatoes = new HashMap<>();
    private HashMap<Burger, Position> burgers = new HashMap<>();

    public boolean isReadyCheck() {
        AtomicBoolean result = new AtomicBoolean(true);
        pizzas.forEach((pizza, position) -> {
            if (!position.isReady()) result.set(false);
        });
        drinks.forEach((drink, position) -> {
            if (!position.isReady()) result.set(false);
        });
        beers.forEach((beers, position) -> {
            if (!position.isReady()) result.set(false);
        });
        potatoes.forEach((potatoes, position) -> {
            if (!position.isReady()) result.set(false);
        });
        burgers.forEach((burgers, position) -> {
            if (!position.isReady()) result.set(false);
        });
        return result.get();
    }

    public DefaultMutableTreeNode orderNode() {
        DefaultMutableTreeNode orderNode = new DefaultMutableTreeNode(toString());
        if (!this.getPizzas().isEmpty()) {
            DefaultMutableTreeNode pizzasNode = new DefaultMutableTreeNode("Пиццы:");
            this.getPizzas().forEach(((pizza, position) -> {
                DefaultMutableTreeNode pizzaNode = new DefaultMutableTreeNode(pizza.toString() + ", кол-во: " + position.getQuantity() + ", " + position.isReadyString());
                pizzasNode.add(pizzaNode);
            }));
            orderNode.add(pizzasNode);
        }
        if (!this.getDrinks().isEmpty()) {
            DefaultMutableTreeNode drinksNode = new DefaultMutableTreeNode("Напитки:");
            this.getDrinks().forEach(((drink, position) -> {
                DefaultMutableTreeNode drinkNode = new DefaultMutableTreeNode(drink.toString() + ", кол-во: " + position.getQuantity() + ", " + position.isReadyString());
                drinksNode.add(drinkNode);
            }));
            orderNode.add(drinksNode);
        }
        if (!this.getBeers().isEmpty()) {
            DefaultMutableTreeNode beersNode = new DefaultMutableTreeNode("Пиво:");
            this.getBeers().forEach(((beer, position) -> {
                DefaultMutableTreeNode beerNode = new DefaultMutableTreeNode(beer.toString() + ", кол-во: " + position.getQuantity() + ", " + position.isReadyString());
                beersNode.add(beerNode);
            }));
            orderNode.add(beersNode);
        }
        if (!this.getPotatoes().isEmpty()) {
            DefaultMutableTreeNode potatoesNode = new DefaultMutableTreeNode("Картошка:");
            this.getPotatoes().forEach(((potato, position) -> {
                DefaultMutableTreeNode potatoNode = new DefaultMutableTreeNode(potato.toString() + ", кол-во: " + position.getQuantity() + ", " + position.isReadyString());
                potatoesNode.add(potatoNode);
            }));
            orderNode.add(potatoesNode);
        }
        if (!this.getBurgers().isEmpty()) {
            DefaultMutableTreeNode burgersNode = new DefaultMutableTreeNode("Бургеры:");
            this.getBurgers().forEach(((burger, position) -> {
                DefaultMutableTreeNode burgerNode = new DefaultMutableTreeNode(burger.toString() + ", кол-во: " + position.getQuantity() + ", " + position.isReadyString());
                burgersNode.add(burgerNode);
            }));
            orderNode.add(burgersNode);
        }
        return orderNode;
    }

    @Override
    public String toString() {
        return "Заказ № " + id +
                ", получатель: " + client +
                ", адрес: " + address +
                ", заказ " + isReady();
    }

    public HashMap<Burger, Position> getBurgers() {
        return burgers;
    }

    public void setBurgers(HashMap<Burger, Position> burgers) {
        this.burgers = burgers;
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

    public String isReady() {
        if (isReady) {
            return "готов";
        } else return "не готов";
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void setPizzas(HashMap<Pizza, Position> pizzas) {
        this.pizzas = pizzas;
    }

    public void setDrinks(HashMap<Drink, Position> drinks) {
        this.drinks = drinks;
    }

    public void setBeers(HashMap<Beer, Position> beers) {
        this.beers = beers;
    }

    public void setPotatoes(HashMap<Potato, Position> potatoes) {
        this.potatoes = potatoes;
    }

    public HashMap<Pizza, Position> getPizzas() {
        return pizzas;
    }

    public HashMap<Drink, Position> getDrinks() {
        return drinks;
    }

    public HashMap<Beer, Position> getBeers() {
        return beers;
    }

    public HashMap<Potato, Position> getPotatoes() {
        return potatoes;
    }
}
