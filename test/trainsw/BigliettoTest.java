/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class BigliettoTest {
    
    public BigliettoTest() {
    }

    @Test
    public void Testcalcolabiglietto() {
        Biglietto biglietto= new Biglietto();
        Treno tr = new Treno(2, new TipoTreno(2, "treno notte", (short) 23, (short) 23, (short) 23, 23, 15, 16));
        biglietto.setStaz_par("catania");
        biglietto.setStaz_arr("messina");
        Tratta tratta=new  Tratta();
        tratta.setTreno(tr);
       tratta.addFermata(new Fermata(1, 0,1,new Stazione(1, 2,"catania_centrale", "catania")));
        tratta.addFermata(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        tratta.addFermata(new Fermata(3, 49,3,new Stazione(3, 2, "catania_centrale", "palermo")));
        biglietto.calcolaBiglietto(tratta, 1);
        double prezzo=30*0.5+15;
        assertEquals("i prezzi sono differenti",prezzo, biglietto.getPrezzo(),0.1);
        biglietto.setStaz_arr("palermo");
        prezzo=49*0.5+15;
        biglietto.calcolaBiglietto(tratta, 1);
        assertEquals("i prezzi sono differenti",prezzo, biglietto.getPrezzo(),0.1);
        biglietto.calcolaBiglietto(tratta, 2);
        prezzo=49*0.5+16;
        assertEquals("i prezzi sono differenti",prezzo, biglietto.getPrezzo(),0.1);
        biglietto.setStaz_par("messina");
        biglietto.calcolaBiglietto(tratta, 2);
           prezzo=19*0.5+16;
         assertEquals("i prezzi sono differenti",prezzo, biglietto.getPrezzo(),0.1);
    }
    
}
