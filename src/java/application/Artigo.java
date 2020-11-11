/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author gabriel
 */
public class Artigo {
    
    private int id;

    private char aprovado;

    private String conteudo;

    private int id_categoria;

    private int id_usuario;

    private char liberar;

    private String titulo;  

    public Artigo(char aprovado, String conteudo, int id_categoria, int id_usuario, char liberar, String titulo) {
        this.aprovado = aprovado;
        this.conteudo = conteudo;
        this.id_categoria = id_categoria;
        this.id_usuario = id_usuario;
        this.liberar = liberar;
        this.titulo = titulo;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
