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
        Percorso percorso = new Percorso(7, "Trumpitello", "Acireale");
        
        Collegamento col = new Collegamento(1, "Trumpitello","Mascali", 20,new  Stazione(1, 6, "via Giulio", "Trumpitello"),new Stazione (2, 6, "via Cesare", "Mascali"));
        Collegamento col2 = new Collegamento(2, "Mascali", "Acireale", 20,new Stazione (2, 6, "via Cesare", "Mascali"),new Stazione (4, 6, "via Treppello", "Acireale"));

        percorso.addcollegamenti(col);
        percorso.addcollegamenti(col2);
        List<Fermata> fermate = percorso.calcolaPercorso();
        assertEquals(2, percorso.getCollegamenti().size());
       assertEquals("le stazioni non sono 2", 2, fermate.size());

    }
     @Test 
    public void testaddFermata(){
         Percorso percorso = new Percorso(7, "catania_centrale", "palermo");
        percorso.addFermate(new Fermata(18, 0,1,new  Stazione(1, 6, "via Giulio", "Trumpitello")));
        percorso.addFermate(new Fermata(19, 30,2,new Stazione(2, 6, "via Cesare", "Mascali")));
        percorso.addFermate(new Fermata(20, 49,3,new Stazione(4, 6, "via Treppello", "Acireale")));
        assertEquals("le stazioni non sono ", 3, percorso.getFermate().size());
         percorso.addFermate(new Fermata(21, 30,2,new  Stazione(1, 6, "via Giulio", "Trumpitello")));
        assertEquals(3,percorso.getFermate().size() );
    }
  @Test 
  public void testricercaFermata(){
        Percorso percorso = new Percorso(4, "Trumpitello","palermo");
        percorso.addFermate(new Fermata(1, 49,3,new Stazione(1, 6, "via Giulio", "Trumpitello")));

        percorso.addFermate(new Fermata(2, 49,3,new Stazione(2, 6, "via Cesare", "Mascali")));
          percorso.addFermate(new Fermata(3, 49,3,new Stazione(3, 6, "via Augusto", "Giarre")));
         assertTrue("la fermata non è stata trovata",  percorso.RicercaFermata("Trumpitello"));
         assertFalse("la fermata è stata trovata ",percorso.RicercaFermata("genova"));
  }
}
