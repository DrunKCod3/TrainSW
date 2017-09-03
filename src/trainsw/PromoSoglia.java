/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Limina
 */
public class PromoSoglia extends Promozione{
    private double sogliaprezzo;
    private double scontosoglia;
    
    public PromoSoglia(String nome, int sogliapunti, double sogliaprezzo, double scontosoglia) {
        this.nome= nome;
        this.sogliapunti = sogliapunti;
        this.sogliaprezzo = sogliaprezzo;
        this.scontosoglia = scontosoglia;
    }

    @Override
    public double calcolaPromozione(double prezzo, int punti) {
         
       if(punti >= sogliapunti)
       {
        if(prezzo > sogliaprezzo){
            prezzo = prezzo - (prezzo * scontosoglia);
            return prezzo;
        }
        }
       else{
           JOptionPane.showMessageDialog(new JFrame(), "Saldo punti non sufficiente");
           return prezzo;
       }
        return prezzo;
    }
    
    @Override
    public int getSogliaPunti() {
        return this.sogliapunti;
    }

    
}