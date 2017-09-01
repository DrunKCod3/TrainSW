/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class TrattaTest {

    @Test
    public void testCalcolaOrari() {
        Tratta tratta = new Tratta();
        Treno tr = new Treno(2, new TipoTreno(2, "treno notte", (short) 23, (short) 23, (short) 23, 23, 15, 16));
        Date partenza = new Date();
        tratta.setData_p(partenza);
        tratta.setTreno(tr);

        tratta.addFermata(new Fermata(1, 0));
        tratta.addFermata(new Fermata(2, 30));
        tratta.addFermata(new Fermata(3, 49));

        List<FermataOrario> fermate = tratta.calcolaOrari();

        assertEquals(3, fermate.size());
        long orario = partenza.getTime();
        FermataOrario fermata = fermate.get(0);
        Date prova = new Date();
  //      assertEquals(prova, fermata.getOrario());
        fermata = fermate.get(1);
        orario = partenza.getTime() + (long) ((30 / (float)23) * 3600 * 1000);
        prova.setTime(orario);
        assertEquals(prova, fermata.getOrario());
        fermata = fermate.get(2);

        orario = partenza.getTime() + (long) ((49 /(float) 23) * 3600 * 1000);
        prova.setTime(orario);
        assertEquals(prova, fermata.getOrario());
    }
 @Test
    public void testqualcosa(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TipoTreno tt=(TipoTreno) session.createQuery("From TipoTreno").list().get(0);

        session.getTransaction().commit();
        session.close();
  
        
    }
}
