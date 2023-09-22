package JInterface;

import models.Order;
import products.Pizza;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class newOrder extends JDialog {
    public Order createdOrder = new Order();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addPizzaButton;
    private JButton addDrinkButtonButton;
    private JButton addBeerButton;
    private JButton addPotatoButton;
    private JTree tree1;
    private JTextField textField1;
    private JTextField textField2;

    public newOrder(OrdersManager ordersManager) {

        pack();
        setSize(500, 400);
        setVisible(true);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        createdOrder.setPizzas(new HashMap<>());
        createdOrder.setDrinks(new HashMap<>());
        createdOrder.setBeers(new HashMap<>());
        createdOrder.setPotatoes(new HashMap<>());

        buttonOK.addActionListener(e -> onOK(ordersManager));

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addPizzaButton.addActionListener(e -> {
            addPizza addPizza = new addPizza(this);
        });


        addDrinkButtonButton.addActionListener(e -> {
            addDrink addDrink = new addDrink(this);
        });

        addBeerButton.addActionListener(e -> {
            addBeer addBeer = new addBeer(this);
        });

        addPotatoButton.addActionListener(e -> {
            addPotato addPotato = new addPotato(this);
        });
    }

    private void onOK(OrdersManager ordersManager) {
        ordersManager.activeOrders.add(createdOrder);
        ordersManager.updateTree();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void updateTree(){
        DefaultMutableTreeNode orderNode = new DefaultMutableTreeNode("Заказ");
        DefaultMutableTreeNode pizzazNode = new DefaultMutableTreeNode("Пиццы:");
        DefaultMutableTreeNode drinksNode = new DefaultMutableTreeNode("Напитки:");
        DefaultMutableTreeNode beersNode = new DefaultMutableTreeNode("Пиво:");
        DefaultMutableTreeNode potatoesNode = new DefaultMutableTreeNode("Картошка:");
        createdOrder.getPizzas().forEach(((pizza, integer) -> {
            DefaultMutableTreeNode pizzaNode = new DefaultMutableTreeNode(pizza.toString() + ", кол-во: " +integer);
            pizzazNode.add(pizzaNode);
        }));
        createdOrder.getDrinks().forEach(((drink, integer) -> {
            DefaultMutableTreeNode drinkNode = new DefaultMutableTreeNode(drink.toString() + ", кол-во: " +integer);
            drinksNode.add(drinkNode);
        }));
        createdOrder.getBeers().forEach(((beer, integer) -> {
            DefaultMutableTreeNode beerNode = new DefaultMutableTreeNode(beer.toString() + ", кол-во: " +integer);
            beersNode.add(beerNode);
        }));
        createdOrder.getPotatoes().forEach(((potato, integer) -> {
            DefaultMutableTreeNode potatoNode = new DefaultMutableTreeNode(potato.toString() + ", кол-во: " +integer);
            potatoesNode.add(potatoNode);
        }));
        orderNode.add(pizzazNode);
        orderNode.add(drinksNode);
        orderNode.add(beersNode);
        orderNode.add(potatoesNode);
        DefaultTreeModel treeModel = new DefaultTreeModel(orderNode);
        tree1.setModel(treeModel);
    }
}
