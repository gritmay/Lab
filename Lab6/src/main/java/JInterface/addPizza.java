package JInterface;

import enums.PizzaEnums;
import products.Pizza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addPizza extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox sortCombo;
    private JComboBox diameterCombo;
    private JComboBox doughCombo;
    private JTextField quantityTextField;

    public addPizza(newOrder creationOrder) {

        pack();
        setSize(400, 200);
        setVisible(true);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        fillComboBoxes();

        buttonOK.addActionListener(e -> onOK(creationOrder));

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
    }

    private void onOK(newOrder creationOrder) {
        Pizza pizza = new Pizza();
        pizza.setSort(PizzaEnums.sort.valueOf((String) sortCombo.getSelectedItem()));
        pizza.setDiameter(PizzaEnums.diameter.valueOf((String) diameterCombo.getSelectedItem()));
        pizza.setDough(PizzaEnums.dough.valueOf((String) doughCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getPizzas().getOrDefault(pizza, 0)!=0){
            creationOrder.createdOrder.getPizzas().put(pizza, Integer.parseInt(quantityTextField.getText()) + creationOrder.createdOrder.getPizzas().get(pizza));
        } else creationOrder.createdOrder.getPizzas().put(pizza, Integer.valueOf(quantityTextField.getText()));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void fillComboBoxes(){
        DefaultComboBoxModel<String> sortComboModel = new DefaultComboBoxModel<>();
        sortComboModel.addElement(String.valueOf(PizzaEnums.sort.PEPERONI));
        sortComboModel.addElement(String.valueOf(PizzaEnums.sort.HAWAIIAN));
        sortComboModel.addElement(String.valueOf(PizzaEnums.sort.MARGARITA));
        sortComboModel.addElement(String.valueOf(PizzaEnums.sort.THREECHEESES));
        sortCombo.setModel(sortComboModel);
        DefaultComboBoxModel<String> diameterComboModel = new DefaultComboBoxModel<>();
        diameterComboModel.addElement(String.valueOf(PizzaEnums.diameter.SMALL));
        diameterComboModel.addElement(String.valueOf(PizzaEnums.diameter.MEDIUM));
        diameterComboModel.addElement(String.valueOf(PizzaEnums.diameter.LARGE));
        diameterCombo.setModel(diameterComboModel);
        DefaultComboBoxModel<String> doughComboModel = new DefaultComboBoxModel<>();
        doughComboModel.addElement(String.valueOf(PizzaEnums.dough.CLASSIC));
        doughComboModel.addElement(String.valueOf(PizzaEnums.dough.THIN));
        doughCombo.setModel(doughComboModel);
    }
}
