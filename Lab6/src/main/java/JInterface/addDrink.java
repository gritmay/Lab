package JInterface;

import enums.DrinksEnums;
import enums.PizzaEnums;
import products.Drink;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addDrink extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox typeCombo;
    private JComboBox tasteCombo;
    private JComboBox volumeCombo;
    private JTextField quantityTextField;

    public addDrink(newOrder creationOrder) {

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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(newOrder creationOrder) {
        Drink drink = new Drink();
        drink.setType(DrinksEnums.type.valueOf((String) typeCombo.getSelectedItem()));
        drink.setTaste(DrinksEnums.taste.valueOf((String) tasteCombo.getSelectedItem()));
        drink.setVolume(DrinksEnums.volume.valueOf((String) volumeCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getDrinks().getOrDefault(drink, 0)!=0){
            creationOrder.createdOrder.getDrinks().put(drink, Integer.parseInt(quantityTextField.getText()) + creationOrder.createdOrder.getDrinks().get(drink));
        } else creationOrder.createdOrder.getDrinks().put(drink, Integer.valueOf(quantityTextField.getText()));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void fillComboBoxes(){
        DefaultComboBoxModel<String> typeComboModel = new DefaultComboBoxModel<>();
        typeComboModel.addElement(String.valueOf(DrinksEnums.type.LEMONADE));
        typeComboModel.addElement(String.valueOf(DrinksEnums.type.KVASS));
        typeCombo.setModel(typeComboModel);
        DefaultComboBoxModel<String> tasteComboModel = new DefaultComboBoxModel<>();
        tasteComboModel.addElement(String.valueOf(DrinksEnums.taste.LINGONBERRY));
        tasteComboModel.addElement(String.valueOf(DrinksEnums.taste.TANGERINE));
        tasteComboModel.addElement(String.valueOf(DrinksEnums.taste.AVOCADO));
        tasteCombo.setModel(tasteComboModel);
        DefaultComboBoxModel<String> volumeComboModel = new DefaultComboBoxModel<>();
        volumeComboModel.addElement(String.valueOf(DrinksEnums.volume.SMALL));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.volume.MEDIUM));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.volume.LITER));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.volume.ONEANDHALF));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.volume.TWOLITRES));
        volumeCombo.setModel(volumeComboModel);
    }
}
