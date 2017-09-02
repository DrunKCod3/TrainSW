/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class POSTest {
    POS pos=new POS();
    public POSTest() {
    }

    @Test
    public void testassociaPromozione() {
      Promozione p=new PromoStandard("PromozioneStandard",20 , 0.05);
      
      
        Treno tr = new Treno(2, new TipoTreno(2, "treno notte", (short) 23, (short) 23, (short) 23, 23, 15, 30));
       pos.creaBiglietto();
       pos.inserisciStazioneArrivo("catania", "messina");
        Tessera tessera=new Tessera(1,new Date(), new Date(), 100, new Cliente("Marco", "Antonio","sdkjughlaksch",new Date(), 'm'));
        Tratta tratta=new  Tratta();
        tratta.setTreno(tr);
       tratta.addFermata(new Fermata(1, 0,1,new Stazione(1, 2,"catania_centrale", "catania")));
        tratta.addFermata(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        tratta.addFermata(new Fermata(3, 49,3,new Stazione(3, 2, "catania_centrale", "palermo")));
        pos.scegliTratta(tratta, 1);
        pos.InserisciTessera(tessera);
        
       assertEquals("il prezzo è diverso",28.5, pos.associaPromozione(p),0.1);
       pos.scegliTratta(tratta, 2);
       assertEquals("il prezzo è diverso",42.75, pos.associaPromozione(p),0.1);
       pos.inserisciStazioneArrivo("catania", "palermo");
       pos.scegliTratta(tratta, 1);
       assertEquals("il prezzo è diverso",37.52, pos.associaPromozione(p),0.1);
    }
    
}
