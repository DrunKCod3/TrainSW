/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsw;

import java.util.Date;

/**
 *
 * @author Andrea
 */
public class FermataOrario {
    private int id;
    private Date orario;
    private int id_fermata;
    private int id_tratta;
    private Tratta tratta;
    private Fermata fermata; 
    public FermataOrario() {

    }

    public Date getOrario() {
        return orario;
    }

    public void setOrario(Date orario) {
        this.orario = orario;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Fermata getFermata() {
        return fermata;
    }

    public void setFermata(Fermata Fermata) {
        this.fermata = Fermata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fermata() {
        return id_fermata;
    }

    public void setId_fermata(int id_fermata) {
        this.id_fermata = id_fermata;
    }

    public int getId_tratta() {
        return id_tratta;
    }

    public void setId_tratta(int id_tratta) {
        this.id_tratta = id_tratta;
    }
    public int getDistanzaParziale(){
       return  fermata.getDistanza_p();
    }
   

}
