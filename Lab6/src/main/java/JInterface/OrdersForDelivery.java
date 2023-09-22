package JInterface;

import models.Order;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;

public class OrdersForDelivery extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTree tree1;

    public OrdersForDelivery(ArrayList<Order> ordersForDelivery) {

        pack();
        setSize(550, 400);
        setVisible(true);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        DefaultMutableTreeNode ordersNode = new DefaultMutableTreeNode("Заказы");
        for (Order order : ordersForDelivery) {
            ordersNode.add(order.orderNode());
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(ordersNode);
        tree1.setModel(treeModel);

        buttonOK.addActionListener(e -> onOK());
    }


    private void onOK() {
        dispose();
    }
}
