
package com.mycompany.mavenproject_xml.main;

import com.mycompany.mavenproject_xml.Excel.CreatorSQL;
import com.mycompany.mavenproject_xml.Excel.Data2DB;
import com.mycompany.mavenproject_xml.Excel.DisplayerDB;
import com.mycompany.mavenproject_xml.Reactor;
import com.mycompany.mavenproject_xml.Reader;
import com.mycompany.mavenproject_xml.readerManipulation;
import java.io.File;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 79509
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
     DisplayerDB displayer;
     Data2DB Mother = new Data2DB("auto");
    public NewJFrame() throws SQLException {
        initComponents();
        // jFileChooser1.setCurrentDirectory(new File("‪C:\\Users\\79509\\Documents\\GitHub\\TestSmirnovRepo\\AllLabs\\Lab_2"));
       
      this.jTable1.setVisible(false);
      
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("Select files");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTable1);

        jButton3.setText("create tables");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("drop tables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("aggregation countries");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("aggregation companies");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("aggregation regions");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("calculate");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(684, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addGap(0, 230, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    String selectedFile = "";
    String path = "";
    Reader RealReader;
    List<Reactor> reactors;
    Integer q;
    
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try{
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("C:\\Users\\79509\\Documents\\GitHub\\TestSmirnovRepo\\AllLabs\\Lab_2"));
            int res = fc.showOpenDialog(this);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("POM","json", "xml", "Yaml file","yaml", "xlsx");
            fc.setFileFilter(filter);
            System.out.println("res = " + res);
             
             
            String selectedFile = fc.getSelectedFile().toString();
            this.path = selectedFile;
             
            System.out.println("selectedFile = " + selectedFile);
            String regex = "\\.[A-z]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(selectedFile);
            if (matcher.find()) {
                 this.selectedFile = matcher.group(0);
            }
             
             
//        switch ( this.selectedFile) {
//           case  (".xml"):
//               this.RealReader = new readerXML(this.path);
//               break;
//           case (".yaml"):
//               this.RealReader = new readerYAML(path);
//               System.out.println("reader yaml setted");
//               break;
//
//           case (".json"):
//               System.out.println(this.selectedFile); // .json
//               this.RealReader = new readerJSON(path);
//               break;
//          case(".xlsx"):
//             // System.out.println("EXCEL SELECTED");
//              System.out.println("SELECTED FILE ========= " + this.path);
//              this.Mother.StartInsert("ReactorData.xlsx");
//              break;
//           
//       }
            if(!this.selectedFile.equals(".xlsx"))
            {
                readerManipulation rm = new readerManipulation();
                this.reactors = rm.importData(path);
             
                this.Mother.StartInsert((ArrayList<Reactor>) this.reactors);
//       this.RealReader.readFile(); /// само считываеие, паттерн которого нужно изменить на цепочку обязанностей
                
//       this.reactors = this.RealReader.getReactors();    
            }
            else
            {
                this.Mother.StartInsert(path);
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null, "Вы не выбрали файл", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CreatorSQL creator = new CreatorSQL();
        creator.dropSQL();
        this.Mother.StartCreate();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CreatorSQL creator = new CreatorSQL();
        creator.dropSQL();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
             CreatorSQL creator = new CreatorSQL();
             creator.agreg(1);
             String query = "select * from public.aggregation_countries;";
             DisplayerDB displayer0  = new DisplayerDB(query);
             DefaultTableModel dt = new DefaultTableModel(displayer0.getData(), displayer0.getColNames());
             this.jTable1.setModel(dt );
             JTable g = new JTable(displayer0.getData(), displayer0.getColNames())
             {
                 public Class getColumnClass(int column)
                 {
                     for(int row = 0;row<getRowCount();row++){
                         Object o = getValueAt(row, column);
                         if(o!=null){
                             return o.getClass();
                         }
                     }
                     return Object.class;
                 }
             };
             this.jTable1.setVisible(true);
         } catch (Exception e) {
            JOptionPane.showMessageDialog (null, "Проблемы с агрегацией", "Oшибка", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
             CreatorSQL creator = new CreatorSQL();
             creator.agreg(2);
             String query = "select * from public.aggregation_companies;";
             DisplayerDB displayer0  = new DisplayerDB(query);
             DefaultTableModel dt = new DefaultTableModel(displayer0.getData(), displayer0.getColNames());
             this.jTable1.setModel(dt );
             JTable g = new JTable(displayer0.getData(), displayer0.getColNames())
             {
                 public Class getColumnClass(int column)
                 {
                     for(int row = 0;row<getRowCount();row++){
                         Object o = getValueAt(row, column);
                         if(o!=null){
                             return o.getClass();
                         }
                     }
                     return Object.class;
                 }
             };
             this.jTable1.setVisible(true);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog (null, "Проблемы с агрегацией", "Oшибка", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
             CreatorSQL creator = new CreatorSQL();
             creator.agreg(3);
             String query = "select * from public.aggregation_regions;";
             DisplayerDB displayer0  = new DisplayerDB(query);
             DefaultTableModel dt = new DefaultTableModel(displayer0.getData(), displayer0.getColNames());
             this.jTable1.setModel(dt );
             JTable g = new JTable(displayer0.getData(), displayer0.getColNames())
             {
                 public Class getColumnClass(int column)
                 {
                     for(int row = 0;row<getRowCount();row++){
                         Object o = getValueAt(row, column);
                         if(o!=null){
                             return o.getClass();
                         }
                     }
                     return Object.class;
                 }
             };
             this.jTable1.setVisible(true);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog (null, "Проблемы с агрегацией", "Oшибка", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        CreatorSQL creator = new CreatorSQL();
        creator.calc();
    }//GEN-LAST:event_jButton7ActionPerformed

 
    
    public static void main(String args[]) {
      
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
