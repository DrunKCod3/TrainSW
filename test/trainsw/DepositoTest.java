/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class DepositoTest {
    


    @Test
    public void testIsFull() {
      Deposito dp= new Deposito(1, 2);
      Treno tr1 =new Treno(1);
       Treno tr2 =new Treno(2);
   
        dp.getTreni().add(tr1);
        assertFalse("il deposito è pieno", dp.isFull());
        dp.getTreni().add(tr2);
        assertTrue("il deposito non è pieno",dp.isFull());
   }
    @Test
    public void testaddTreno(){
         Deposito dp= new Deposito(2, 2);
         Treno tr1 =new Treno(1); 
         dp.addTrenoDeposito(tr1);
         assertEquals(1,dp.getTreni().size());
    }
}
