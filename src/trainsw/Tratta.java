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
public class Tratta {

    private int id_tratta;
    private int id_per;
    private Date data_p;
    private Date data_a;
    private List<FermataOrario> fermate;
    private Treno treno;
    private Percorso percorso;

    public Tratta() {
    fermate = new ArrayList<FermataOrario>();

    }


    public void addFermata(Fermata fermata) {
            
             FermataOrario fr =new FermataOrario();
               fr.setFermata(fermata);
                fr.setTratta(this);
                fermate.add(fr);
          
    }


    public int getDistanza(int id_sta){
        int distanza=0;
          Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(this);
        for(FermataOrario fermata : getFermate()){
            if(fermata.getFermata().getId_fer()==id_sta)
                distanza=fermata.getDistanzaParziale();
        }
        session.getTransaction().commit();
        session.close();
        return distanza;
    } 
    public int getId_tra() {
        return id_tratta;
    }

    public void setId_tra(int id_tra) {
        this.id_tratta = id_tra;
    }

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }

    public Date getData_p() {
        return data_p;
    }

    public void setData_p(Date data_p) {
        this.data_p = data_p;
    }

    public Date getData_a() {
        return data_a;
    }

    public void setData_a(Date data_a) {
        this.data_a = data_a;
    }

    public List<FermataOrario> getFermate() {
      return fermate;
    }

    public void setFermate(List<FermataOrario> fermate) {
        this.fermate = fermate;
    }

    public Treno getTreno() {
        return treno;
    }

    public void setTreno(Treno treno) {
        this.treno = treno;
    }

    public Percorso getPercorso() {
        return percorso;
    }

    public void setPercorso(Percorso percorso) {
        this.percorso = percorso;
    }

    public int getId_tratta() {
        return id_tratta;
    }

    public void setId_tratta(int id_tratta) {
        this.id_tratta = id_tratta;
    }

    public void inserisciTreno(Treno tr) {
    this.treno=tr;
      
    }

    public List<FermataOrario> calcolaOrari() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
      session.update(treno);
        double velocita = treno.getTt().getVelocita();
      session.close();
        long orario=0;
        for (FermataOrario fermata : getFermate()) {
          
            orario =this.getData_p().getTime()+(long) ((fermata.getDistanzaParziale() / velocita) * 3600 * 1000);
             System.out.println(velocita +"   " +(long) ((fermata.getDistanzaParziale() / velocita) * 3600 * 1000) );
            Date data_arrivo = new Date();
            data_arrivo.setTime(orario);
        
            fermata.setOrario(data_arrivo);
            
        }
        this.data_a=new Date();
        this.data_a.setTime(orario);
     
      
        return this.fermate;
       
    }

    public boolean ricercaFermata(int id_sta_a) {
 
            for (FermataOrario fermata : getFermate()) {
                
                if (fermata.getFermata().getStazione().getId_stazione() == id_sta_a && fermata.getOrario().getTime() > System.currentTimeMillis()) {
              
                    return true;
                }
            }
 ;
        return false;
    }

    public boolean isPresent(int id_sta) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(this);
        for (FermataOrario fermata : getFermate()) {
            if (fermata.getFermata().getId_fer() == id_sta) {
                session.close();
                return true;
            }
        }
      session.close();
        return false;
    }
}
