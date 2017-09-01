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
                    
                  ferrovia.inserisciStazione(1, 2, "pippo","pippolandia");
                 
                  ferrovia.confermaStazione();
                  ferrovia.inserisciStazione(2, 2, "pippo","pippolandia");
                  ferrovia.confermaStazione();
            Stazione   st=ferrovia.inserisciStazione(1, 2, "pippo","pippolandia");
              assertNull("la ferrovia è gia presente nell'archivio ",st);
              ferrovia.confermaStazione();
           
  
               
    }
    @Test
    public void testisPresent(){
        List<Stazione> stazioni=ferrovia.getStazioni();
       Stazione stazione=new Stazione(1, 2, "pippo","pippolandia");
       Stazione stazione1=new Stazione(2, 2, "pippo","pippolandia");
       Stazione stazione2=new Stazione(3, 2, "pippo","pippolandia");
        stazioni.add(stazione);
        stazioni.add(stazione1);
        stazioni.add(stazione2);
        assertEquals("la stazione non è presente",true,ferrovia.isPresent(1));
        assertFalse("la stazione è presente", ferrovia.isPresent(20));
    }
     @Test
   public void testInserisciCollegamento(){
        List<Stazione> stazioni=ferrovia.getStazioni();
       Stazione stazione=new Stazione(1, 2, "pippo","pippolandia");
        Stazione stazione1=new Stazione(2, 2, "pippo","pippolandia");
       Stazione stazione2=new Stazione(3, 2, "pippo","pippolandia");
        stazioni.add(stazione);
       stazioni.add(stazione1);
        stazioni.add(stazione2);
        Collegamento collegamento=ferrovia.InserisciCollegamento(1, 1, 2, 20);
        assertNotNull("inserimento non riuscito",collegamento);
        collegamento=ferrovia.InserisciCollegamento(1, 4, 5, 20);
        assertNull("inserimento riuscito",collegamento);
                
   }
   
}
