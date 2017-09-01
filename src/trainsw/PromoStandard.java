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
    private int punti;

    public PromoStandard(String nome, int punti) {
        this.nome= nome;
        this.punti = punti;
    }

    @Override
    public double calcolaPromozione(double prezzo, int punti) {
        if(punti >= 100)
        {
        prezzo = prezzo - ((prezzo * 5)/100);
        return prezzo;
        } else {
             JOptionPane.showMessageDialog(new JFrame(), "Saldo punti non sufficiente");
             return prezzo;
        }
    }
    
}