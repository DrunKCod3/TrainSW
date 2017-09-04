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
    public void testconfermaStazione() {
                    
                     ferrovia.inserisciStazione(1, 6, "via Giulio", "Trumpitello");
            ferrovia.confermaStazione();
           ferrovia.inserisciStazione(2, 6, "via Cesare", "Mascali");
            ferrovia.confermaStazione();
  
      Stazione  st=     ferrovia.inserisciStazione(2, 6, "via Cesare", "Mascali");
              assertNull("la ferrovia è gia presente nell'archivio ",st);
              ferrovia.confermaStazione();
           
  
               
    }
  
   
     @Test 
       public void testInserisciTipoTreno(){
        ferrovia.InserisciTipologiaTreno(1, "freccia rossa",(short) 1,(short) 1, (short)1, 1, 2, 3);
        ferrovia.ConfermaTipologiaTreno();
       TipoTreno tipo=  ferrovia.InserisciTipologiaTreno(1, "freccia rossa",(short) 1,(short) 1, (short)1, 1, 2, 3);
        assertNull("la tipologia è stata inserita",tipo);
       }
     @Test 
       public void testInserisciPercorso(){
        ferrovia.inserisciStazione(1, 6, "via Giulio", "Trumpitello");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(2, 6, "via Cesare", "Mascali");
     ferrovia.confermaStazione();
     ferrovia.inserisciStazione(3, 6, "via Augusto", "Giarre");
     ferrovia.confermaStazione();
      
      ferrovia.InserisciCollegamento(1, "Trumpitello", "Mascali", 9 );
      ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(2, "Mascali", "Giarre", 14);
       ferrovia.ConfermaCollegamento();
     ferrovia.InserisciCollegamento(3, "Giarre", "Acireale", 23);
      ferrovia.ConfermaCollegamento();
       
       Deposito dep= ferrovia.inserisciDeposito(1, "Trumpitello", 20);
       ferrovia.confermaDeposito(dep);
        ferrovia.creaPercorso();
       List<Fermata>fermata= ferrovia.InserisciStazione("Trumpitello", "Mascali");
       assertEquals("le fermate non sono ",2,fermata.size());
       fermata= ferrovia.InserisciStazione("Mascali", "Giarre");
         assertNull("la stazione non è deposito ",fermata);
       fermata= ferrovia.InserisciStazione("catania", "genova");
       assertNull("le fermate non sono ",fermata);

     }
     
     @Test
   public void testInserisciCollegamento(){
      
     ferrovia.InserisciCollegamento(1, "Trumpitello", "Mascali", 9 );
      ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(2, "Mascali", "Giarre", 14);
       ferrovia.ConfermaCollegamento();
     ferrovia.InserisciCollegamento(3, "Giarre", "Acireale", 23);
      ferrovia.ConfermaCollegamento();
      
        Collegamento collegamento= ferrovia.InserisciCollegamento(3, "Giarre", "Acireale", 23);
        

        collegamento=ferrovia.InserisciCollegamento(1, "catania","messina", 20);
        assertNull("inserimento riuscito",collegamento);
                
   }
   @Test
   public void testFindPercorso(){
       ferrovia.creaPercorso();
       ferrovia.InserisciStazione( "Trumpitello", "Mascali");
       ferrovia.ConfermaPercorso();
        
      
       assertEquals("il valore non è corretto",1,ferrovia.findPercorso("Trumpitello" ,"Mascali").size());
       ferrovia.creaPercorso();
       ferrovia.InserisciStazione( "Trumpitello", "Mascali");
       ferrovia.ConfermaPercorso(); 
       assertEquals("il valore non è corretto",2,ferrovia.findPercorso("Trumpitello" ,"Mascali").size());
        assertEquals("il valore non è corretto",0,ferrovia.findPercorso("roma" ,"palermo").size()); 
   }
}
