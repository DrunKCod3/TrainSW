package trainsw;

import java.util.Date;

public class Abbonamento {
	private Integer id_abb;
    private Date data_inizio;
    private Date data_scadenza;  
    private Integer staz_p;
    private Integer staz_a;
    private double prezzo;
    private double distanza;
    private Cliente cliente;
    private TipoAbbonamento tipo;
    
    public Abbonamento()
    {
    }

    public Abbonamento(Integer staz_p, Integer staz_a, double distanza, Cliente cliente) {
        this.data_inizio=new Date();
        this.data_scadenza=new Date();
        this.data_scadenza.setTime(data_inizio.getTime()+(30*24*60*60*1000));
        this.staz_p = staz_p;
        this.staz_a = staz_a;
        this.distanza = distanza;
        this.cliente = cliente;
    }
           
   
    
    public void calcolaPrezzo(){
    	prezzo=distanza*0.5;
        prezzo+=tipo.getPrezzo_b();
       
  	}

    public Integer getId_abb() {
        return id_abb;
    }

    public void setId_abb(Integer id_abb) {
        this.id_abb = id_abb;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public Integer getStaz_p() {
        return staz_p;
    }

    public void setStaz_p(Integer staz_p) {
        this.staz_p = staz_p;
    }

    public Integer getStaz_a() {
        return staz_a;
    }

    public void setStaz_a(Integer staz_a) {
        this.staz_a = staz_a;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getDistanza() {
        return distanza;
    }

    public void setDistanza(double distanza) {
        this.distanza = distanza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAbbonamento tipo) {
        this.tipo = tipo;
    }
    
    
}
