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
public class ComentarioDTO {
    
    private int id;
    
    private String comentario;
    
    private String autor;

    public int getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
