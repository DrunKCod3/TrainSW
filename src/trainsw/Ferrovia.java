/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Andrea
 */
public class Ferrovia {

    private List<Stazione> stazioni;
    private List<Percorso> percorsi;
    private List<TipoTreno> tipoTreno;
    private List<Collegamento> collegamenti;
    private Stazione st;
    private Collegamento coll;
    private TipoTreno tt;
    private Percorso pr;

    public Ferrovia() {
        stazioni = new ArrayList<>();
        percorsi = new ArrayList<>();
        tipoTreno = new ArrayList<>();
        collegamenti = new ArrayList<>();
        caricaDati();
    }
private void caricaDati(){
    getStazioni();
    getCollegamenti();
    getPercorsi();
    getTipoTreno();
            
}
    public Stazione getSt() {
        return st;
    }

    public void setSt(Stazione st) {
        this.st = st;
    }

    public Collegamento getColl() {
        return coll;
    }

    public void setColl(Collegamento coll) {
        this.coll = coll;
    }

    public TipoTreno getTt() {
        return tt;
    }

    public void setTt(TipoTreno tt) {
        this.tt = tt;
    }

    public Percorso getPr() {
        return pr;
    }

    public void setPr(Percorso pr) {
        this.pr = pr;}

    public List<Stazione> getStazioni() {
         List<Stazione> stazioni=new ArrayList<>();
        Session session= new NewHibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();
        List<Stazione> result=session.createQuery("from Stazione").list();
        for(Stazione stazione: result)
            stazioni.add(stazione);
       this.stazioni=stazioni;
    
         session.getTransaction().commit();
       session.close();
        return stazioni;
    }

    public void setStazioni(List<Stazione> stazioni) {
        this.stazioni = stazioni;
    }

    public List<Percorso> getPercorsi() {
        List<Percorso> percorsi=new ArrayList<>();
     Session session= new NewHibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();
        List<Percorso> result=session.createQuery("from Percorso").list();
        for(Percorso pr: result)
            percorsi.add(pr);
        this.percorsi=percorsi;
          session.getTransaction().commit();
       session.close();
        return percorsi;
    }

    public void setPercorsi(List<Percorso> percorsi) {
        this.percorsi = percorsi;
    }

    public List<TipoTreno> getTipoTreno() {
        List<TipoTreno> tipoTreno=new ArrayList<>();
         Session session= new NewHibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();
        List<TipoTreno> result=session.createQuery("from TipoTreno").list();
        for(TipoTreno tp: result)
            tipoTreno.add(tp);
        this.tipoTreno=tipoTreno;
          session.getTransaction().commit();
       session.close();
        return tipoTreno;
    }

    public void setTipoTreno(List<TipoTreno> tipoTreno) {
        this.tipoTreno = tipoTreno;
    }

    public List<Collegamento> getCollegamenti() {
       List<Collegamento> collegamenti=new ArrayList<>();
       Session session= new NewHibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();
        List<Collegamento> result=session.createQuery("from Collegamento").list();
        for(Collegamento col: result)
            collegamenti.add(col);
        this.collegamenti=collegamenti;
          session.getTransaction().commit();
       session.close();
        return collegamenti;
    }

    public void setCollegamenti(List<Collegamento> collegamenti) {
        this.collegamenti = collegamenti;
    }

    /**
     * **********************************
     * UC1 Gestisci Stazione * ***********************************
     */
    public boolean isPresent(int id_staz) {
      List<Stazione> stazioni=getStazioni();
        for (Stazione staz : stazioni) {
            if (staz.getId_stazione() == id_staz) {
                return true;
            }
        }

        return false;
    }

    public Stazione inserisciStazione(int id_st, int num_bin, String locazione, String nome_st) {
         Stazione stazione= null;
        if (isPresent(id_st) == false) {
         stazione = new Stazione(id_st, num_bin, locazione, nome_st);
        }
        this.st=stazione;
        return stazione;
    }

    public void confermaStazione() {
      if(st!=null){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    //    stazioni.add(st);
        session.save(st);
        session.getTransaction().commit();
        session.close();
      }
    }

    /**
     * **********************************
     * UC3 Gestisci Deposito * ***********************************
     */
    public Deposito inserisciDeposito(int id_dep, int id_st, int num_posti) {
       List<Stazione> stazioni=getStazioni();
        for (Stazione staz : stazioni) {
            if (staz.getId_stazione() == id_st) {
                st = staz;
            }
        }

        return st.creaDeposito(id_dep, num_posti);

    }

    public void confermaDeposito(Deposito dep) {
        st.setDeposito(dep);
        st.addDeposito(dep);
    }

    /**
     * **********************************
     * UC3 Gestisci Collegamento * ***********************************
     */
    public Collegamento InserisciCollegamento(int id_collegamento, int id_staA, int id_staB, int distanza) {
        Stazione staA, staB;
        Collegamento col = null;
        staA = getStazione(id_staA);
        staB = getStazione(id_staB);
      if(staA !=null && staB != null)
        col = new Collegamento(id_collegamento, id_staA, id_staB, distanza, staA, staB);
        this.coll = col;
        return coll;
    }

    public void ConfermaCollegamento() {
        List<Collegamento> collegamenti=getCollegamenti();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        collegamenti.add(coll);
        session.save(coll);
        session.getTransaction().commit();
        session.close();
    }

    public Stazione getStazione(int id_sta) {
        Stazione st = null;
        List<Stazione> stazioni=getStazioni();
        for (Stazione staz : stazioni) {
            if (staz.getId_stazione() == id_sta) {
                st = staz;
            }
        }

        return st;
    }

    /**
     * **********************************
     * UC4 Gestisci Treno * ***********************************
     */
    public TipoTreno InserisciTipologiaTreno(int id_tt, String tt_name, short posti_letto, short np_2c, short np_1c, double velocita, double prezzo_prima, double prezzo_seconda) {
        TipoTreno tipo = null;
        if (isPresentTipo(id_tt) == false) {
            tipo = new TipoTreno(id_tt, tt_name, posti_letto, np_2c, np_1c, velocita, prezzo_prima, prezzo_seconda);
        }
        this.tt = tipo;
        return tipo;
    }

    public boolean isPresentTipo(int id_tt) {
      List<TipoTreno> tipoTreno=getTipoTreno();
        for (TipoTreno tipo : tipoTreno) {
            if (tipo.getId_tt() == id_tt) {
                return true;
            }
        }

        return false;
    }

    public void ConfermaTipologiaTreno() {
  List<TipoTreno> tipoTreno=getTipoTreno();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        tipoTreno.add(this.tt);
        session.save(this.tt);
        session.getTransaction().commit();
        session.close();
    }

    public Treno InserisciTreno(int id_tr) {
        return this.tt.InserisciTreno(id_tr);

    }

    public void InserisciNelDeposito(int id_st, Treno tr) {
        Stazione stazione;
        stazione = getStazione(id_st);
       
        stazione.InserisciNelDeposito(tr);
    }

    public void confermaTreno() {
        this.tt.confermaTreno();
    }

    /**
     * **********************************
     * UC5 Gestisci Percorso * ***********************************
     */
    public void creaPercorso() {
        Percorso percorso = new Percorso();
        pr = percorso;
    }

    public List<Fermata> InserisciStazione(int id_staA, int id_staB) {
        List<Collegamento> collegamenti=getCollegamenti();
   
        
        
        pr.setStaz_arr(id_staB);
        pr.setStaz_par(id_staA);
        
        for (Collegamento col : collegamenti) {
            pr.addcollegamenti(col);
        }
        
        List<Fermata> fermate= pr.calcolaPercorso();
        
        return fermate;
    }

    public void InserisciFermata(Fermata fr) {
        pr.addFermate(fr);
    }

    public void ConfermaPercorso() {
        percorsi.add(pr);
        Session session= NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pr);
        session.getTransaction().commit();
        session.close();
                
    }

    /**
     * **********************************
     * UC6 Gestisci Tratta * ***********************************
     */
    public List<Percorso> findPercorso(int idstaA, int idstaB) {
        List<Percorso> percorsi = new ArrayList();
        List<Percorso> per=getPercorsi();
        for (Percorso pr : per) {
            if (pr.getStaz_par() == idstaA && pr.getStaz_arr() == idstaB) {
                percorsi.add(pr);
            }
        }
        return percorsi;
    }

    public void InserisciPercorso(Percorso pr) {
        this.pr = pr;
        pr.createTratta();
    }

    public List<Treno> InserisciOrario(Date data) {
        pr.InserisciOrario(data);
        int id_sta = pr.getStaz_par();
           
        Stazione st = getStazione(id_sta);
        
        List<Treno> treni=st.getTrainList();
       
        return treni;
    }

    public List<FermataOrario> InserisciTreno(Treno tr) {
        return pr.InserisciTreno(tr);
    }

    public void ConfermaTratta() {
        pr.ConfermaTratta();
    }

    public List<Tratta> InserisciStazioneArrivo(int id_sta_par, int id_sta_arrivo) {
        List<Tratta> tratte = new ArrayList<>();
        List<Percorso> per=getPercorsi();
       
        for (Percorso pr : per) {
            System.out.println(pr.getId_per());
            if (pr.RicercaFermata(id_sta_par) && pr.RicercaFermata(id_sta_arrivo)) {
                tratte.addAll(pr.RicercaTrattaOrario(id_sta_par));
            }
        }
       
        return tratte;
    }

    public int getDistanza(int id_sta_par, int id_sta_arrivo) {
        int distanza = 0;
        List<Percorso> per=getPercorsi();
        for (Percorso pr : per) {
            if (pr.RicercaFermata(id_sta_par) && pr.RicercaFermata(id_sta_arrivo)) {
                distanza=pr.DistanzaFermate(id_sta_par, id_sta_arrivo);
               
               
            }
        }
       return distanza; 
    }
}
