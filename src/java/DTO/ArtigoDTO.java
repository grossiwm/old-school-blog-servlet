/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author gabriel
 */
public class ArtigoDTO {
    
    private int id;
    
    private String titulo;
    
    private String conteudo;
    
    private String autor;
    
    private int autorId;
    
    private String categoria;
    
    private String liberado;
    
    private String aprovado;

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
    
    public String getLiberado() {
        return liberado;
    }

    public void setLiberado(String liberado) {
        this.liberado = liberado;
    }

    public String getAprovado() {
        return aprovado;
    }

    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
