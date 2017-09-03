package trainsw;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class TipoTreno {

    private int id_tt;
    private String tt_name;
    private short posti_letto;
    private short np_2c;
    private short np_1c;
    private double velocita;
    private double prezzo_prima;
    private double prezzo_seconda;
    private Treno treno;
    private List<Treno> treni; 
    public Treno creaTreno(int id_tr) {
        Treno treno = new Treno(id_tr, this);
        return treno;
    }

    public TipoTreno(int id_tt, String tt_name, short posti_letto, short np_2c, short np_1c, double velocita, double prezzo_prima, double prezzo_seconda) {
        this.id_tt = id_tt;
        this.tt_name = tt_name;
        this.posti_letto = posti_letto;
        this.np_2c = np_2c;
        this.np_1c = np_1c;
        this.velocita = velocita;
        this.prezzo_prima = prezzo_prima;
        this.prezzo_seconda = prezzo_seconda;
        this.treni=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TipoTreno{" + "id_tt=" + id_tt + ", tt_name=" + tt_name + ", posti_letto=" + posti_letto + ", np_2c=" + np_2c + ", np_1c=" + np_1c + ", velocita=" + velocita + ", prezzo_prima=" + prezzo_prima + ", prezzo_seconda=" + prezzo_seconda + '}';
    }

    

    
    public int getId_tt() {
        return id_tt;
    }

    public void setId_tt(int id_tt) {
        this.id_tt = id_tt;
    }

    public String getTt_name() {
        return tt_name;
    }

    public void setTt_name(String tt_name) {
        this.tt_name = tt_name;
    }

    public short getPosti_letto() {
        return posti_letto;
    }

    public void setPosti_letto(short posti_letto) {
        this.posti_letto = posti_letto;
    }

    public short getNp_2c() {
        return np_2c;
    }

    public void setNp_2c(short np_2c) {
        this.np_2c = np_2c;
    }

    public short getNp_1c() {
        return np_1c;
    }

    public void setNp_1c(short np_1c) {
        this.np_1c = np_1c;
    }

    public double getVelocita() {
        return velocita;
    }

    public void setVelocita(double velocita) {
        this.velocita = velocita;
    }

    public double getPrezzo_prima() {
        return prezzo_prima;
    }

    public void setPrezzo_prima(double prezzo_prima) {
        this.prezzo_prima = prezzo_prima;
    }

    public double getPrezzo_seconda() {
        return prezzo_seconda;
    }

    public void setPrezzo_seconda(double prezzo_seconda) {
        this.prezzo_seconda = prezzo_seconda;
    }

   
    
    public TipoTreno(int id_tt, String tt_name, short posti_letto, short np_2c, short np_1c, double velocita) {
        super();
        this.id_tt = id_tt;
        this.tt_name = tt_name;
        this.posti_letto = posti_letto;
        this.np_2c = np_2c;
        this.np_1c = np_1c;
        this.velocita = velocita;
    }

	//Commento inutile
    public TipoTreno() {
        // TODO Auto-generated constructor stub
    }
    public void confermaTreno(){
        addTreno(treno);
    }
    public void addTreno(Treno tr) {
        Session session = new NewHibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();
     
        treni.add(tr);
        session.update(this);
        session.save(tr);
        session.getTransaction().commit();
        session.close();
    }
    public Treno InserisciTreno(int id_tr){
       Treno tr=null;
        if(!isPresent(id_tr))
            tr=new Treno(id_tr, this);
        treno=tr;
       return treno; 
    }
   public boolean isPresent(int id_tr){
           for (Treno tr : treni) 
            if (tr.getId_tr() == id_tr) 
                return true;
            
        

        return false;
   }

    public Treno getTreno() {
        return treno;
    }

    public void setTreno(Treno treno) {
        this.treno = treno;
    }

    public List<Treno> getTreni() {
        return treni;
    }

    public void setTreni(List<Treno> treni) {
        this.treni = treni;
    }
    
    
    
}
