/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

/**
 *
 * @author Luis
 */
public class Startup {
    
    private TrainSW trainsw;
    
    public Startup(TrainSW trainsw) {
        this.trainsw = trainsw;
        
      Promozione promoStandard = new PromoStandard("Standard",100, 0.05);
      Promozione promoSoglia = new PromoSoglia ("Soglia", 250, 80, 0.4);
      Promozione allInclusivePromo = new AllInclusivePromo("AllInclusive", 350);
      
      allInclusivePromo.addPromotion(promoSoglia);
      allInclusivePromo.addPromotion(promoStandard);

      trainsw.addPromozione(promoSoglia);
      trainsw.addPromozione(promoStandard);
      trainsw.addPromozione(allInclusivePromo);
    }

}
