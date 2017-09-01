    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Andrea
 */
public class TrainSW {
  private POS pos;
  private Ferrovia ferrovia;
  private Cliente cliente_corrente;
  private List<Cliente> clienti_registrati;
  private List<Tessera> tessere_registrate;
  private Tessera tessera_corrente;
  private static TrainSW singleton;
       
  
  
      public static TrainSW getIstanza(){
		if (singleton == null)
			singleton = new TrainSW();
		return singleton;
	}
	
     private TrainSW(){
         this.pos= new POS();
         this.ferrovia=new Ferrovia();
     }

    public Ferrovia getFerrovia() {
        return ferrovia;
    }

    public void setFerrovia(Ferrovia ferrovia) {
        this.ferrovia = ferrovia;
    }
  
    
     
    /**
     * **********************************
     * UC1 Gestisci Stazione * ***********************************
     */
     
     public Stazione inserisciStazione(int id_staz,int num_bin,String locazione,String nome_stazione){
         
        Stazione st= ferrovia.inserisciStazione(id_staz, num_bin, locazione, nome_stazione);
         return  st;
     }
     public void confermaStazione(){
         ferrovia.confermaStazione();
     }
     
     
         
    /**
     * **********************************
     * UC2 Gestisci Deposito * ***********************************
     */
     public Deposito inserisciDeposito(int id_dep,int id_staz,int num_posti){
       Deposito dp=ferrovia.inserisciDeposito(id_dep, id_staz, num_posti);
         return dp;
     }
     public void ConfermaDepostio(Deposito dp){
         ferrovia.confermaDeposito(dp);
     }
    /**
     * **********************************
     * UC3 Gestisci Collegamento * ***********************************
     */ 
     
     public Collegamento inserisciCollegamento(int id_collegamento,int id_staA,int id_staB,int distanza){
           Collegamento col=ferrovia.InserisciCollegamento(id_collegamento, id_staA, id_staB, distanza);
           return col;
     }
     public void confermaCollegamento(){
         ferrovia.ConfermaCollegamento();
     }
         /**
     * **********************************
     * UC4 Gestisci Treno * ***********************************
     */ 
     public TipoTreno InserisciTipologiaTreno(int id_tt, String tt_name, short posti_letto,short np_2c, short np_1c,double velocita, double prezzo_prima, double prezzo_seconda){
      TipoTreno tp=ferrovia.InserisciTipologiaTreno(id_tt, tt_name, posti_letto, np_2c, np_1c, velocita, prezzo_prima, prezzo_seconda);
      return tp;
     }
     
     public void confermaTipologiaTreno(){
         ferrovia.ConfermaTipologiaTreno();
     }
     
     public Treno InserisciTreno(int id_t){
         Treno treno= ferrovia.InserisciTreno(id_t);
         return treno;
     }
     public void confermaTreno(){
         ferrovia.confermaTreno();
     }
     public void InserisciNelDeposito(int id_st,Treno tr){
         ferrovia.InserisciNelDeposito(id_st, tr);
     }
       /**
     * **********************************
     * UC5 Gestisci Percorso * ***********************************
     */ 
     public void GestisciPercorso(){
         ferrovia.creaPercorso();
     }
    public List<Fermata> InserisciStazioni(int id_staA,int id_staB){
       
      List<Fermata> fermate  =ferrovia.InserisciStazione(id_staA, id_staB);
      return fermate;
    } 
    
    public void InserisciFermata(Fermata fr){
       ferrovia.InserisciFermata(fr);
    }
    
    public void ConfermaPercorso(){
        ferrovia.ConfermaPercorso();
    }
       /**
     * **********************************
     * UC6 Gestisci Tratta * ***********************************
     */ 
    public List<Percorso> InserisciPartenzaArrivo(int idstaA,int idstaB){
       List<Percorso> percorsi= ferrovia.findPercorso(idstaA, idstaB);
       return percorsi;
    }
    
    public void InserisciPercorso(Percorso pr){
        ferrovia.InserisciPercorso(pr);
    }
    
    public List<Treno> InserisciOrario(Date data_p){
      List<Treno> treni= ferrovia.InserisciOrario(data_p);
      return treni;
    }
    
    public List<FermataOrario> InserisciTreno(Treno tr){
     List<FermataOrario> fermate = ferrovia.InserisciTreno(tr);
     return fermate;
    }
    public void ConfermaTratta(){
        ferrovia.ConfermaTratta();
    } 
        /**
     * **********************************
     * UC7 Gestisci  Solo-Andata* ***********************************
     */ 
    public void gestisciSoloAndata(){
        pos.creaBiglietto();
    }
    public List<Tratta> inserisciStazioneArrivo(int id_sta_par,int id_sta_arr){
        pos.inserisciStazioneArrivo(id_sta_par, id_sta_arr);
     List<Tratta> tratte=  ferrovia.InserisciStazioneArrivo(id_sta_par, id_sta_arr);
          return tratte;
    }
    public Biglietto scegliTratta(Tratta tratta,int classe){
       Biglietto biglietto= pos.scegliTratta(tratta, classe);
        return biglietto;
    }
    public void ConfermaBiglietto(){
        pos.confermaBiglietto();
        
    }
         /**
     * **********************************
     * UC8 Gestisci Abbonamento* ***********************************
    
     */ 
  public void InserisciDatiAnagrafici(String nome,String cognome,String cf,Date data_n,char sesso){
      this.cliente_corrente=new Cliente(nome, cognome, cf, data_n, sesso);
  }
   public void InserisciStazioniAbbonamento(int id_staz_p,int id_staz_a){
       int distanza=0;
       ferrovia.getDistanza(id_staz_p, id_staz_a);
       pos.creaAbbonamento(id_staz_p, id_staz_a, distanza, cliente_corrente);
       
   } 
   
   public Abbonamento InserisciTipoAbbonamento(TipoAbbonamento tipoabbonamento){
     Abbonamento abbonamento;
       abbonamento=  pos.InserisciTipoAbbonamento(tipoabbonamento);
       return abbonamento;
   }
   public  List<TipoAbbonamento> getTipoAbbonamento(){
       return pos.getTipiabbonamento();
   } 
   public void ConfermaAbbonamento(){
       pos.confermaAbbonamento();
   }
   
   
         /**
     * **********************************
     * UC9 Gestisci Tessera* ***********************************
    
     */ 
   public void InserisciCliente(String nome,String cognome,String cf,Date data_n,char sesso){
       if(!isPresentCliente(cf)) {
           cliente_corrente=new Cliente(nome, cognome, cf, data_n, sesso);
           Date data_rilascio = new Date();
            Date data_scadenza=new Date();
           data_scadenza.setTime(data_rilascio.getTime()+(30*24*60*60*1000));
           tessera_corrente=new Tessera(data_rilascio, data_scadenza, cliente_corrente);
       }
   }
   
   
   public boolean isPresentCliente(String cf) {
       for (Cliente cliente :clienti_registrati)
           return cliente.getCf().equals(cf);
      return false;
   } 
   public void confermaTessera(){
       tessere_registrate.add(tessera_corrente);
   }
   
        /**
     * **********************************
     * UC10 Gestisci Acquisto con tessera* ***********************************
    
     */  
   
   public void InserisciTessera(Tessera tessera){
       if(tessera.verificaTessera())
       pos.InserisciTessera(tessera);
   }
   public void confermaBigliettoTessera(){
       pos.confermaBigliettoTessera();
     
   }
           /**
     * **********************************
     * UC10 Gestisci Acquisto con Promozione* ***********************************
    
     */  
   public List<Promozione> visualizzaPromozioni(){
       return pos.getPromozioni();
   }
   public double AssociaPromozione(Promozione promozione){
          return pos.associaPromozione(promozione);
   }
   
   public Biglietto ConfermaAcquistoPunti(double prezzo_scontato){
      return pos.ConfermaAcquistoPunti(prezzo_scontato);
   }

           
           
           }