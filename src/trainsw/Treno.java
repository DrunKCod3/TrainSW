package trainsw;

import java.util.List;
import org.hibernate.Session;

public class Treno {

	private int id_tr;
        private TipoTreno tt;
        private int id_dep;
        private Deposito deposito;
       
    public Treno() {
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
	
	public Treno(int id_tr) {
		super();
		this.id_tr = id_tr;
	}

    public Treno(int id_tr, TipoTreno tt) {
        this.id_tr = id_tr;
        this.tt = tt;
    }
       public int getId_tr() {
		return id_tr;
	}

	public void setId_tr(int id_tr) {
		this.id_tr = id_tr;
	}
 


        
        /* Commento Inutile */

    public TipoTreno getTt() {
     
      
        return tt;
    }

    public void setTt(TipoTreno tt) {
        this.tt = tt;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }
    
    public double getVelocita() {
     Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(this);
        double velocita =getTt().getVelocita();
          session.getTransaction().commit();
       session.close();
       return velocita;        
    }
    
    

    
}
 