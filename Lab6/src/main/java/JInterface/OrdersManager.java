package JInterface;

import models.Order;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.ArrayList;

public class OrdersManager extends JFrame {

    public ArrayList<Order> activeOrders = new ArrayList<>();
    public ArrayList<Order> ordersForDelivery = new ArrayList<>();
    public int orderId = 1;
    private JButton addOrderButton;
    private JTree tree1;
    private JPanel mainPanel;
    private JButton updateStatusButtonButton;
    private JButton toDeliveryButton;
    private JButton ordersToDeliveryButton;
    private JComboBox ordersCombo;

    public OrdersManager() throws HeadlessException {

        setContentPane(mainPanel);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Заказы");
        DefaultTreeModel model = new DefaultTreeModel(top);
        tree1.setModel(model);
        setTitle("Pizzeria Orders Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        addOrderButton.addActionListener(e -> new NewOrder(this));

        updateStatusButtonButton.addActionListener(e -> {
            for (Order order : activeOrders){
                order.getPizzas().forEach((pizza, position) -> {
                    if (Math.random()>0.7) position.setReady(true);
                });
                order.getDrinks().forEach((drink, position) -> {
                    if (Math.random()>0.4) position.setReady(true);
                });
                order.getBeers().forEach((beer, position) -> {
                    if (Math.random()>0.5) position.setReady(true);
                });
                order.getPotatoes().forEach((potato, position) -> {
                    if (Math.random()>0.6) position.setReady(true);
                });
                if (order.isReadyCheck()) order.setReady(true);
            }
            updateTree();
        });
        ordersToDeliveryButton.addActionListener(e -> {
            new OrdersForDelivery(ordersForDelivery);
        });
        toDeliveryButton.addActionListener(e -> {
            int orderForDeliveryId = (int) ordersCombo.getSelectedItem();
            ordersForDelivery.add(activeOrders.stream().filter(order -> order.getId()==orderForDeliveryId).findFirst().get());
            activeOrders.removeIf(order -> order.getId()==orderForDeliveryId);
            updateTree();
        });
    }

    public void updateTree() {
        DefaultMutableTreeNode ordersNode = new DefaultMutableTreeNode("Заказы");
        DefaultComboBoxModel ordersComboModel = new DefaultComboBoxModel<>();
        for (Order order : activeOrders) {
            ordersNode.add(order.orderNode());
            ordersComboModel.addElement(order.getId());
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(ordersNode);
        tree1.setModel(treeModel);
        ordersCombo.setModel(ordersComboModel);
    }
}
