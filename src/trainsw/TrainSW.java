    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.ArrayList;
import java.util.Calendar;
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
  private Cliente cliente_corrente = new Cliente();
  private List<Cliente> clienti_registrati = new ArrayList<Cliente>();
  private List<Tessera> tessere_registrate = new ArrayList<Tessera>();
  private Tessera tessera_corrente;
  private static TrainSW singleton;
  private Promozione promozione;
  private TipoAbbonamento tipoabbonamento;
       
  
  
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

    public POS getPos() {
        return pos;
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
     public Deposito inserisciDeposito(int id_dep,String id_staz,int num_posti){
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
     
     public Collegamento inserisciCollegamento(int id_collegamento,String id_staA,String id_staB,int distanza){
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
     public void InserisciNelDeposito(String id_st,Treno tr){
         ferrovia.InserisciNelDeposito(id_st, tr);
     }
       /**
     * **********************************
     * UC5 Gestisci Percorso * ***********************************
     */ 
     public void GestisciPercorso(){
         ferrovia.creaPercorso();
     }
    public List<Fermata> InserisciStazioni(String id_staA,String id_staB){
       
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
    public List<Percorso> InserisciPartenzaArrivo(String idstaA,String idstaB){
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
    public List<Tratta> inserisciStazioneArrivo(String id_sta_par,String id_sta_arr){
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
      Cliente cliente = new Cliente(nome,cognome,cf,data_n,sesso);
      this.cliente_corrente = cliente;
//  this.cliente_corrente=new Cliente(nome, cognome, cf, data_n, sesso);
  }
   public void InserisciStazioniAbbonamento(String id_staz_p,String id_staz_a){
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
   public Abbonamento ConfermaAbbonamento(){
       pos.confermaAbbonamento();
       return(pos.getAbbonamento_corrente());
   }
     
         /**
     * **********************************
     * UC9 Gestisci Tessera* 
     ***********************************
    
     */ 
   
   
   
   public Tessera InserisciCliente(String nome,String cognome,String cf,Date data_n,char sesso){
       if(!isPresentCliente(cf)) {
           Date data_rilascio = new Date() ;
            Date data_scadenza=new Date();
           
           cliente_corrente=new Cliente(nome, cognome, cf, data_n, sesso);
           
            
           Calendar cal = Calendar.getInstance();
            data_rilascio = cal.getTime();
            cal.add(Calendar.YEAR, 1); // to get previous year add -1
            data_scadenza = cal.getTime();
          
           tessera_corrente=new Tessera(tessere_registrate.size() + 1, data_rilascio, data_scadenza, 0, cliente_corrente);
           return tessera_corrente;
       }
       return null;
   }
   
   
   public boolean isPresentCliente(String cf) {
       for (Cliente cliente :clienti_registrati)
           return cliente.getCf().equals(cf);
      return false;
   } 
   public void confermaTessera(){
       tessere_registrate.add(tessera_corrente);
   }
   
   public void addTessera(Tessera t) {
       tessere_registrate.add(t);
   }
        /**
     * **********************************
     * UC10 Gestisci Acquisto con tessera* 
      ***********************************
    
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

    public List<Tessera> getTessere_registrate() {
        return tessere_registrate;
    }

    public void setTessere_registrate(List<Tessera> tessere_registrate) {
        this.tessere_registrate = tessere_registrate;
    }

    public Tessera getTessera_corrente() {
        return tessera_corrente;
    }

    public void setTessera_corrente(Tessera tessera_corrente) {
        this.tessera_corrente = tessera_corrente;
    }
   
   
 
}
