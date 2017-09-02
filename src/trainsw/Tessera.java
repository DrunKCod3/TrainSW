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
        return "Tessera{" + "id_tessera=" + id_tessera +
                ", d_rilascio=" + d_rilascio +
                ", d_scadenza=" + d_scadenza +
                ", punti=" + punti + '}'  ;
                
                 
    }

    public int getId_tessera() {
        return id_tessera;
    }

    public void setId_tessera(int id_tessera) {
        this.id_tessera = id_tessera;
    }

    public Date getD_rilascio() {
        return d_rilascio;
    }

    public void setD_rilascio(Date d_rilascio) {
        this.d_rilascio = d_rilascio;
    }

    public Date getD_scadenza() {
        return d_scadenza;
    }

    public void setD_scadenza(Date d_scadenza) {
        this.d_scadenza = d_scadenza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        this.punti+=(int) ((prezzo/10)*4);
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
