/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class FerroviaTest {
    Ferrovia ferrovia =new Ferrovia();
    public FerroviaTest() {
    }



    @Test
    public void testconfermaStazione_4args() {
                    
                  ferrovia.inserisciStazione(1, 2, "catania_centrale" ,"Catania");
                 
                  ferrovia.confermaStazione();
                  ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
                  ferrovia.confermaStazione();
            Stazione   st=ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
              assertNull("la ferrovia è gia presente nell'archivio ",st);
              ferrovia.confermaStazione();
           
  
               
    }
    @Test
    public void testisPresent(){
        List<Stazione> stazioni=ferrovia.getStazioni();
    Stazione stazione=  new Stazione(1, 2,"catania_centrale", "Catania");
     Stazione stazione1=    new Stazione(2, 2, "catania_centrale", "messina");
     Stazione stazione2=   new Stazione(3, 2 , "catania_centrale","palermo");
        stazioni.add(stazione);
        stazioni.add(stazione1);
        stazioni.add(stazione2);
        assertEquals("la stazione non è presente",true,ferrovia.isPresent(1,"catania"));
        assertFalse("la stazione è presente", ferrovia.isPresent(20,"genova"));
    }
     @Test
   public void testInserisciCollegamento(){
        List<Stazione> stazioni=ferrovia.getStazioni();
       Stazione stazione=new Stazione(1, 2,"cat", "catania");
        Stazione stazione1=new Stazione(2, 2,"pip", "messina");
       Stazione stazione2=new Stazione(3, 2,"par", "palermo");
        stazioni.add(stazione);
       stazioni.add(stazione1);
        stazioni.add(stazione2);
        Collegamento collegamento=ferrovia.InserisciCollegamento(1,"catania" , "messina", 20);
        assertNotNull("inserimento non riuscito",collegamento);
        collegamento=ferrovia.InserisciCollegamento(1, "catania","genova", 20);
        assertNull("inserimento riuscito",collegamento);
                
   }
   public void testFindPercorso(){
       Percorso pr=new Percorso(1, "catania", "messina");
       Percorso pr1=new Percorso(2,"catania","messina");
       Percorso pr2=new Percorso(3,"catania","palermo");
       List<Percorso> percorsi=ferrovia.getPercorsi();
       percorsi.add(pr);
       percorsi.add(pr1);
       percorsi.add(pr2);
       assertEquals("il valore non è corretto",2,ferrovia.findPercorso("catania" ,"messina").size());
        assertEquals("il valore non è corretto",1,ferrovia.findPercorso("catania" ,"palermo").size());
        assertEquals("il valore non è corretto",0,ferrovia.findPercorso("roma" ,"palermo").size()); 
   }
}
