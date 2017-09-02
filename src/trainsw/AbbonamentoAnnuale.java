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
public class AbbonamentoAnnuale extends TipoAbbonamento{

    public AbbonamentoAnnuale(String id_tipoAbbonamento, int durata, double prezzo) {
        super(id_tipoAbbonamento, durata, prezzo);
    }

 


   

 
     @Override
      public double calcolaPrezzo(double distanza){
      double  prezzo=(double)((distanza*0.5*getDurata()*2/5)+getPrezzo());
                return prezzo;
    }
}
