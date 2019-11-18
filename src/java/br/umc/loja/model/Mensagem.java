/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.model;

import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Mensagem {
    private int id;
    private int status;
    private int destinatatio;
    private int remetente;
    private String assunto;
    private String Conteudo;
    private Date data;
    private Vendedor dest = new Vendedor(null, null, null);
    private Vendedor rem = new Vendedor(null, null, null);

    public Vendedor getDest() {
        return dest;
    }

    public void setDest(Vendedor dest) {
        this.dest = dest;
    }

    public Vendedor getRem() {
        return rem;
    }

    public void setRem(Vendedor rem) {
        this.rem = rem;
    }

    public Mensagem(int destinatatio, int remetente, String assunto, String Conteudo) {
        this.destinatatio = destinatatio;
        this.remetente = remetente;
        this.assunto = assunto;
        this.Conteudo = Conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDestinatatio() {
        return destinatatio;
    }

    public void setDestinatatio(int destinatatio) {
        this.destinatatio = destinatatio;
    }

    public int getRemetente() {
        return remetente;
    }

    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String Conteudo) {
        this.Conteudo = Conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
