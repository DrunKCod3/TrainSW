/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class TrattaTest {

    @Test
    public void testCalcolaOrari() {
        Tratta tratta = new Tratta();
        Treno tr = new Treno(2, new TipoTreno(2, "treno notte", (short) 23, (short) 23, (short) 23, 23, 15, 16));
        Date partenza = new Date();
        tratta.setData_p(partenza);
        tratta.setTreno(tr);

        tratta.addFermata(new Fermata(1, 0));
        tratta.addFermata(new Fermata(2, 30));
        tratta.addFermata(new Fermata(3, 49));

        List<FermataOrario> fermate = tratta.calcolaOrari();

        assertEquals(3, fermate.size());
        long orario = partenza.getTime();
        FermataOrario fermata = fermate.get(0);
        Date prova = new Date();
  //      assertEquals(prova, fermata.getOrario());
        fermata = fermate.get(1);
        orario = partenza.getTime() + (long) ((30 / (float)23) * 3600 * 1000);
        prova.setTime(orario);
        assertEquals(prova, fermata.getOrario());
        fermata = fermate.get(2);

        orario = partenza.getTime() + (long) ((49 /(float) 23) * 3600 * 1000);
        prova.setTime(orario);
        assertEquals(prova, fermata.getOrario());
    }
 @Test
    public void testricercaFermata(){
        Tratta tratta=new Tratta();
        tratta.addFermata(new Fermata(1, 0,1,new Stazione(1, 2, "Catania", "catania_centrale")));
        tratta.addFermata(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        tratta.addFermata(new Fermata(3, 49,3,new Stazione(3, 2, "catania_centrale", "palermo")));
       DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ITALIAN);
      Date data4=null;
        try {
        Date data1 = format.parse("Maggio 2, 2017");
        Date data2 = format.parse("Maggio 3, 2017");
        Date data3 = format.parse("Maggio 4, 2017");
        data4 = format.parse("Maggio 4, 2018");
        tratta.getFermate().get(0).setOrario(data1);
        tratta.getFermate().get(1).setOrario(data2);
        tratta.getFermate().get(2).setOrario(data3);
        } catch (ParseException ex) {
          
        }
       assertFalse("è stata trovata una fermata anche se l'orario è passato", tratta.ricercaFermata("catania"));
       tratta.addFermata(new Fermata(3, 49,4,new Stazione(4, 2,  "catania_centrale","enna")));
        tratta.getFermate().get(3).setOrario(data4);
        
       assertTrue("non è stata trovata una fermata",tratta.ricercaFermata("enna")); 
    }
     @Test
    public void testgetDistanza(){
           Tratta tratta=new  Tratta();
       
       tratta.addFermata(new Fermata(1, 0,1,new Stazione(1, 2,"catania_centrale", "catania")));
        tratta.addFermata(new Fermata(2, 30,2,new Stazione(2, 2, "catania_centrale", "messina")));
        tratta.addFermata(new Fermata(3, 49,3,new Stazione(3, 2, "catania_centrale", "palermo")));
        assertEquals("la distanzaa è sbagliata", 49,tratta.getDistanza("palermo"));
    }
}
