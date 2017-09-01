/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

/**
 *
 * @author Luciano Limina
 */
public class AllInclusivePromo extends Promozione{
/*public PromozioneComposite(String nome)	{
		this.nome = nome;
		listaPromozioni = new LinkedList<Promozione>();
	*/
    //private List<Promozione> promolist = new ArrayList<Promozione>();
    private int punti;
    private PromoStandard pstandard;
    private PromoSoglia psoglia;
    public AllInclusivePromo(String nome, int punti) {
        this.nome= nome;
        this.punti = punti;
    }
   
    @Override
    public double calcolaPromozione(double prezzo, int punti) {
        pstandard = new PromoStandard("Standard", punti);
        psoglia = new PromoSoglia("Soglia", punti);
        if(punti >= 350){      
                prezzo = psoglia.calcolaPromozione(prezzo, punti);  
                prezzo = pstandard.calcolaPromozione(prezzo, punti);  
            return prezzo;
        }
        return prezzo;
    }
    
/*
    public List<Promozione> getPromolist() {
        return promolist;
    }

    public void setPromolist(List<Promozione> promolist) {
        this.promolist = promolist;
    }
    
    public void addPromotion(Promozione promo){
        this.promolist.add(promo);
        
    }
  */  
}