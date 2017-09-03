/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Andrea
 */
public class FermataOrario {
    private int id;
    private Date orario;
    private int id_fermata;
    private int id_tratta;
    private Tratta tratta;
    private Fermata fermata; 
    private int np_1c;
    private int np_2c;
    public FermataOrario() {

    }

    public FermataOrario(int id, Date orario, Fermata fermata) {
        this.id = id;
        this.orario = orario;
        this.fermata = fermata;
    }

    public FermataOrario(int id, Date orario, Fermata fermata, int np_1c,int np_2c) {
        this.id = id;
        this.orario = orario;
        this.fermata = fermata;
        this.np_1c = np_1c;
        this.np_2c = np_2c;
    }

    public Date getOrario() {
        return orario;
    }

    public void setOrario(Date orario) {
        this.orario = orario;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Fermata getFermata() {
        return fermata;
    }

    public void setFermata(Fermata Fermata) {
        this.fermata = Fermata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fermata() {
        return id_fermata;
    }

    public void setId_fermata(int id_fermata) {
        this.id_fermata = id_fermata;
    }

    public int getId_tratta() {
        return id_tratta;
    }

    public void setId_tratta(int id_tratta) {
        this.id_tratta = id_tratta;
    }
    public int getDistanzaParziale(){
       return  fermata.getDistanza_p();
    }

    public int getNp_1c() {
        return np_1c;
    }

    public void setNp_1c(int np_1c) {
        this.np_1c = np_1c;
    }

    public int getNp_2c() {
        return np_2c;
    }

    public void setNp_2c(int np_2c) {
        this.np_2c = np_2c;
    }
   public void aggiornaPosti(int classe){
     Session session= NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
     if(classe==1)
           if(np_1c>0)
               np_1c--;
       if(classe==2)
           if(np_2c>0)
               np_2c--;
       session.update(this);
       session.getTransaction().commit();
       session.close();
   }
   public boolean verificaPosti(){
       if((np_2c>0)||(np_1c>0)){
           
      
           return true;
       }
    return false;
   }

}
