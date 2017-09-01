/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

/**
 *
 * @author Andrea
 */
public class Stazione {

    private int id_stazione;
    private int num_bin;
    private String locazione;
    private String nome_stazione;
    private Deposito deposito;

    public Stazione() {
    }

    public Stazione(int id_stazione, int num_bin, String locazione, String nome_stazione) {
        super();
        this.id_stazione = id_stazione;
        this.num_bin = num_bin;
        this.locazione = locazione;
        this.nome_stazione = nome_stazione;

    }

    public int getId_stazione() {
        return id_stazione;
    }

    public void setId_stazione(int id_stazione) {
        this.id_stazione = id_stazione;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public int getNum_bin() {
        return num_bin;
    }

    public void setNum_bin(int num_bin) {
        this.num_bin = num_bin;
    }

    public String getLocazione() {
        return locazione;
    }

    public void setLocazione(String locazione) {
        this.locazione = locazione;
    }

    public String getNome_stazione() {
        return nome_stazione;
    }

    public void setNome_stazione(String nome_stazione) {
        this.nome_stazione = nome_stazione;
    }

    public Deposito creaDeposito(int id_dep, int num_posti) {

        Deposito deposito = new Deposito(id_dep, num_posti);
        deposito.setStazione(this);
        return deposito;
    }

    public void addDeposito(Deposito deposito) {
        Session session = null;
        this.deposito=deposito;
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(deposito);
        session.update(this);
        session.getTransaction().commit();
        session.close();

    }
  
    
    public void InserisciNelDeposito(Treno tr){
        List<Treno> treni=new ArrayList<>();
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Deposito> depositi= session.createQuery("from Deposito").list();
          for(Deposito dep: depositi)
            if(dep.getStazione().getId_stazione()==this.id_stazione)
                this.deposito=dep;
                
                deposito.addTrenoDeposito(tr);
        session.getTransaction().commit();
        session.close();
    }
    
    
    public List<Treno> getTrainList(){
        List<Treno> treni=new ArrayList<>();
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Deposito> depositi= session.createQuery("from Deposito").list();
          for(Deposito dep: depositi)
               if(dep.getStazione().getId_stazione()==this.id_stazione)
                  treni=dep.getTreni();  
        session.getTransaction().commit();
        session.close();
        return treni;
    }

    @Override
    public String toString() {
        return "Stazione{" + "id_stazione=" + id_stazione + ", num_bin=" + num_bin + ", locazione=" + locazione + ", nome_stazione=" + nome_stazione + ", deposito=" + deposito + '}';
    }
    

 
 
}
