/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Objects;
import model.Artigo;

/**
 *
 * @author gabriel
 */
public class ArtigoValidator {
    
    public static ArrayList<String> validaCriarArtigo(Artigo artigo) {
        
        ArrayList<String> erros = new ArrayList<String>();
        
        if (artigo.getIdCategoria() == 0) 
            erros.add("Precisa selecionar uma categoria");
        
        
        if (artigo.getIdUsuario() == 0) 
            erros.add("Artigo precisa pertencer a um usuário");
        
        
        if (Objects.isNull(artigo.getTitulo()) || artigo.getTitulo().equals(""))
            erros.add("Artigo precisa de título");
        
        
        if (Objects.isNull(artigo.getConteudo()) || artigo.getConteudo().equals("")) 
            erros.add("Artigo precisa de conteúdo");
        
        return erros;
        
    }
    
}
