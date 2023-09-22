package JInterface;

import models.Order;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.ArrayList;

public class OrdersManager extends JFrame{

    public ArrayList<Order> activeOrders = new ArrayList<>();
    private JButton addOrderButton;
    private JButton updateStatusButtonButton;
    private JTree tree1;
    private JButton toDeliveryButton;
    private JButton ordersToDeliveryButton;
    private JPanel mainPanel;

    public OrdersManager() throws HeadlessException {

        setContentPane(mainPanel);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Заказы");
        DefaultTreeModel model = new DefaultTreeModel(top);
        tree1.setModel(model);
        setTitle("Pizzeria Orders Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        addOrderButton.addActionListener(e -> {
            Order order = new Order();
            new newOrder(this);
        });
    }

    public void updateTree(){
        DefaultMutableTreeNode ordersNode = new DefaultMutableTreeNode("Заказы");
        for (Order order : activeOrders) {
            DefaultMutableTreeNode orderNode = new DefaultMutableTreeNode(order.toString());
            ordersNode.add(orderNode);
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(ordersNode);
        tree1.setModel(treeModel);
    }
}
