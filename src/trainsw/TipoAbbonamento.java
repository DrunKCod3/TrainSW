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
public class TipoAbbonamento {
    private int id_tipoAbbonamento;
    private float prezzo_b;

    public TipoAbbonamento(int id_tipoAbbonamento, float prezzo_b) {
        this.id_tipoAbbonamento = id_tipoAbbonamento;
        this.prezzo_b = prezzo_b;
    }

    public int getId_tipoAbbonamento() {
        return id_tipoAbbonamento;
    }

    public float getPrezzo_b() {
        return prezzo_b;
    }

    public void setId_tipoAbbonamento(int id_tipoAbbonamento) {
        this.id_tipoAbbonamento = id_tipoAbbonamento;
    }

    public void setPrezzo_b(float prezzo_b) {
        this.prezzo_b = prezzo_b;
    }
    
    
}
