/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Luciano Limina
 */
public class insOrarioFrame extends javax.swing.JFrame {

    private TrainSW trainSW = TrainSW.getIstanza();
    List<Treno> listTr = new ArrayList<Treno>();
    List<FermataOrario> listFerm = new ArrayList<FermataOrario>();
    /**
     * Creates new form insOrarioFrame
     */
    public insOrarioFrame() {
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
        txt_Data = new javax.swing.JTextField();
        next_orarioTrButton = new javax.swing.JButton();
        annulla_orarioButton = new javax.swing.JButton();
        txt_Orario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Inserisci Data e Orario");

        txt_Data.setToolTipText("gg mm aaaa");

        next_orarioTrButton.setText("Avanti");
        next_orarioTrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_orarioTrButtonActionPerformed(evt);
            }
        });

        annulla_orarioButton.setText("Annulla");
        annulla_orarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulla_orarioButtonActionPerformed(evt);
            }
        });

        txt_Orario.setToolTipText("hh:ss");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Orario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(next_orarioTrButton)
                        .addGap(29, 29, 29)
                        .addComponent(annulla_orarioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_Orario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next_orarioTrButton)
                    .addComponent(annulla_orarioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void next_orarioTrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_orarioTrButtonActionPerformed
     
        
String str = txt_Orario.getText();
 DateFormat formatter = new SimpleDateFormat("hh:mm");
        try {
            Date ora = formatter.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
DateFormat format = new SimpleDateFormat("dd mm yyyy", Locale.ITALIAN);
Date anno = null;
        try {
            anno = format.parse(txt_Data.getText());
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        

         this.dispose();
                
                //Caricare prima questa lista, importante : listSt e JTable devono essere sincronizzati
                // stessi indici-->  -riga = index list 
                
                   final List<Treno> listTr = trainSW.InserisciOrario(anno);
                
                  // listTr.add();
               
                
                String[] columnNames = {"ID Treno",
                    "Nome Tipologia",
                    "Posti letto",
                    "Posti Prima Classe",
                    "Posti Seconda Classe",
                    "Velocita",
                    "Prezzo Prima",
                    "Prezzo Seconda"
                };
                
                final JTable stTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel();
                
                dtm.setColumnIdentifiers(columnNames);
              
                
                for(Treno tr:listTr){
                   
                dtm.addRow(new Object[] {
                 //Aggiungi treni qui 
                tr.getId_tr(), tr.getTt().getTt_name(),  tr.getTt().getPosti_letto(),  tr.getTt().getNp_1c(),
               tr.getTt().getNp_2c(),  tr.getTt().getVelocita(), tr.getTt().getPrezzo_prima(), tr.getTt().getPrezzo_seconda()
                   
                });
        
                
                }
            stTab.setModel(dtm);
           
             stTab.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
           final JFrame tabfram = new JFrame("Scegli un treno");
           tabfram.setSize(600, 450);
           
                                      
          stTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 

JButton nextButton = new JButton("Avanti");
JButton endButton = new JButton("Fine");
JPanel panst = new JPanel(new FlowLayout());
panst.add(new JScrollPane(stTab));
panst.add(nextButton);
panst.add(endButton);
tabfram.add(panst);
tabfram.setVisible(true);

    
nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     
                       tabfram.dispose();
                           
                       // Inserire treno nella tratta
                       Treno tr;
                           tr = listTr.get((int) stTab.getSelectedRow());
         
                           
                           /* VIsualizzare Fermate */
                           
                            
                
                //Caricare prima questa lista, importante : listSt e JTable devono essere sincronizzati
                // stessi indici-->  -riga = index list 
                
                  listFerm = trainSW.InserisciTreno(tr);
                   
               
                   
                
                String[] columnNames = {"Stazione Fermata","Orario"};
                
                final JTable stTab1 = new JTable();
                final DefaultTableModel dtm1 = new DefaultTableModel();
                
                dtm1.setColumnIdentifiers(columnNames);
                stTab1.setModel(dtm1);
                 
                
                 Session session = NewHibernateUtil.getSessionFactory().openSession();
                 session.beginTransaction();
                for(FermataOrario fermOr :listFerm){
                 Fermata   ferm=(Fermata) session.load(Fermata.class, fermOr.getFermata().getId_fer());
                System.out.println(fermOr.getOrario().toString());
                dtm1.addRow(new String[] {
                  //Aggiungi fermate alla lista
                    
                    ferm.getStazione().getNome_stazione(),fermOr.getOrario().toString()
                    
                });
           
                }
                session.getTransaction().commit();
                session.close();
               
           final JFrame tabfram = new JFrame("Visualizza Fermate della Tratta");
           tabfram.setSize(500, 500);
           
                                      
      stTab1.getColumnModel().getColumn(1).setResizable(true);
      stTab1.getColumnModel().getColumn(1).setMinWidth(200);   
          

JButton endButton1 = new JButton("Fine");
JPanel panst1 = new JPanel(new FlowLayout());
panst1.add(stTab1);
panst1.setSize(500, 500);
panst1.add(endButton1);
tabfram.add(panst1);
tabfram.setVisible(true);


             endButton1.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           tabfram.dispose();
                           trainSW.ConfermaTratta();
                       }
                   });
           
            }
        });
                           
                           
                           
                       
                           
                 


            
           
            
   
        
        
    }//GEN-LAST:event_next_orarioTrButtonActionPerformed

    private void annulla_orarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulla_orarioButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_annulla_orarioButtonActionPerformed


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
            java.util.logging.Logger.getLogger(insOrarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insOrarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insOrarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insOrarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insOrarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulla_orarioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton next_orarioTrButton;
    private javax.swing.JTextField txt_Data;
    private javax.swing.JTextField txt_Orario;
    // End of variables declaration//GEN-END:variables
}
