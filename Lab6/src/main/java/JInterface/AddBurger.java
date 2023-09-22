package JInterface;

import enums.BurgerEnums;
import models.Position;
import products.Burger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddBurger extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox typeCombo;
    private JComboBox sizeCombo;
    private JComboBox extraSauceCombo;
    private JSpinner quantitySpinner;

    public AddBurger(NewOrder creationOrder) {

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
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(NewOrder creationOrder) {
        Burger burger = new Burger();
        burger.setType(BurgerEnums.Type.valueOf((String) typeCombo.getSelectedItem()));
        burger.setSize(BurgerEnums.Size.valueOf((String) sizeCombo.getSelectedItem()));
        burger.setSauce(BurgerEnums.ExtraSauce.valueOf((String) extraSauceCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getBurgers().getOrDefault(burger, new Position(0, false)).getQuantity() != 0) {
            creationOrder.createdOrder.getBurgers().put(burger, new Position
                    ((int) quantitySpinner.getValue() + creationOrder.createdOrder.getBurgers().get(burger).getQuantity(), false));
        } else
            creationOrder.createdOrder.getBurgers().put(burger, new Position((int) quantitySpinner.getValue(), false));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void fillComboBoxes() {
        DefaultComboBoxModel<String> typeComboModel = new DefaultComboBoxModel<>();
        typeComboModel.addElement(String.valueOf(BurgerEnums.Type.HAMBURGER));
        typeComboModel.addElement(String.valueOf(BurgerEnums.Type.CHEESEBURGER));
        typeComboModel.addElement(String.valueOf(BurgerEnums.Type.CHICKENBURGER));
        typeCombo.setModel(typeComboModel);
        DefaultComboBoxModel<String> sizeComboModel = new DefaultComboBoxModel<>();
        sizeComboModel.addElement(String.valueOf(BurgerEnums.Size.STANDARD));
        sizeComboModel.addElement(String.valueOf(BurgerEnums.Size.BIG));
        sizeCombo.setModel(sizeComboModel);
        DefaultComboBoxModel<String> extraSauceComboModel = new DefaultComboBoxModel<>();
        extraSauceComboModel.addElement(String.valueOf(BurgerEnums.ExtraSauce.NONE));
        extraSauceComboModel.addElement(String.valueOf(BurgerEnums.ExtraSauce.BBQ));
        extraSauceComboModel.addElement(String.valueOf(BurgerEnums.ExtraSauce.KETCHUP));
        extraSauceComboModel.addElement(String.valueOf(BurgerEnums.ExtraSauce.CHEESY));
        extraSauceCombo.setModel(extraSauceComboModel);
    }
}
