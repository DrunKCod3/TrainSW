package trainsw;

public abstract class Promozione {
	
	String nome;
        int sogliapunti;

	public abstract double calcolaPromozione(double prezzo, int punti);

        public String getNome() {
		return nome;
	}
	
        public int getSogliaPunti() {
                return sogliapunti;
        }
	
	public Promozione getPromozione(String nome)	{
		return null;
	}

        public void setSogliaPunti(int sogliapunti) {
                this.sogliapunti = sogliapunti;
        }
       	public void addPromotion(Promozione p)	{
		
	}
	
	public void remove(Promozione p){
		
	}
	
}