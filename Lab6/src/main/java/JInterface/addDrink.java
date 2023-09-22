package JInterface;

import enums.DrinksEnums;
import models.Position;
import products.Drink;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddDrink extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox typeCombo;
    private JComboBox tasteCombo;
    private JComboBox volumeCombo;
    private JSpinner quantitySpinner;

    public AddDrink(NewOrder creationOrder) {

        pack();
        setSize(400, 200);
        setVisible(true);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        fillComboBoxes();
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 100, 1);
        quantitySpinner.setModel(spinnerNumberModel);

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

    private void onOK(NewOrder creationOrder) {
        Drink drink = new Drink();
        drink.setType(DrinksEnums.Type.valueOf((String) typeCombo.getSelectedItem()));
        drink.setTaste(DrinksEnums.Taste.valueOf((String) tasteCombo.getSelectedItem()));
        drink.setVolume(DrinksEnums.Volume.valueOf((String) volumeCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getDrinks().getOrDefault(drink, new Position(0, false)).getQuantity() != 0) {
            creationOrder.createdOrder.getDrinks().put(drink, new Position
                    ((int) quantitySpinner.getValue() + creationOrder.createdOrder.getDrinks().get(drink).getQuantity(), false));
        } else
            creationOrder.createdOrder.getDrinks().put(drink, new Position((int) quantitySpinner.getValue(), false));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void fillComboBoxes() {
        DefaultComboBoxModel<String> typeComboModel = new DefaultComboBoxModel<>();
        typeComboModel.addElement(String.valueOf(DrinksEnums.Type.LEMONADE));
        typeComboModel.addElement(String.valueOf(DrinksEnums.Type.KVASS));
        typeCombo.setModel(typeComboModel);
        DefaultComboBoxModel<String> tasteComboModel = new DefaultComboBoxModel<>();
        tasteComboModel.addElement(String.valueOf(DrinksEnums.Taste.LINGONBERRY));
        tasteComboModel.addElement(String.valueOf(DrinksEnums.Taste.TANGERINE));
        tasteComboModel.addElement(String.valueOf(DrinksEnums.Taste.AVOCADO));
        tasteCombo.setModel(tasteComboModel);
        DefaultComboBoxModel<String> volumeComboModel = new DefaultComboBoxModel<>();
        volumeComboModel.addElement(String.valueOf(DrinksEnums.Volume.SMALL));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.Volume.MEDIUM));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.Volume.LITER));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.Volume.ONEANDHALF));
        volumeComboModel.addElement(String.valueOf(DrinksEnums.Volume.TWOLITRES));
        volumeCombo.setModel(volumeComboModel);
    }
}
