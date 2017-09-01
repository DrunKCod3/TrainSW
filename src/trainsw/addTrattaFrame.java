/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciano Limina
 */
public class addTrattaFrame extends javax.swing.JFrame {
private TrainSW trainSW = TrainSW.getIstanza();
private List<Percorso> listper2;
        
    /**
     * Creates new form addTrattaFrame
     */
    public addTrattaFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idstapTratta = new javax.swing.JTextField();
        txt_idStaATratta = new javax.swing.JTextField();
        next_buttonTratta = new javax.swing.JButton();
        back_buttonTratta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserisci Tratta");

        jLabel1.setText("Inserisci id stazione partenza");

        jLabel2.setText("Inserisci id stazione arrivo");

        next_buttonTratta.setText("Avanti");
        next_buttonTratta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_buttonTrattaActionPerformed(evt);
            }
        });

        back_buttonTratta.setText("Annulla");
        back_buttonTratta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonTrattaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_idStaATratta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idstapTratta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(next_buttonTratta)
                        .addGap(18, 18, 18)
                        .addComponent(back_buttonTratta)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_idstapTratta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(txt_idStaATratta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next_buttonTratta)
                    .addComponent(back_buttonTratta))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void next_buttonTrattaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_buttonTrattaActionPerformed
       
        
        this.dispose();
        
        String id_stP = txt_idstapTratta.getText();
        String id_stA = txt_idStaATratta.getText();
        listper2 = trainSW.InserisciPartenzaArrivo(id_stP, id_stA);
        
        //Prendi i percorsi da qui
         
                String[] columnNames = {"ID Percorso",
                        "id Stazione partenza",
                        "id Stazione arrivo"
                        
                       };
                
                final JTable perTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel(0,0);
                
                dtm.setColumnIdentifiers(columnNames);
                perTab.setModel(dtm);
                
              
               
               for(Percorso per1 :listper2){
                   
                dtm.addRow(new Object[] {
                    per1.getId_per(),per1.getStaz_par(),per1.getStaz_arr()
                   
                   
                });
              
                }
                
           final JFrame tabfram = new JFrame("Scegli il percorso");
           tabfram.setSize(300, 400);
      
                                      
          perTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          perTab.setSize(200, 300);

JButton nextButton = new JButton("Avanti");
JButton endButton = new JButton("Fine");
JPanel panst = new JPanel(new FlowLayout());
panst.add(perTab);
panst.add(nextButton);
panst.add(endButton);
tabfram.add(panst);
tabfram.setVisible(true);
        
nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     
                        tabfram.dispose();
                           Percorso perc;
                          perc = listper2.get((int) perTab.getSelectedRow());
                       
                          trainSW.InserisciPercorso(perc);
                          
                           insOrarioFrame insOrarioframe;
                           insOrarioframe = new insOrarioFrame();
                           insOrarioframe.setVisible(true);
                           
                           
                           
                     //      System.out.println(perc.toString());
                           
                   insOrarioFrame insOraframe = new insOrarioFrame();
                   insOrarioframe.setVisible(true);
                     
                    }
                });

             endButton.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           tabfram.dispose();
                           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       }
                   });
           
            



    }//GEN-LAST:event_next_buttonTrattaActionPerformed

    private void back_buttonTrattaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonTrattaActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_back_buttonTrattaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addTrattaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addTrattaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addTrattaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addTrattaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addTrattaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_buttonTratta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton next_buttonTratta;
    private javax.swing.JTextField txt_idStaATratta;
    private javax.swing.JTextField txt_idstapTratta;
    // End of variables declaration//GEN-END:variables
}
