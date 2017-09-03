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
       ferrovia=trainsw.getFerrovia();
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
     ferrovia.inserisciStazione(1, 6, "via Giulio", "Trumpitello");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(2, 6, "via Cesare", "Mascali");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(3, 6, "via Augusto", "Giarre");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(4, 6, "via Treppello", "Acireale");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(5, 6, "via Nuova", "Catania CLE");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(6, 6, "via Vecchia", "Siracusa CLE");
     ferrovia.confermaStazione();
      
     
      

      ferrovia.InserisciCollegamento(1, "Trumpitello", "Mascali", 9 );
      ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(2, "Mascali", "Giarre", 14);
       ferrovia.ConfermaCollegamento();
     ferrovia.InserisciCollegamento(3, "Giarre", "Acireale", 23);
      ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(4, "Acireale", "Catania", 56);
       ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(5, "Catania", "Siracusa", 49);
      
    
Deposito dep;
      dep =ferrovia.inserisciDeposito(1,"Trumpitello", 2);
      ferrovia.confermaDeposito(dep);
   dep = ferrovia.inserisciDeposito(2, "Acireale", 10);
     ferrovia.confermaDeposito(dep);
  dep= ferrovia.inserisciDeposito(3, "Siracusa CLE", 10);
     ferrovia.confermaDeposito(dep);
         Treno tr1;
     
      Treno tr2;
     
      Treno tr3; 
      Treno tr4;

      ferrovia.InserisciTipologiaTreno(1, "regionale", (short)0, (short)70, (short)90, 170, 20, 5);
      ferrovia.ConfermaTipologiaTreno();
     tr1=ferrovia.InserisciTreno(1);
       ferrovia.confermaTreno();
       ferrovia.InserisciNelDeposito("Trumpitello", tr1);
      ferrovia.InserisciTipologiaTreno(2, "Intercity", (short)40, (short)70, (short)90, 170, 20, 5);
      ferrovia.ConfermaTipologiaTreno();
     
     tr2=   ferrovia.InserisciTreno(2);
       ferrovia.confermaTreno();
       ferrovia.InserisciNelDeposito("Acireale", tr2);
       ferrovia.InserisciTipologiaTreno(3, "Premium", (short)60, (short)20, (short)40, 170, 20, 5);
       ferrovia.ConfermaTipologiaTreno();
       tr3= ferrovia.InserisciTreno(3);
       ferrovia.confermaTreno();
       ferrovia.InserisciNelDeposito("Acireale", tr3);
      ferrovia.InserisciTipologiaTreno(4, "TrenOrfeo", (short)90, (short)45, (short)45, 170, 20, 5);
      ferrovia.ConfermaTipologiaTreno();
      ferrovia.ConfermaTipologiaTreno();
     tr4=   ferrovia.InserisciTreno(4);
       ferrovia.confermaTreno();
       ferrovia.InserisciNelDeposito("Siracusa CLE", tr4);
      
     
      
 
     
      
     if(ferrovia.getPercorsi().size()==0){
      ferrovia.creaPercorso();
    for(Fermata fer : ferrovia.InserisciStazione("Trumpitello", "Siracusa CLE"))
       ferrovia.InserisciFermata(fer);
      ferrovia.ConfermaPercorso();
     }
    
      
      Date trattaanno1 = null, trattaanno2 = null, trattaanno3 = null, trattaanno4 = null;
        try {
            trattaanno1 = format.parse("15 09 2017");
            trattaanno2 = format.parse("16 09 2017");
            trattaanno3 = format.parse("17 09 2017");
            trattaanno4 = format.parse("18 09 2017");
             
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    tr1=new Treno(1, new TipoTreno(1, "regionale", (short)0, (short)70, (short)90, 170, 20, 5));
   

      
    

      
    }

}
