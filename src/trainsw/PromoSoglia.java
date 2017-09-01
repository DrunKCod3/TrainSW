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
    private int punti;
    public PromoSoglia(String nome, int punti) {
        this.nome= nome;
        this.punti = punti;
    }

    @Override
    public double calcolaPromozione(double prezzo, int punti) {
       if(punti >= 250)
       {
        
        if(prezzo>60){
            prezzo = prezzo - (prezzo * 40)/100 ;
            return prezzo;
        }
        }
       else{
           JOptionPane.showMessageDialog(new JFrame(), "Saldo punti non sufficiente");
           return prezzo;
       }
        return prezzo;
    }
    
}