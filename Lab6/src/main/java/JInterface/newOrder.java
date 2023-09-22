package JInterface;

import models.Order;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class NewOrder extends JDialog {

    public Order createdOrder = new Order();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addPizzaButton;
    private JButton addDrinkButtonButton;
    private JButton addBeerButton;
    private JButton addPotatoButton;
    private JTree tree1;
    private JTextField receiverTextField;
    private JTextField addressTextField;

    public NewOrder(OrdersManager ordersManager) {

        pack();
        setSize(500, 400);
        setVisible(true);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Заказ");
        DefaultTreeModel model = new DefaultTreeModel(top);
        tree1.setModel(model);

        createdOrder.setPizzas(new HashMap<>());
        createdOrder.setDrinks(new HashMap<>());
        createdOrder.setBeers(new HashMap<>());
        createdOrder.setPotatoes(new HashMap<>());

        buttonOK.addActionListener(e -> onOK(ordersManager));

        buttonCancel.addActionListener(e -> onCancel(ordersManager));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel(ordersManager);
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(ordersManager), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addPizzaButton.addActionListener(e -> new AddPizza(this));

        addDrinkButtonButton.addActionListener(e -> new AddDrink(this));

        addBeerButton.addActionListener(e -> new AddBeer(this));

        addPotatoButton.addActionListener(e -> new AddPotato(this));
    }

    private void onOK(OrdersManager ordersManager) {
        if (!receiverTextField.getText().equals("") && !addressTextField.getText().equals("")) {
            createdOrder.setId(ordersManager.orderId++);
            createdOrder.setClient(receiverTextField.getText());
            createdOrder.setAddress(addressTextField.getText());
            ordersManager.activeOrders.add(createdOrder);
            ordersManager.updateTree();
            ordersManager.setEnabled(true);
            dispose();
        } else JOptionPane.showMessageDialog(this, "Необходимо заполнить адрес и имя заказчика");
    }

    private void onCancel(OrdersManager ordersManager) {
        ordersManager.setEnabled(true);
        dispose();
    }

    public void updateTree() {
        DefaultTreeModel treeModel = new DefaultTreeModel(createdOrder.orderNode());
        tree1.setModel(treeModel);
    }
}
