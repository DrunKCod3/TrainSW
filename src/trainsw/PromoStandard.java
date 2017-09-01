/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Limina
 */
public class PromoStandard extends Promozione {
    
    private double scontostandard;

    public PromoStandard(String nome, int sogliapunti, double scontostandard) {
        this.nome = nome;
        this.sogliapunti = sogliapunti;
        this.scontostandard = scontostandard;
    }

    @Override
    public double calcolaPromozione(double prezzo, int punti) {
        
        if(punti >= sogliapunti)
        {
        prezzo = prezzo - (prezzo * scontostandard);
        return prezzo;
        } else {
             JOptionPane.showMessageDialog(new JFrame(), "Saldo punti non sufficiente");
             return prezzo;
        }
    }
    
    @Override
    public int getSogliaPunti() {
                return this.sogliapunti;
        }
    
}