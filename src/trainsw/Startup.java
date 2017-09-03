/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class Startup {
    
    private TrainSW trainsw;
    private POS pos;
    private Ferrovia ferrovia;
    private Stazione stazione;
    private TipoTreno tipotreno;
    private Percorso percorso;
   

    
    
    public Startup(TrainSW trainsw) {
        
        
        String string1  = "12 10 2017";
        String string2 = "14 12 2020";
        String string3 = "25 12 2017";
        String string4 = "01 01 2018";
        
        String string5 = "01 01 2000";
        String string6 = "01 01 2005";
        
        this.trainsw = trainsw;
       pos = trainsw.getPos();
       
   DateFormat format = new SimpleDateFormat("dddd mm yyyy", Locale.ITALIAN);
        Date anno1 = null, anno2 = null, anno3 = null, anno4 = null;
        Date anno5 = null, anno6 = null ;
        try {
            anno1 = format.parse(string1);
            anno2 = format.parse(string2);
            anno3 = format.parse(string3);
            anno4 = format.parse(string4);
            anno5 = format.parse(string5);
            anno6 = format.parse(string6);
             
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Cliente cliente = new Cliente("Ajeje", "Brazorf", "JJBRZF23FXCVW", new Date(), 'm');
       Tessera tessera1 = new Tessera(1, anno1, anno2, 1000, cliente);

       
       Cliente cliente1 = new Cliente("Mario", "Rossi", "MRRS12A24DVDX", new Date(), 'm');
       Tessera tessera2 = new Tessera(2, anno3, anno4, 0, cliente1);
       
       Cliente cliente2 = new Cliente("Rosario","Farsaperla","RSRJIOSFVN2X", new Date(), 'm');
       Tessera tessera3 = new Tessera(3,anno5 , anno6, 980,cliente2);
       
      Promozione promoStandard = new PromoStandard("Standard",100, 0.05);
      Promozione promoSoglia = new PromoSoglia ("Soglia", 250, 80, 0.4);
      Promozione allInclusivePromo = new AllInclusivePromo("AllInclusive", 350);
      
      allInclusivePromo.addPromotion(promoSoglia);
      allInclusivePromo.addPromotion(promoStandard);

      pos.addPromozione(promoSoglia);
      pos.addPromozione(promoStandard);
      pos.addPromozione(allInclusivePromo);
      
      this.trainsw.addTessera(tessera1);
      this.trainsw.addTessera(tessera2);
      this.trainsw.addTessera(tessera3);
      
      TipoAbbonamento tipoabb1 = new AbbonamentoMensile("Mensile", 30, 100);
      TipoAbbonamento tipoabb2 = new AbbonamentoSettimanale("Settimanale", 7, 300);
      TipoAbbonamento tipoabb3 = new AbbonamentoAnnuale("Annuale", 365, 500);
      
      this.pos.addTipoAbbonamento(tipoabb3);
      this.pos.addTipoAbbonamento(tipoabb2);
      this.pos.addTipoAbbonamento(tipoabb1);
      
      Stazione sta1 = new Stazione(1, 6, "via Giulio", "Trumpitello");
      Stazione sta2 = new Stazione(2, 6, "via Cesare", "Mascali");
      Stazione sta3 = new Stazione(3, 6, "via Augusto", "Giarre");
      Stazione sta4 = new Stazione(4, 6, "via Treppello", "Acireale");
      Stazione sta5 = new Stazione(5, 6, "via Nuova", "Catania CLE");
      Stazione sta6 = new Stazione(6, 6, "via Vecchia", "Siracusa CLE");
      
      this.ferrovia.addStazione(sta1);
      this.ferrovia.addStazione(sta2);
      this.ferrovia.addStazione(sta3);
      this.ferrovia.addStazione(sta4);
      this.ferrovia.addStazione(sta5);
      this.ferrovia.addStazione(sta6);
      
      Collegamento col1 = new Collegamento(1, "Trumpitello", "Mascali", 9, sta1, sta2);
      Collegamento col2 = new Collegamento(2, "Mascali", "Giarre", 9, sta2, sta3);
      Collegamento col3 = new Collegamento(3, "Giarre", "Acireale", 9, sta3, sta4);
      Collegamento col4 = new Collegamento(4, "Acireale", "Catania", 9, sta4, sta5);
      Collegamento col5 = new Collegamento(5, "Catania", "Siracusa", 9, sta5, sta6);
      
      this.ferrovia.addCollegamento(col1);
      this.ferrovia.addCollegamento(col2);
      this.ferrovia.addCollegamento(col3);
      this.ferrovia.addCollegamento(col4);
      this.ferrovia.addCollegamento(col5);

      Deposito dep1 = new Deposito(1, 1, 2);
      Deposito dep2 = new Deposito(2, 4, 10);
      Deposito dep3 = new Deposito(3, 6, 10);
      
      this.stazione.addListDeposito(dep1);
      this.stazione.addListDeposito(dep2);
      this.stazione.addListDeposito(dep3);

      TipoTreno tipotr1 = new TipoTreno(1, "regionale", (short)0, (short)70, (short)90, 170, 20, 5);
      TipoTreno tipotr2 = new TipoTreno(2, "Intercity", (short)40, (short)70, (short)90, 170, 20, 5);
      TipoTreno tipotr3 = new TipoTreno(3, "Premium", (short)60, (short)20, (short)40, 170, 20, 5);
      TipoTreno tipotr4 = new TipoTreno(4, "TrenOrfeo", (short)90, (short)45, (short)45, 170, 20, 5);
      
      this.ferrovia.addTipoTreno(tipotr1);
      this.ferrovia.addTipoTreno(tipotr2);
      this.ferrovia.addTipoTreno(tipotr3);
      this.ferrovia.addTipoTreno(tipotr4);
      
      Treno tr1 = new Treno(1, tipotr1);
      Treno tr2 = new Treno(2, tipotr2);
      Treno tr3 = new Treno(3, tipotr3);
      Treno tr4 = new Treno(4, tipotr4);
      
      this.tipotreno.addListTreno(tr1);
      this.tipotreno.addListTreno(tr2);
      this.tipotreno.addListTreno(tr3);
      this.tipotreno.addListTreno(tr4);
      
      Percorso pr1 = new Percorso(1,"Trumpitello", "Mascali");
      Percorso pr2 = new Percorso(2,"Mascali", "Giarre");
      Percorso pr3 = new Percorso(3,"Giarre", "Acireale");
      
      this.ferrovia.addPercorso(pr1);
      this.ferrovia.addPercorso(pr2);
      this.ferrovia.addPercorso(pr3);
      
      Date trattaanno1 = null, trattaanno2 = null, trattaanno3 = null, trattaanno4 = null;
        try {
            trattaanno1 = format.parse("15 09 2017");
            trattaanno2 = format.parse("16 09 2017");
            trattaanno3 = format.parse("17 09 2017");
            trattaanno4 = format.parse("18 09 2017");
             
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      Tratta tratta1 = new Tratta(1, trattaanno1);
      Tratta tratta2 = new Tratta(2, trattaanno2);
      Tratta tratta3 = new Tratta(3, trattaanno3);
      Tratta tratta4 = new Tratta(4, trattaanno4);
      
      this.percorso.addTratta(tratta1);
      this.percorso.addTratta(tratta2);
      this.percorso.addTratta(tratta3);
      this.percorso.addTratta(tratta4);

      
    }

}
