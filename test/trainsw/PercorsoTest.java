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
        Percorso percorso = new Percorso(7, "roma", "venezia");
        
        Collegamento col = new Collegamento(3, "genova","milano", 20, new Stazione(5, 2,"catania_centrale","catania" ), new Stazione(6, 2,"pia","milano"));
        Collegamento col2 = new Collegamento(4, "roma", "venezia", 20, new Stazione(8, 2, "ndia","roma" ), new Stazione(7, 2, "landia", "venezia"));

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
        Percorso percorso = new Percorso(4, "catania","palermo");
        percorso.addFermate(new Fermata(3, 49,3,new Stazione(1, 2, "catania_centrale", "catania")));
         percorso.addFermate(new Fermata(3, 49,3,new Stazione(2, 2, "catania_centrale", "messina")));
          percorso.addFermate(new Fermata(3, 49,3,new Stazione(3, 2,  "catania_centrale","palermo")));
         assertTrue("la fermata non è stata trovata",  percorso.RicercaFermata("catania"));
         assertFalse("la fermata è stata trovata ",percorso.RicercaFermata("genova"));
  }
}
