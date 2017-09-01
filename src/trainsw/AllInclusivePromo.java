
package trainsw;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AllInclusivePromo extends Promozione{

    private List<Promozione> promolist = new ArrayList<Promozione>();
    
    public AllInclusivePromo(String nome, int sogliapunti) {
        this.nome= nome;
        this.sogliapunti = sogliapunti;
    }
   
    @Override
    public double calcolaPromozione(double prezzo, int punti) {
        if(punti >= sogliapunti){      
            for(Promozione p: promolist)	
            {
		prezzo = p.calcolaPromozione(prezzo, punti);
            }
            return prezzo;
        }
        JOptionPane.showMessageDialog(new JFrame(), "Saldo punti non sufficiente");
        return prezzo;
    }
    
    @Override
    public int getSogliaPunti() {
                return this.sogliapunti;
        }

    @Override
    public void addPromotion(Promozione promo){
        this.promolist.add(promo);   
    }
    
    public List<Promozione> getPromolist() {
        return promolist;
    }

    public void setPromolist(List<Promozione> promolist) {
        this.promolist = promolist;
    }
}