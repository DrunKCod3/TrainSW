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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class Startup {
    
    private TrainSW trainsw;
    private POS pos;
    private Ferrovia ferrovia;
   

    
    
    public Startup(TrainSW trainsw) {
        
        
        String string1  = "12 10 2010";
        String string2 = "14 12 2020";
        String string3 = "25 12 2000";
        String string4 = "01 01 2018";
        this.trainsw = trainsw;
       pos = trainsw.getPos();
       
   DateFormat format = new SimpleDateFormat("dddd mm yyyy", Locale.ITALIAN);
        Date anno1 = null, anno2 = null, anno3 = null, anno4 = null;
        try {
            anno1 = format.parse(string1);
            anno2 = format.parse(string2);
            anno3 = format.parse(string3);
            anno4 = format.parse(string4);
             
        } catch (ParseException ex) {
            Logger.getLogger(insOrarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Cliente cliente = new Cliente("Ajeje", "Brazorf", "JJBRZF23FXCVW", new Date(), 'm');
       Tessera tessera1 = new Tessera(1, anno1, anno2, 0, cliente);
       
       Cliente cliente1 = new Cliente("Mario", "Rossi", "MRRS12A24DVDX", new Date(), 'm');
       Tessera tessera2 = new Tessera(2, anno3, anno4, 0, cliente1);
       
        
      Promozione promoStandard = new PromoStandard("Standard",100, 0.05);
      Promozione promoSoglia = new PromoSoglia ("Soglia", 250, 80, 0.4);
      Promozione allInclusivePromo = new AllInclusivePromo("AllInclusive", 350);
      
      allInclusivePromo.addPromotion(promoSoglia);
      allInclusivePromo.addPromotion(promoStandard);

      pos.addPromozione(promoSoglia);
      pos.addPromozione(promoStandard);
      pos.addPromozione(allInclusivePromo);
      
      this.trainsw.addTessera(tessera1);
      this.trainsw.addTessera(tessera2);
      

    }

}
