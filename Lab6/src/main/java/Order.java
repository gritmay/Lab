import products.Beer;
import products.Drink;
import products.Pizza;
import products.Potato;

import java.util.ArrayList;

public class Order {

    private int id;
    private String client;
    private String address;
    private String status;
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;
    private ArrayList<Beer> beers;
    private ArrayList<Potato> potatoes;
}
