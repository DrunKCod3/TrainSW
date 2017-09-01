package trainsw;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.hibernate.Session;

public class Percorso {

    private Integer staz_par;
    private Integer staz_arr;
    private Integer id_per;
    private Integer distanzaparziale = 0;
    private List<Fermata> fermate= new ArrayList<>();
    private List<Collegamento> collegamenti= new ArrayList<>();
    private List<Tratta> tratte= new ArrayList<>();
    private Tratta tratta;

  
    public Percorso() {
      
    }

    public Percorso(Integer id_per, Integer staz_par, Integer staz_arr) {
        this.staz_par = staz_par;
        this.staz_arr = staz_arr;
        this.id_per = id_per;
        
    }

    public List<Fermata> calcolaPercorso() {
        List<Fermata> fermate_temp = new ArrayList<>();
        List<Collegamento>collegamenti=new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int staz_succ=this.staz_par;
        for (Collegamento collegamento : this.collegamenti) {
         session.update(collegamento);
        
            if(collegamento.getStazione_a().getId_stazione()==staz_succ  && staz_succ != this.staz_arr){
               collegamenti.add(collegamento);
               Fermata fermata=new Fermata();
               fermata.setId_stazione(collegamento.getStazione_a().getId_stazione());
               fermata.setStazione(collegamento.getStazione_a());
               fermata.setDistanza_p(this.distanzaparziale);
               staz_succ=collegamento.getStazione_b().getId_stazione();
            
               calcolaDistanzaParziale(collegamento.getDistanza());
               fermata.setPercorso(this);
               fermate_temp.add(fermata);
                
               }
            if(collegamento.getStazione_b().getId_stazione()==this.staz_arr ) {
                Fermata fermata=new Fermata();
               fermata.setId_stazione(collegamento.getStazione_b().getId_stazione());
               fermata.setStazione(collegamento.getStazione_b());
               fermata.setDistanza_p(this.distanzaparziale);
               fermata.setPercorso(this);
               calcolaDistanzaParziale(collegamento.getDistanza());
               fermate_temp.add(fermata);
             }
        }
        this.collegamenti=collegamenti;
        session.close();
        return fermate_temp;
    }

    public void calcolaDistanzaParziale(Integer distanza) {
        this.distanzaparziale = this.distanzaparziale + distanza;
    }

    public void addcollegamenti(Collegamento col) {
        collegamenti.add(col);
    }

    public void addFermate(Fermata fr) {
         
      
        this.fermate.add(fr);
      
    }

    public Integer getStaz_par() {
        return staz_par;
    }

    public void setStaz_par(Integer staz_par) {
        this.staz_par = staz_par;
    }

    public Integer getStaz_arr() {
        return staz_arr;
    }

    public void setStaz_arr(Integer staz_arr) {
        this.staz_arr = staz_arr;
    }

    public Integer getId_per() {
        return id_per;
    }

    public void setId_per(Integer id_per) {
        this.id_per = id_per;
    }

    public List<Fermata> getFermate() {
        return fermate;
    }

    public void setFermate(List<Fermata> fermate) {
        this.fermate = fermate;
    }

    public List<Collegamento> getCollegamenti() {
        return collegamenti;
    }

    public void setCollegamenti(List<Collegamento> collegamenti) {
        this.collegamenti = collegamenti;
    }

    public Integer getDistanzaparziale() {
        return distanzaparziale;
    }

    public void setDistanzaparziale(Integer distanzaparziale) {
        this.distanzaparziale = distanzaparziale;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public void createTratta() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
      
        session.update(this);
           Tratta tr = new Tratta();
        this.tratta = tr;
        this.tratta.setPercorso(this); 
        for (Fermata fermata : getFermate()) {
            tr.addFermata(fermata);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void ConfermaTratta() {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(this);
        getTratte().add(tratta);
        session.save(tratta);
        session.update(this);
        session.getTransaction().commit();
        session.close();

        
    }

    public List<FermataOrario> InserisciTreno(Treno tr) {
        tratta.inserisciTreno(tr);
        return tratta.calcolaOrari();

    }

    public void InserisciOrario(Date data) {
        tratta.setData_p(data);
        

    }

    public boolean RicercaFermata(int id_sta) {
          Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(this);
        for (Fermata fermata : getFermate()) {
          
            if (fermata.getStazione().getId_stazione() == id_sta) {
                  session.close();
                return true;
            }
        }
          session.close();
        return false;

    }

    public List<Tratta> RicercaTrattaOrario(int id_sta_par) {
        List<Tratta> tratte = new ArrayList<>();
            Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(this);
       
        for (Tratta tratta : getTratte()) {
          
            if (tratta.ricercaFermata(id_sta_par)) {
                tratte.add(tratta);
            }
        }
         System.out.println("sono la tratta aggiunta"+tratte.get(0).getId_tra());
        session.close();
        return tratte;
    }

    public int DistanzaFermate(int id_sta_par,int id_sta_arrivo){
    int distanza = 0;
        if (RicercaFermata(id_sta_par) && RicercaFermata(id_sta_arrivo)) {
            distanza = getDistanzaFermata(id_sta_arrivo) - getDistanzaFermata(id_sta_par);
        }
        return distanza;
    }

    public int getDistanzaFermata(int id_sta) {
          Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(this);
      
        for (Fermata fermata : getFermate()) {
            if (fermata.getStazione().getId_stazione() == id_sta) {
                  session.close();
                return fermata.getDistanza_p();
            }
        }
          session.close();
        return 0;

    }

}
