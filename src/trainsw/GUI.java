/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTable;

import javax.swing.JTextField;

import javax.swing.ListSelectionModel;

import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Luciano Limina
 */
public class GUI extends javax.swing.JFrame {

    /* UC1 Gestisci Stazione */
    private TrainSW trainSw = TrainSW.getIstanza();
    List<Fermata> listSt = new ArrayList<Fermata>();
    List<Tratta> listTrSA = new ArrayList<Tratta>();
    Tessera tessera;

    public Stazione creaStazione(int id_st, int num_bin, String locazione, String nome_stazione) {
        Stazione stazione = new Stazione(id_st, num_bin, locazione, nome_stazione);
        return stazione;
    }

    /*
     public boolean isPresentSt(int id_st) {
        
     }

     */
    /**
     * Creates new form GUI
     */
    public GUI() {
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

        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        gestisciSt = new javax.swing.JMenuItem();
        gestisciDep = new javax.swing.JMenuItem();
        gestisciColl = new javax.swing.JMenuItem();
        gestisciTr = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Welcome to TrainSW");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setText("Press TrainSw to Start");

        jLabel3.setText("Progetto Ingegneria del Software 2016-2017");

        jLabel4.setText("Limina Luciano , Longhitano Andrea , Previti Luis");

        jMenuBar1.setBackground(new java.awt.Color(255, 102, 102));

        jMenu1.setText("TrainSW");

        gestisciSt.setText("Gestisci Stazione");
        gestisciSt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestisciStActionPerformed(evt);
            }
        });
        jMenu1.add(gestisciSt);

        gestisciDep.setText("Gestisci Deposito");
        gestisciDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestisciDepActionPerformed(evt);
            }
        });
        jMenu1.add(gestisciDep);

        gestisciColl.setText("Gestisci Collegamento");
        gestisciColl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestisciCollActionPerformed(evt);
            }
        });
        jMenu1.add(gestisciColl);

        gestisciTr.setText("Gestisci Treno");
        gestisciTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestisciTrActionPerformed(evt);
            }
        });
        jMenu1.add(gestisciTr);

        jMenuItem2.setText("Gestisci Percorso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Gestisci Tratta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Gestisci Solo-Andata");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Gestisci Abbonamento");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Gestissci Tessera");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenu2.setText("Gestisci Acquisto");

        jMenuItem7.setText("Acquisto con Punti");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem6.setText("Acquisto con Tessera");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Help");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("About");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestisciDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciDepActionPerformed
        JFrame gst = new JFrame("Gestisci Deposito");
        gst.setVisible(true);
        gst.setSize(300, 200);
        JPanel pan = new JPanel(new FlowLayout());
        pan.setVisible(true);

        JButton addDp = new JButton("Aggiungi Deposito");
        JButton viewDp = new JButton("Visualizza Depositi");

        gst.add(pan);

        pan.add(addDp);
        pan.add(viewDp);

        addDp.setLocation(0, 100);

        addDp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addDepFrame addDepframe = new addDepFrame();
                addDepframe.setVisible(true);

            }
        });


        viewDp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  JFrame viewObj = new JFrame("Visualizza Depositi");
                JPanel pan = new JPanel(new FlowLayout());
                Ferrovia ferrovia = trainSw.getFerrovia();
                DefaultListModel demod = new DefaultListModel();
                JList viewList = new JList(demod);
                boolean lock = false;

                viewObj.add(pan);
                pan.add(viewList);

                viewObj.setSize(500, 400);
                viewObj.setVisible(true);

                      Session session= new NewHibernateUtil().getSessionFactory().openSession();
                      session.beginTransaction();
                      
                
                for (Stazione stazione : ferrovia.getStazioni()) {
                 stazione = (Stazione) session.load(Stazione.class, stazione.getId_stazione());
                 
                  
                   
                    if(stazione.getDeposito()!=null && lock==false) {
                     
                     lock = true;
                    System.out.println(stazione.getDeposito().toString());
                    demod.addElement(stazione.getDeposito().toString());
                 }
                    if(lock== false && stazione.getDeposito() == null) {
                        lock = true;
                     JOptionPane.showMessageDialog(new JFrame(), "Nessun Deposito presente", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                    }
                session.getTransaction().commit();
                session.close();
            }
        });
        
        
        
    }//GEN-LAST:event_gestisciDepActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        addTrattaFrame addTrframe = new addTrattaFrame();
        addTrframe.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        final JFrame frame = new JFrame();
        JPanel pan = new JPanel();
        JLabel lab1 = new JLabel("Inserisci nome stazioni");
        final JTextField txt_idStaPSA = new JTextField(10);
        final JTextField txt_idStaASA = new JTextField(10);
        JButton nextSA_button = new JButton("Avanti");
        pan.add(lab1);
        pan.add(txt_idStaPSA);
        pan.add(txt_idStaASA);
        pan.add(nextSA_button);
        trainSw.gestisciSoloAndata();
        frame.add(pan);
        frame.setSize(250, 150);
        frame.setVisible(true);

        nextSA_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_sta_PSA = txt_idStaPSA.getText();
                String id_sta_ASA = txt_idStaASA.getText();
                listTrSA = trainSw.inserisciStazioneArrivo(id_sta_PSA, id_sta_ASA);

                String[] columnNames = {"ID Tratta",
                    "Data partenza",
                    "Data arrivo",
                    " Stazione partenza",
                    "Stazione arrivo"

                };

                final JTable perTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel(0, 0);

                dtm.setColumnIdentifiers(columnNames);
                perTab.setModel(dtm);

                int index, i = 0;
                index = listTrSA.size();

                for (Tratta tratta : listTrSA) {

                    dtm.addRow(new Object[]{
                        tratta.getId_tratta(), tratta.getData_p().toString(), tratta.getData_a().toString(), tratta.getPercorso().getStaz_par(), tratta.getPercorso().getStaz_arr()

                    });

                }

                frame.dispose();

                final JFrame tabfram = new JFrame("Scegli la tratta e inserisci la classe desiderata");
                tabfram.setSize(600, 140);

                perTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                JButton nextSAButton = new JButton("Avanti");
                JButton endButton = new JButton("Fine");
                final JTextField txt_class = new JTextField(2);
                txt_class.setName("classe");

                JPanel panst = new JPanel(new FlowLayout());
                panst.add(txt_class);
                panst.add(perTab);
                panst.add(nextSAButton);
                panst.add(endButton);
                tabfram.add(panst);
                tabfram.setVisible(true);

                nextSAButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        tabfram.dispose();
                        Tratta trattasx;
                        trattasx = listTrSA.get((int) perTab.getSelectedRow());
                        int classe;
                        classe = new Integer(txt_class.getText());
                        Biglietto biglietto;
                        biglietto = trainSw.scegliTratta(trattasx, classe);

                        final JFrame confBiglietto = new JFrame("Visualizza Biglietto");
                        JPanel pan = new JPanel(new FlowLayout());
                        JButton confButtonBiglietto = new JButton("Conferma");
                        JLabel bigliettoLab = new JLabel(biglietto.toString());
                        pan.add(bigliettoLab);
                        pan.add(confButtonBiglietto);
                        confBiglietto.add(pan);
                        confBiglietto.setVisible(true);
                        confBiglietto.setSize(560, 100);

                        confButtonBiglietto.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                trainSw.ConfermaBiglietto();
                                confBiglietto.dispose();
                            }
                        });

                    }
                });

            }
        });

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        insClienteFrame inClienteframe = new insClienteFrame();
        inClienteframe.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void gestisciStActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciStActionPerformed

        JFrame gst = new JFrame("Gestisci Stazione");
        gst.setVisible(true);
        gst.setSize(300, 200);
        JPanel pan = new JPanel(new FlowLayout());
        pan.setVisible(true);

        JButton addSt = new JButton("Aggiungi Stazione");
        JButton viewSt = new JButton("Visualizza Stazioni");

        gst.add(pan);

        pan.add(addSt);
        pan.add(viewSt);

        addSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addStFrame addStframe = new addStFrame();
                addStframe.setVisible(true);

            }
        });

        viewSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame viewObj = new JFrame("Visualizza Stazioni");
                JPanel pan = new JPanel(new FlowLayout());
                Ferrovia ferrovia = trainSw.getFerrovia();
                DefaultListModel demod = new DefaultListModel();
                JList viewList = new JList(demod);

                viewObj.add(pan);
                pan.add(viewList);

                viewObj.setSize(600, 350);
                viewObj.setVisible(true);

                for (Stazione stazione : ferrovia.getStazioni()) {
                    demod.addElement(stazione.toString());

                }

            }
        });


    }//GEN-LAST:event_gestisciStActionPerformed

    private void gestisciCollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciCollActionPerformed

        JFrame gst = new JFrame("Gestisci Collegamento");
        gst.setVisible(true);
        gst.setSize(300, 200);
        JPanel pan = new JPanel(new FlowLayout());
        pan.setVisible(true);

        JButton addCol = new JButton("Aggiungi Collegamento");
        JButton viewCol = new JButton("Visualizza Collegamenti");

        gst.add(pan);

        pan.add(addCol);
        pan.add(viewCol);

        addCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddCollFrame addCollframe = new AddCollFrame();
                addCollframe.setVisible(true);

            }
        });

        viewCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewObj = new JFrame("Visualizza Collegamenti");
                JPanel pan = new JPanel(new FlowLayout());
                Ferrovia ferrovia = trainSw.getFerrovia();

                DefaultListModel demoList = new DefaultListModel();

                JList listd = new JList(demoList);

                viewObj.add(pan);
                pan.add(listd);

                viewObj.setSize(300, 400);
                viewObj.setVisible(true);

                  Session session= new NewHibernateUtil().getSessionFactory().openSession();
                      session.beginTransaction();
                
                
                for (Collegamento collegamento : ferrovia.getCollegamenti()) {
                    demoList.addElement(collegamento.toString());
                    ;

                }
                 session.getTransaction().commit();
                session.close();
            }
        });

    }//GEN-LAST:event_gestisciCollActionPerformed

    private void gestisciTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciTrActionPerformed

        AddTipologiaTrenoFrame addTTframe = new AddTipologiaTrenoFrame();
        addTTframe.setVisible(true);

    }//GEN-LAST:event_gestisciTrActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        trainSw.GestisciPercorso();
        final JFrame frame = new JFrame("Inserisci Percorso");
        frame.setVisible(true);
        JPanel pan = new JPanel(new FlowLayout());

        JLabel lab = new JLabel("Inserisci id stazioni partenza e arrivo");
        final JTextField txt_sta1;
        final JTextField txt_sta2;
        txt_sta1 = new JTextField(10);
        txt_sta2 = new JTextField(10);
        JButton nextButton = new JButton("Prosegui");
        JButton annullaButton = new JButton("Annulla");
        pan.add(lab);
        pan.add(txt_sta1);
        pan.add(txt_sta2);
        pan.add(nextButton);
        pan.add(annullaButton);
        frame.setSize(300, 200);
        frame.add(pan);

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String idStazA, idStazB;
                idStazA = txt_sta1.getText();
                idStazB = txt_sta2.getText();

     
                listSt = trainSw.InserisciStazioni(idStazA, idStazB);

                String[] columnNames = {"ID Fermata",
                    "Nome Stazione",
                    "Locazione",
                    "Numero Binari"
                };

                final JTable stTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel(0, 0);

                dtm.setColumnIdentifiers(columnNames);
                stTab.setModel(dtm);
      
               
                //Aggiungere elementi lista nella tabella
              
                Session session = NewHibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                  
           
                   for(Fermata fer : listSt){
                    Stazione st=(Stazione) session.load(Stazione.class, fer.getId_stazione());
                    dtm.addRow(new Object[]{
                    fer.getId_stazione(), st.getNome_stazione(),st.getLocazione()
                    
                    });
               
                }
               session.close();

                final JFrame tabfram = new JFrame("Scegli le fermate");
                tabfram.setSize(300, 800);

                stTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                stTab.setSize(500, 400);

                JButton nextButton = new JButton("Avanti");
                JButton endButton = new JButton("Fine");
                JPanel panst = new JPanel(new FlowLayout());
                panst.add(stTab);
                panst.add(nextButton);
                panst.add(endButton);
                tabfram.add(panst);
                tabfram.setVisible(true);

                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Fermata sts;
                        sts = listSt.get((int) stTab.getSelectedRow());
                     //   listSt.remove((int) stTab.getSelectedRow());
                        trainSw.InserisciFermata(sts);

                   //        System.out.println(sts.toString());
                    }
                });

                endButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        trainSw.ConfermaPercorso();
                       
                        tabfram.dispose();
                        
                   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

            }
        });


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        /* Gestisci Abbonamento */
        gestAbbonamento gestAbbonamento1 = new gestAbbonamento();
        gestAbbonamento1.setVisible(true);


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        Date data_n = new Date();
        Cliente cliente = new Cliente("Ajeje", "Brazorf", "AJJBRZF12JD34X", data_n, 'm');
        tessera = new Tessera(1, data_n, data_n, 0, cliente);
        trainSw.InserisciTessera(tessera);

        /**
         * **********************************************
         *
         * Acquisto Biglietto
         * ********************************************
         */
      final JFrame frame = new JFrame();
        JPanel pan = new JPanel();
        JLabel lab1 = new JLabel("Inserisci id stazioni");
        final JTextField txt_idStaPSA = new JTextField(10);
        final JTextField txt_idStaASA = new JTextField(10);
        JButton nextSA_button = new JButton("Avanti");
        pan.add(lab1);
        pan.add(txt_idStaPSA);
        pan.add(txt_idStaASA);
        pan.add(nextSA_button);
        trainSw.gestisciSoloAndata();
        frame.add(pan);
        frame.setSize(150, 200);
        frame.setVisible(true);

        nextSA_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_sta_PSA = txt_idStaPSA.getText();
                String id_sta_ASA = txt_idStaASA.getText();
                listTrSA = trainSw.inserisciStazioneArrivo(id_sta_PSA, id_sta_ASA);

                String[] columnNames = {"ID Tratta",
                    "Data partenza",
                    "Data arrivo",
                    " Stazione partenza",
                    "Stazione arrivo"

                };

                final JTable perTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel(0, 0);

                dtm.setColumnIdentifiers(columnNames);
                perTab.setModel(dtm);

     

                for (Tratta tratta : listTrSA) {

                    dtm.addRow(new Object[]{
                        tratta.getId_tratta(), tratta.getData_p().toString(), tratta.getData_a().toString(), tratta.getPercorso().getStaz_par(), tratta.getPercorso().getStaz_arr()

                    });

                }

                frame.dispose();

                final JFrame tabfram = new JFrame("Inserisci la classe e scegli la tratta");
                tabfram.setSize(500, 200);

                perTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                JButton nextSAButton = new JButton("Avanti");
                JButton endButton = new JButton("Fine");
                final JTextField txt_class = new JTextField(2);

                JPanel panst = new JPanel(new FlowLayout());
                panst.add(txt_class);
                panst.add(perTab);
                panst.add(nextSAButton);
                panst.add(endButton);
                tabfram.add(panst);
                tabfram.setVisible(true);

                nextSAButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        tabfram.dispose();
                        Tratta trattasx;
                        trattasx = listTrSA.get((int) perTab.getSelectedRow());
                        int classe;
                        classe = new Integer(txt_class.getText());
                        Biglietto biglietto;
                        biglietto = trainSw.scegliTratta(trattasx, classe);

                        final JFrame confBiglietto = new JFrame("Visualizza Biglietto");
                        JPanel pan = new JPanel(new FlowLayout());
                        JButton confButtonBiglietto = new JButton("Conferma");
                        JLabel bigliettoLab = new JLabel(biglietto.toString());
                        pan.add(bigliettoLab);
                        pan.add(confButtonBiglietto);
                        confBiglietto.add(pan);
                        confBiglietto.setVisible(true);
                        confBiglietto.setSize(500, 100);

                        confButtonBiglietto.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                trainSw.confermaBigliettoTessera();
                                confBiglietto.dispose();
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });

                    }
                });

            }
        });


    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Date data_n = new Date();
        Cliente cliente = new Cliente("Ajeje", "Brazorf", "JJBRZF23FXCVW", data_n, 'm');
        tessera = new Tessera(1, cliente);
        trainSw.InserisciTessera(tessera);

        final JFrame frame = new JFrame();
        JPanel pan = new JPanel();
        JLabel lab1 = new JLabel("Inserisci id stazioni");
        final JTextField txt_idStaPSA = new JTextField(2);
        final JTextField txt_idStaASA = new JTextField(2);
        JButton nextSA_button = new JButton("Avanti");
        pan.add(lab1);
        pan.add(txt_idStaPSA);
        pan.add(txt_idStaASA);
        pan.add(nextSA_button);
        frame.add(pan);
        frame.setSize(100, 150);
        frame.setVisible(true);

        nextSA_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_sta_PSA = txt_idStaPSA.getText();
                String id_sta_ASA = txt_idStaASA.getText();
                listTrSA = trainSw.inserisciStazioneArrivo(id_sta_PSA, id_sta_ASA);

                String[] columnNames = {"ID Tratta",
                    "Data partenza",
                    "Data arrivo",
                    " Stazione partenza",
                    "Stazione arrivo"

                };

                final JTable perTab = new JTable();
                final DefaultTableModel dtm = new DefaultTableModel(0, 0);

                dtm.setColumnIdentifiers(columnNames);
                perTab.setModel(dtm);

                int index, i = 0;
                index = listTrSA.size();

                while (i <= index) {
                    Tratta tratta = listTrSA.get(i);
                    dtm.addRow(new Object[]{
                        tratta.getId_tratta(), tratta.getData_p().toString(), tratta.getData_a().toString(), tratta.getPercorso().getStaz_par(), tratta.getPercorso().getStaz_arr()

                    });
                    i = i + 1;
                }

                frame.dispose();

                final JFrame tabfram = new JFrame("Scegli la tratta");
                tabfram.setSize(300, 450);

                perTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                JButton nextSAButton = new JButton("Avanti");
                JButton endButton = new JButton("Fine");
                final JTextField txt_class = new JTextField(2);

                JPanel panst = new JPanel(new FlowLayout());
                panst.add(txt_class);
                panst.add(perTab);
                panst.add(nextSAButton);
                panst.add(endButton);
                tabfram.add(panst);
                tabfram.setVisible(true);

                nextSAButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        tabfram.dispose();
                        Tratta trattasx;
                        trattasx = listTrSA.get((int) perTab.getSelectedRow());
                        int classe;
                        classe = new Integer(txt_class.getText());
                        Biglietto biglietto;
                        biglietto = trainSw.scegliTratta(trattasx, classe);

                        final JFrame confBiglietto = new JFrame("Visualizza Biglietto");
                        JPanel pan = new JPanel(new FlowLayout());
                        JButton confButtonBiglietto = new JButton("Conferma");
                        JLabel bigliettoLab = new JLabel(biglietto.toString());
                        pan.add(bigliettoLab);
                        pan.add(confButtonBiglietto);
                        confBiglietto.add(pan);
                        confBiglietto.setVisible(true);
                        confBiglietto.setSize(500, 100);

                        confButtonBiglietto.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                confBiglietto.dispose();
                            }
                        });

                    }
                });

            }
        });


    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem gestisciColl;
    private javax.swing.JMenuItem gestisciDep;
    private javax.swing.JMenuItem gestisciSt;
    private javax.swing.JMenuItem gestisciTr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
