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
        Percorso percorso = new Percorso(7, "catania", "messina");
        
        Collegamento col = new Collegamento(1, "catania","messina", 20,new  Stazione(1, 2, "catania_centrale" ,"catania"),new Stazione (2, 2, "catania_centrale", "messina"));
        Collegamento col2 = new Collegamento(2, "messina", "palermo", 20,new Stazione (2, 2, "catania_centrale", "messina"), new Stazione(2, 2, "catania_centrale", "palermo"));

        percorso.addcollegamenti(col);
        percorso.addcollegamenti(col2);
        List<Fermata> fermate = percorso.calcolaPercorso();
      
       assertEquals("le stazioni non sono 2", 2, fermate.size());

    }
     @Test 
    public void testaddFermata(){
         Percorso percorso = new Percorso(7, "roma", "venezia");
        percorso.addFermate(new Fermata(1, 0,1,new Stazione(1, 2, "Catania", "catania_centrale")));
        percorso.addFermate(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        percorso.addFermate(new Fermata(3, 49,3,new Stazione(3, 2, "catania_centrale", "palermo")));
        assertEquals("le stazioni non sono ", 3, percorso.getFermate().size());
         percorso.addFermate(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        assertEquals(3,percorso.getFermate().size() );
    }
  @Test 
  public void testricercaFermata(){
        Percorso percorso = new Percorso(4, "catania","palermo");
        percorso.addFermate(new Fermata(1, 49,3,new Stazione(1, 2, "catania_centrale","catania")));

        percorso.addFermate(new Fermata(2, 49,3,new Stazione(2, 2, "catania_centrale", "messina")));
          percorso.addFermate(new Fermata(3, 49,3,new Stazione(3, 2,"catania_centrale","palermo")));
         assertTrue("la fermata non è stata trovata",  percorso.RicercaFermata("catania"));
         assertFalse("la fermata è stata trovata ",percorso.RicercaFermata("genova"));
  }
}
