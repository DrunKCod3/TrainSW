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
public class AbbonamentoTest {
    
    public AbbonamentoTest() {
    }

    @Test
    public void testcalcolaAbbonamento() {
        TipoAbbonamento tipo=new AbbonamentoAnnuale("Abbonamento Annuale gold", 365, 150);
         TipoAbbonamento tipo2=new AbbonamentoMensile("Abbonamento Mensile gold", 30 , 150);  
          Abbonamento abbonamento= new Abbonamento("catania", "messina",40, new Cliente("Marco", "Antonio","sdkjughlaksch",new Date(), 'm'));
          abbonamento.setTipo(tipo);
          abbonamento.calcolaPrezzo();
          
          assertEquals("il risultato è diverso", 3070, abbonamento.getPrezzo(), 0.1);
    }     
    
}
