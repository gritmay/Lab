package JInterface;

import enums.BeerEnums;
import models.Position;
import products.Beer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddBeer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox brandCombo;
    private JComboBox sortCombo;
    private JComboBox volumeCombo;
    private JComboBox containerCombo;
    private JSpinner quantitySpinner;

    public AddBeer(NewOrder creationOrder) {

        //pack();
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
        Beer beer = new Beer();
        beer.setBrand(BeerEnums.Brand.valueOf((String) brandCombo.getSelectedItem()));
        beer.setContainer(BeerEnums.Container.valueOf((String) containerCombo.getSelectedItem()));
        beer.setSort(BeerEnums.Sort.valueOf((String) sortCombo.getSelectedItem()));
        beer.setVolume(BeerEnums.Volume.valueOf((String) volumeCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getBeers().getOrDefault(beer, new Position(0, false)).getQuantity() != 0) {
            creationOrder.createdOrder.getBeers().put(beer, new Position
                    ((int) quantitySpinner.getValue() + creationOrder.createdOrder.getBeers().get(beer).getQuantity(), false));
        } else creationOrder.createdOrder.getBeers().put(beer, new Position((int) quantitySpinner.getValue(), false));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void fillComboBoxes() {
        DefaultComboBoxModel<String> brandComboModel = new DefaultComboBoxModel<>();
        brandComboModel.addElement(String.valueOf(BeerEnums.Brand.AFANASIY));
        brandComboModel.addElement(String.valueOf(BeerEnums.Brand.HEINEKEN));
        brandComboModel.addElement(String.valueOf(BeerEnums.Brand.VASILEOSTROVSKAYABREWERY));
        brandComboModel.addElement(String.valueOf(BeerEnums.Brand.SALDENS));
        brandCombo.setModel(brandComboModel);

        DefaultComboBoxModel<String> containerComboModel = new DefaultComboBoxModel<>();
        containerComboModel.addElement(String.valueOf(BeerEnums.Container.GLASS));
        containerComboModel.addElement(String.valueOf(BeerEnums.Container.ALUMINUM));
        containerCombo.setModel(containerComboModel);

        DefaultComboBoxModel<String> sortComboModel = new DefaultComboBoxModel<>();
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.LAGER));
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.PORTER));
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.STOUT));
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.IPA));
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.BARLEYWINE));
        sortComboModel.addElement(String.valueOf(BeerEnums.Sort.WEISSBIR));
        sortCombo.setModel(sortComboModel);

        DefaultComboBoxModel<String> volumeComboModel = new DefaultComboBoxModel<>();
        volumeComboModel.addElement(String.valueOf(BeerEnums.Volume.SMALL));
        volumeComboModel.addElement(String.valueOf(BeerEnums.Volume.MEDIUM));
        volumeComboModel.addElement(String.valueOf(BeerEnums.Volume.LARGE));
        volumeCombo.setModel(volumeComboModel);
    }
}
