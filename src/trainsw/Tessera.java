/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;

/**
 *
 * @author Andrea
 */
public class Tessera {
    private int id_tessera;
    private Date d_rilascio;
    private Date d_scadenza;
    private int punti;
    private Cliente cliente;

    @Override
    public String toString() {
        return "Tessera{" + "id_tessera=" + id_tessera + ", d_rilascio=" + d_rilascio + ", d_scadenza=" + d_scadenza + ", punti=" + punti + '}' + 
                 this.cliente.toString();
    }

    public Tessera(int id_tessera, Date d_rilascio, Date d_scadenza, int punti, Cliente cliente) {
        this.id_tessera = id_tessera;
        this.d_rilascio = d_rilascio;
        this.d_scadenza = d_scadenza;
        this.punti = punti;
        this.cliente = cliente;
    }


    
    public Tessera(int id_tessera, Cliente cliente) {
        this.id_tessera = id_tessera;
        this.cliente = cliente;
    }

    public Tessera(Date d_rilascio, Date d_scadenza, Cliente cliente) {
        this.d_rilascio = d_rilascio;
        this.d_scadenza = d_scadenza;
        this.punti =0;
        this.cliente = cliente;
    }
    
    public void CalcolaPunti(float prezzo){
        this.punti=(int) (prezzo*2);
    }
    
    public boolean verificaTessera(){
        if(d_scadenza.getTime()<System.currentTimeMillis())
            return true;
      return false;  
    }
    public void aggiornaSaldo(int punti){
        this.punti-=punti;
    }
    public int getPunti()
    {
        return punti; 
    }
    
}