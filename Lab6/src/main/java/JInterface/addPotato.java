package JInterface;

import enums.PotatoEnums;
import models.Position;
import products.Potato;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddPotato extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox sizeCombo;
    private JComboBox sauceCombo;
    private JSpinner quantitySpinner;

    public AddPotato(NewOrder creationOrder) {

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
        Potato potato = new Potato();
        potato.setSize(PotatoEnums.Size.valueOf((String) sizeCombo.getSelectedItem()));
        potato.setSauce(PotatoEnums.Sauce.valueOf((String) sauceCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getPotatoes().getOrDefault(potato, new Position(0, false)).getQuantity() != 0) {
            creationOrder.createdOrder.getPotatoes().put(potato, new Position
                    ((int) quantitySpinner.getValue() + creationOrder.createdOrder.getPotatoes().get(potato).getQuantity(), false));
        } else
            creationOrder.createdOrder.getPotatoes().put(potato, new Position((int) quantitySpinner.getValue(), false));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void fillComboBoxes() {
        DefaultComboBoxModel<String> sizeComboModel = new DefaultComboBoxModel<>();
        sizeComboModel.addElement(String.valueOf(PotatoEnums.Size.SMALL));
        sizeComboModel.addElement(String.valueOf(PotatoEnums.Size.MEDIUM));
        sizeComboModel.addElement(String.valueOf(PotatoEnums.Size.LARGE));
        sizeCombo.setModel(sizeComboModel);
        DefaultComboBoxModel<String> sauceComboModel = new DefaultComboBoxModel<>();
        sauceComboModel.addElement(String.valueOf(PotatoEnums.Sauce.THOUSANDISLANDS));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.Sauce.MUSTARD));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.Sauce.BBQ));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.Sauce.SOURSPICY));
        sauceCombo.setModel(sauceComboModel);
    }
}
