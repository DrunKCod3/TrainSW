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
public class Cliente {
    private String nome;
    private String cognome;
    private String cf;
    private Date data_nascita;
    private char sesso;
    private int id_cliente;

    public Cliente(String nome, String cognome, String cf, Date data_nascita, char sesso, int id_cliente) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.data_nascita = data_nascita;
        this.sesso = sesso;
        this.id_cliente = id_cliente;
    }

    public Cliente(String nome, String cognome, String cf, Date data_nascita, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.data_nascita = data_nascita;
        this.sesso = sesso;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
}
