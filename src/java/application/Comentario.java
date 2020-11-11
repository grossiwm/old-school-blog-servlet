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
public class Comentario {
    
    private int id;
    
    private String comentario;
    
    private int id_artigo;
    
    private int id_usuario;

    public Comentario(String comentario, int id_artigo, int id_usuario) {
        this.comentario = comentario;
        this.id_artigo = id_artigo;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_artigo() {
        return id_artigo;
    }

    public void setId_artigo(int id_artigo) {
        this.id_artigo = id_artigo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
