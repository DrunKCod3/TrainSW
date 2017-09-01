/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class POS {
   
    private Biglietto biglietto_corrente;
    private Abbonamento abbonamento_corrente;
    private List<Promozione> promozioni=new ArrayList<>();
    private List<TipoAbbonamento> tipiabbonamento=new ArrayList<>();
    private Tessera tessera_corrente;
    private List<Biglietto> biglietti_venduti=new ArrayList<>();
    private List<Abbonamento> abbonamenti_venduti=new ArrayList<>();
    private PromoStandard pstandard;
    private PromoSoglia psoglia;
    private AllInclusivePromo pallinclusive;
    private int punti;

    public POS() {
    }

    public Biglietto getBiglietto_corrente() {
        return biglietto_corrente;
    }

    public void setBiglietto_corrente(Biglietto biglietto_corrente) {
        this.biglietto_corrente = biglietto_corrente;
    }

    public Abbonamento getAbbonamento_corrente() {
        return abbonamento_corrente;
    }

    public void setAbbonamento_corrente(Abbonamento abbonamento_corrente) {
        this.abbonamento_corrente = abbonamento_corrente;
    }

    public List<Promozione> getPromozioni() {
        return promozioni;
    }

    public void setPromozioni(List<Promozione> promozioni) {
        this.promozioni = promozioni;
    }

    public List<TipoAbbonamento> getTipiabbonamento() {
        return tipiabbonamento;
    }

    public void setTipiabbonamento(List<TipoAbbonamento> tipiabbonamento) {
        this.tipiabbonamento = tipiabbonamento;
    }

    public Tessera getTessera_corrente() {
        return tessera_corrente;
    }

    public void setTessera_corrente(Tessera tessera_corrente) {
        this.tessera_corrente = tessera_corrente;
    }

    public List<Biglietto> getBiglietti_venduti() {
        return biglietti_venduti;
    }

    public void setBiglietti_venduti(List<Biglietto> biglietti_venduti) {
        this.biglietti_venduti = biglietti_venduti;
    }

    
    
   public void confermaAbbonamento(){
       abbonamenti_venduti.add(abbonamento_corrente);
   }

    public void confermaBiglietto(){
        biglietti_venduti.add(biglietto_corrente);
        
    }
    public void calcolaPunti(float prezzo){
        
    }
    public void creaAbbonamento(int id_staz_p,int id_staz_a,Cliente cliente){
        
    }
    public void calcolaPromozione(float prezzo){
        
    }
    public  void inserisciStazioneArrivo(int id_sta_par,int id_sta_arr){
    biglietto_corrente.setStaz_arr(id_sta_arr);
    biglietto_corrente.setStaz_par(id_sta_par);
   
  
    }
    public void creaBiglietto(){
        biglietto_corrente=new Biglietto();
    }    
    public Biglietto scegliTratta(Tratta tr,int classe){
        biglietto_corrente.calcolaBiglietto(tr, classe);
        return biglietto_corrente;
    }
    
    public void creaAbbonamento(Integer staz_p, Integer staz_a, double distanza, Cliente cliente){
        abbonamento_corrente=new Abbonamento(staz_p, staz_a, distanza, cliente);
    }
    public Abbonamento InserisciTipoAbbonamento(TipoAbbonamento tipo){
        abbonamento_corrente.setTipo(tipo);
        abbonamento_corrente.calcolaPrezzo();
        return abbonamento_corrente;
    
    }
    public void  InserisciTessera(Tessera tessera){
        this.tessera_corrente=tessera;
        
    }
    public Tessera confermaBigliettoTessera(){
        this.tessera_corrente.CalcolaPunti((float) biglietto_corrente.getPrezzo());
        biglietti_venduti.add(biglietto_corrente);
        return this.tessera_corrente;
    }
  public double associaPromozione(Promozione promozione){
      /*Promozione pro = new AllInclusivePromo("AllInclusive",promozione.getPunti());
      for (int i=0; i <pro.size(); )
		pro.add(PromoStandard);
		pro.add(PromoSoglia);
		*/
      
   //   pstandard = new PromoStandard("Standard", tessera_corrente.getPunti());
    //  psoglia = new PromoSoglia("Soglia", tessera_corrente.getPunti());
      double prezzo_scontato=biglietto_corrente.getPrezzo();
      switch(promozione.nome){
          case "PromoSoglia":
              prezzo_scontato=psoglia.calcolaPromozione(prezzo_scontato,tessera_corrente.getPunti());
              this.punti = 100;  
          case "PromoStandard":
              prezzo_scontato=pstandard.calcolaPromozione(prezzo_scontato,tessera_corrente.getPunti());
              this.punti = 250;  
          case "AllInclusivePromo":
              prezzo_scontato=pallinclusive.calcolaPromozione(prezzo_scontato,tessera_corrente.getPunti());
              this.punti = 350;  
          default:
              JOptionPane.showMessageDialog(new JFrame(), "Errore elenco promozioni");
      }  
      return prezzo_scontato;
  }
 public Biglietto ConfermaAcquistoPunti(double prezzo_scontato){
     int punti;
     biglietto_corrente.setPrezzo(prezzo_scontato);
     //punti=promozione_corrente.getPunti();
     tessera_corrente.aggiornaSaldo(this.punti);
     biglietti_venduti.add(biglietto_corrente);
     return biglietto_corrente;
             
     
 }
}
