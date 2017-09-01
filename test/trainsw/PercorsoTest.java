/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class PercorsoTest {

    public PercorsoTest() {
    }

    @Test
    public void testcalcolapercorso() {
        Percorso percorso = new Percorso(4, 5, 6);
        System.out.println(percorso.getStaz_arr() + " " + percorso.getStaz_par());
        Collegamento col = new Collegamento(3, 1, 2, 20, new Stazione(5, 2, "Catania", "catania_centrale"), new Stazione(6, 2, "pippo", "pippolandia"));
        Collegamento col2 = new Collegamento(4, 2, 3, 20, new Stazione(8, 2, "pippo", "pippolandia"), new Stazione(7, 2, "pippo", "pippolandia"));

        percorso.addcollegamenti(col);
        percorso.addcollegamenti(col2);
        List<Fermata> fermate = percorso.calcolaPercorso();
        for (Fermata fer : fermate) {
            percorso.addFermate(fer);
        }
       assertEquals("le stazioni non sono 2", 2, fermate.size());

    }
  @Test 
  public void testricercaFermata(){
        Percorso percorso = new Percorso(4, 1, 3);
        percorso.addFermate(new Fermata(1, 0, 1, new Stazione(1, 2, "pippo", "pippolandia")));
         percorso.addFermate(new Fermata(2, 0, 1, new Stazione(2, 2, "pippo", "pippolandia")));
          percorso.addFermate(new Fermata(3, 0, 1, new Stazione(3, 2, "pippo", "pippolandia")));
         assertTrue("la fermata non è stata trovata",  percorso.RicercaFermata(1));
         assertFalse("la fermata è stata trovata ",percorso.RicercaFermata(4));
  }
}
