package trainsw;

public class Collegamento {
private Integer id_collegamento;
private String id_stazione_a;
private String id_stazione_b;
private Integer distanza;
private Stazione stazione_a;
private Stazione stazione_b;



    public Collegamento() {
    }

    @Override
    public String toString() {
        return "Collegamento{" + "id_collegamento=" + id_collegamento + ", id_stazione_a=" + id_stazione_a + ", id_stazione_b=" + id_stazione_b + ", distanza=" + distanza + ", stazione_a=" + stazione_a.getNome_stazione() + ", stazione_b=" + stazione_b.getNome_stazione() + '}';
    }
    

    public Collegamento(Integer id_collegamento, String id_stazione_a, String id_stazione_b, Integer distanza) {
        this.id_collegamento = id_collegamento;
        this.id_stazione_a = id_stazione_a;
        this.id_stazione_b = id_stazione_b;
        this.distanza = distanza;
    }

    public Collegamento(Integer id_collegamento, String id_stazione_a, String id_stazione_b, Integer distanza, Stazione stazione_a, Stazione stazione_b) {
        this.id_collegamento = id_collegamento;
        this.id_stazione_a = id_stazione_a;
        this.id_stazione_b = id_stazione_b;
        this.distanza = distanza;
        this.stazione_a = stazione_a;
        this.stazione_b = stazione_b;
    }

 

    public Integer getId_collegamento() {
        return id_collegamento;
    }

    public void setId_collegamento(Integer id_collegamento) {
        this.id_collegamento = id_collegamento;
    }

    public String getId_stazione_a() {
        return id_stazione_a;
    }

    public void setId_stazione_a(String id_stazione_a) {
        this.id_stazione_a = id_stazione_a;
    }

    public String getId_stazione_b() {
        return id_stazione_b;
    }

    public void setId_stazione_b(String id_stazione_b) {
        this.id_stazione_b = id_stazione_b;
    }

    public Integer getDistanza() {
        return distanza;
    }

    public void setDistanza(Integer distanza) {
        this.distanza = distanza;
    }

    public Stazione getStazione_a() {
        return stazione_a;
    }

    public void setStazione_a(Stazione stazione_a) {
        this.stazione_a = stazione_a;
    }

    public Stazione getStazione_b() {
        return stazione_b;
    }

    public void setStazione_b(Stazione stazione_b) {
        this.stazione_b = stazione_b;
    }


}
