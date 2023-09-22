package JInterface;

import enums.DrinksEnums;
import enums.PotatoEnums;
import products.Potato;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addPotato extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox sizeCombo;
    private JComboBox sauceCombo;
    private JTextField quantityTextField;

    public addPotato(newOrder creationOrder) {

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
        Potato potato = new Potato();
        potato.setSize(PotatoEnums.size.valueOf((String) sizeCombo.getSelectedItem()));
        potato.setSauce(PotatoEnums.sauce.valueOf((String) sauceCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getPotatoes().getOrDefault(potato, 0)!=0){
            creationOrder.createdOrder.getPotatoes().put(potato, Integer.parseInt(quantityTextField.getText()) + creationOrder.createdOrder.getPotatoes().get(potato));
        } else creationOrder.createdOrder.getPotatoes().put(potato, Integer.valueOf(quantityTextField.getText()));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void fillComboBoxes(){
        DefaultComboBoxModel<String> sizeComboModel = new DefaultComboBoxModel<>();
        sizeComboModel.addElement(String.valueOf(PotatoEnums.size.SMALL));
        sizeComboModel.addElement(String.valueOf(PotatoEnums.size.MEDIUM));
        sizeComboModel.addElement(String.valueOf(PotatoEnums.size.LARGE));
        sizeCombo.setModel(sizeComboModel);
        DefaultComboBoxModel<String> sauceComboModel = new DefaultComboBoxModel<>();
        sauceComboModel.addElement(String.valueOf(PotatoEnums.sauce.THOUSANDISLANDS));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.sauce.MUSTARD));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.sauce.BBQ));
        sauceComboModel.addElement(String.valueOf(PotatoEnums.sauce.SOURSPICY));
        sauceCombo.setModel(sauceComboModel);
    }
}
