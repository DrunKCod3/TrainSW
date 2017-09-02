/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;



/**
 *
 * @author Andrea
 */
public abstract class TipoAbbonamento {
    private String id_tipoAbbonamento;
    private int durata;
    private double prezzo;

    public TipoAbbonamento(String id_tipoAbbonamento) {
        this.id_tipoAbbonamento = id_tipoAbbonamento;
    }

    public TipoAbbonamento(String id_tipoAbbonamento, int durata, double prezzo) {
        this.id_tipoAbbonamento = id_tipoAbbonamento;
        this.durata = durata;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


 

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    

    
    
    
    
    
    public String getId_tipoAbbonamento() {
        return id_tipoAbbonamento;
    }

    public void setId_tipoAbbonamento(String id_tipoAbbonamento) {
        this.id_tipoAbbonamento = id_tipoAbbonamento;
    }

   

    
    public abstract double calcolaPrezzo(double distanza);


    
    
}
