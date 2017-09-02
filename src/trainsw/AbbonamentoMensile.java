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
public class AbbonamentoMensile extends TipoAbbonamento{

    public AbbonamentoMensile(String id_tipoAbbonamento, int durata, double prezzo) {
        super(id_tipoAbbonamento, durata, prezzo);
    }





   

  
    @Override
      public double calcolaPrezzo(double distanza){
      double  prezzo=(double)((distanza*0.5*getDurata()*2/3)+getPrezzo());
                return prezzo;
    }
}
