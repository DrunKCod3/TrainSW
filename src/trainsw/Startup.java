/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;

/**
 *
 * @author Luis
 */
public class Startup {
    
    private TrainSW trainsw;
    private POS pos;
    private Ferrovia ferrovia;

    
    
    public Startup(TrainSW trainsw) {
        
        
        
        this.trainsw = trainsw;
       pos = trainsw.getPos();
       
   
       
       
        
      Promozione promoStandard = new PromoStandard("Standard",100, 0.05);
      Promozione promoSoglia = new PromoSoglia ("Soglia", 250, 80, 0.4);
      Promozione allInclusivePromo = new AllInclusivePromo("AllInclusive", 350);
      
      allInclusivePromo.addPromotion(promoSoglia);
      allInclusivePromo.addPromotion(promoStandard);

      pos.addPromozione(promoSoglia);
      pos.addPromozione(promoStandard);
      pos.addPromozione(allInclusivePromo);
      

    }

}
