/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel
 */
public class Artigo {
    
    private int id;

    private String conteudo;

    private int idCategoria;

    private int idUsuario;

    private char liberar;
    
    private char aprovado;

    private String titulo;  

    public Artigo() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getAprovado() {
        return aprovado;
    }

    public void setAprovado(char aprovado) {
        this.aprovado = aprovado;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public char getLiberar() {
        return liberar;
    }

    public void setLiberar(char liberar) {
        this.liberar = liberar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
        
        
}
