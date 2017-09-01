/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Fermata {
    private int id_fer;
   private int id_per;
    private int distanza_p;
    private int id_stazione;
   private Stazione stazione;
   private Percorso percorso;
   
   
   
   public Fermata() {
    }

    public Fermata(int id_fer) {
        this.id_fer = id_fer;
    }

    public Fermata(int id_fer, int distanza_p) {
        this.id_fer = id_fer;
        this.distanza_p = distanza_p;
    }

    public Fermata(int id_fer, int distanza_p, int id_stazione, Stazione stazione) {
        this.id_fer = id_fer;
        this.distanza_p = distanza_p;
        this.id_stazione = id_stazione;
        this.stazione = stazione;
        
    }

    public int getId_fer() {
        return id_fer;
    }

    public void setId_fer(int id_fer) {
        this.id_fer = id_fer;
    }

 

    public int getDistanza_p() {
        return distanza_p;
    }

    public void setDistanza_p(int distanza_p) {
        this.distanza_p = distanza_p;
    }

    public Stazione getStazione() {
        return stazione;
    }

    public void setStazione(Stazione stazione) {
        this.stazione = stazione;
    }

    public int getId_stazione() {
        return id_stazione;
    }

    public void setId_stazione(int id_stazione) {
        this.id_stazione = id_stazione;
    }

    public Percorso getPercorso() {
        return percorso;
    }

    public void setPercorso(Percorso percorso) {
        this.percorso = percorso;
    }

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }

    
    
}
