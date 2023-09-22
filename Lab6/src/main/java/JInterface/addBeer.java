package JInterface;

import enums.BeerEnum;
import enums.DrinksEnums;
import products.Beer;
import products.Drink;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addBeer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox brandCombo;
    private JComboBox sortCombo;
    private JComboBox volumeCombo;
    private JTextField quantityTextField;
    private JComboBox containerCombo;

    public addBeer(newOrder creationOrder) {

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
        Beer beer = new Beer();
        beer.setBrand(BeerEnum.brand.valueOf((String) brandCombo.getSelectedItem()));
        beer.setContainer(BeerEnum.container.valueOf((String) containerCombo.getSelectedItem()));
        beer.setSort(BeerEnum.sort.valueOf((String) sortCombo.getSelectedItem()));
        beer.setVolume(BeerEnum.volume.valueOf((String) volumeCombo.getSelectedItem()));
        if (creationOrder.createdOrder.getBeers().getOrDefault(beer, 0)!=0){
            creationOrder.createdOrder.getBeers().put(beer, Integer.parseInt(quantityTextField.getText()) + creationOrder.createdOrder.getBeers().get(beer));
        } else creationOrder.createdOrder.getBeers().put(beer, Integer.valueOf(quantityTextField.getText()));
        creationOrder.updateTree();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void fillComboBoxes(){
        DefaultComboBoxModel<String> brandComboModel = new DefaultComboBoxModel<>();
        brandComboModel.addElement(String.valueOf(BeerEnum.brand.AFANASIY));
        brandComboModel.addElement(String.valueOf(BeerEnum.brand.HEINEKEN));
        brandComboModel.addElement(String.valueOf(BeerEnum.brand.VASILEOSTROVSKAYABREWERY));
        brandComboModel.addElement(String.valueOf(BeerEnum.brand.SALDENS));
        brandCombo.setModel(brandComboModel);

        DefaultComboBoxModel<String> containerComboModel = new DefaultComboBoxModel<>();
        containerComboModel.addElement(String.valueOf(BeerEnum.container.GLASS));
        containerComboModel.addElement(String.valueOf(BeerEnum.container.ALUMINUM));
        containerCombo.setModel(containerComboModel);

        DefaultComboBoxModel<String> sortComboModel = new DefaultComboBoxModel<>();
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.LAGER));
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.PORTER));
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.STOUT));
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.IPA));
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.BARLEYWINE));
        sortComboModel.addElement(String.valueOf(BeerEnum.sort.WEISSBIR));
        sortCombo.setModel(sortComboModel);

        DefaultComboBoxModel<String> volumeComboModel = new DefaultComboBoxModel<>();
        volumeComboModel.addElement(String.valueOf(BeerEnum.volume.SMALL));
        volumeComboModel.addElement(String.valueOf(BeerEnum.volume.MEDIUM));
        volumeComboModel.addElement(String.valueOf(BeerEnum.volume.LARGE));
        volumeCombo.setModel(volumeComboModel);
    }
}
