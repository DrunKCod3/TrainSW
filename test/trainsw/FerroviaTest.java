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
                    
                  ferrovia.inserisciStazione(1, 2, "catania_centrale" ,"catania");
                 
                  ferrovia.confermaStazione();
                  ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
                  ferrovia.confermaStazione();
            Stazione   st=ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
              assertNull("la ferrovia è gia presente nell'archivio ",st);
              ferrovia.confermaStazione();
           
  
               
    }
    @Test
    public void testisPresent(){
                 ferrovia.inserisciStazione(1, 2, "catania_centrale" ,"catania");
                 ferrovia.confermaStazione();
                  ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
                  ferrovia.confermaStazione();
        assertEquals("la stazione non è presente",true,ferrovia.isPresent(1,"catania"));
        assertFalse("la stazione è presente", ferrovia.isPresent(20,"genova"));
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
        ferrovia.inserisciStazione(1, 2, "catania_centrale" ,"catania");
        ferrovia.confermaStazione();
        ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
        ferrovia.confermaStazione();
        ferrovia.inserisciStazione(3, 2, "catania_centrale", "palermo");
        ferrovia.confermaStazione();
         ferrovia.InserisciCollegamento(1,"catania" , "messina", 20);
        ferrovia.ConfermaCollegamento();
      ferrovia.InserisciCollegamento(2,"messina" , "palermo", 20);
        ferrovia.ConfermaCollegamento();
       
       Deposito dep= ferrovia.inserisciDeposito(1, "catania", 20);
       ferrovia.confermaDeposito(dep);
        ferrovia.creaPercorso();
       List<Fermata>fermata= ferrovia.InserisciStazione("catania", "messina");
       assertEquals("le fermate non sono ",2,fermata.size());
       fermata= ferrovia.InserisciStazione("messina", "palermo");
         assertNull("la stazione non è deposito ",fermata);
       fermata= ferrovia.InserisciStazione("catania", "genova");
       assertNull("le fermate non sono ",fermata);

     }
     
     @Test
   public void testInserisciCollegamento(){
      
      ferrovia.inserisciStazione(1, 2, "catania_centrale" ,"catania");
      ferrovia.confermaStazione();
      ferrovia.inserisciStazione(2, 2, "catania_centrale", "messina");
      ferrovia.confermaStazione();
      ferrovia.inserisciStazione(3, 2, "catania_centrale", "palermo");
      
      
        Collegamento collegamento=ferrovia.InserisciCollegamento(1,"catania" , "messina", 20);
        

        collegamento=ferrovia.InserisciCollegamento(1, "catania","messina", 20);
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
