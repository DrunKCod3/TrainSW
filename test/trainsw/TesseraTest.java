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
public class TesseraTest {
    
    public TesseraTest() {
    }

    @Test
    public void testcalcolaPunti() {
         Tessera tessera=new Tessera(1,new Date(), new Date(),0, new Cliente("Marco", "Antonio","sdkjughlaksch",new Date(), 'm'));
         tessera.CalcolaPunti((float)45.5);
         assertEquals(" i punti non sono calcolati correttamente",18  ,tessera.getPunti());
         tessera.CalcolaPunti((float)45.5);
          assertEquals(" i punti non sono calcolati correttamente",36  ,tessera.getPunti());
    
    }
    
    
}
