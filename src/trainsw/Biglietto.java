package trainsw;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class Biglietto {

    private int id_b;
    private double prezzo;
    private int distanza;
    private String staz_par;
    private String staz_arr;
    private Tratta tratta;
    private int classe;
    public Biglietto() {
    }

    @Override
    public String toString() {
        return "Biglietto{" + "id_b=" + id_b + ", prezzo=" + prezzo + ", distanza=" + distanza + ", staz_par=" + staz_par + ", staz_arr=" + staz_arr+" id Tratta=" + tratta.getId_tra()+" Treno= "+tratta.getTreno().getTt()+" Classe= "+classe+'}';
    }

    public Biglietto(Tratta tratta) {
        this.tratta = tratta;
    }

    public Biglietto(int id_b, String staz_par, String staz_arr) {
        this.id_b = id_b;
        this.staz_par = staz_par;
        this.staz_arr = staz_arr;
    }
    
    

    public Biglietto(String staz_par, String staz_arr) {

        this.staz_par = staz_par;
        this.staz_arr = staz_arr;
    }

    public int getId_b() {
        return id_b;
    }

    public void setId_b(int id_b) {
        this.id_b = id_b;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDistanza() {
        return distanza;
    }

    public void setDistanza(int distanza) {
        this.distanza = distanza;
    }

    public String getStaz_par() {
        return staz_par;
    }

    public void setStaz_par(String staz_par) {
        this.staz_par = staz_par;
    }

    public String getStaz_arr() {
        return staz_arr;
    }

    public void setStaz_arr(String staz_arr) {
        this.staz_arr = staz_arr;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public void calcolaBiglietto(Tratta tr,int classe){
        tratta=tr;
        this.distanza=tr.getDistanza(staz_arr)-tr.getDistanza(staz_par);
        this.classe=classe;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(tr);
    
        prezzo=distanza*0.5;
        if(classe==1)
        prezzo+= tratta.getTreno().getTt().getPrezzo_prima();
        else    
        prezzo+=tratta.getTreno().getTt().getPrezzo_seconda();
        
        session.close();
    }
    public void AggiornaPosti(){
        tratta.AggiornaPosti(staz_par, staz_arr, classe);
    }
}
