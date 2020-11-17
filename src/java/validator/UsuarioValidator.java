/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Objects;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class UsuarioValidator {
    
    public static ArrayList<String> validaCadastro(Usuario usuario) {
        
        ArrayList<String> erros = new ArrayList<String>();
        
        if (Objects.isNull(usuario.getNome()) || usuario.getNome().equals(""))
            erros.add("Nome não pode estar em branco");
        
        if (Objects.isNull(usuario.getEmail()) || usuario.getEmail().equals(""))
            erros.add("Email não pode estar em branco");
        
        if (Objects.isNull(usuario.getCpf()) || usuario.getCpf().equals(""))
            erros.add("Cpf não pode estar em branco");
        
        if (Objects.isNull(usuario.getPapel()))
            erros.add("Você precisa escolher um papel");
        
        if (Objects.isNull(usuario.getSenha()) || usuario.getSenha().equals("")) 
            erros.add("É preciso preencher senha.");
        
        if (Objects.isNull(usuario.getSenhaConfirmacao()) || usuario.getSenhaConfirmacao().equals("")) 
            erros.add("É preciso preencher a confirmação de senha.");
        
        if (!Objects.isNull(usuario.getSenha()) && !Objects.isNull(usuario.getSenhaConfirmacao()) && !usuario.getSenha().equals(usuario.getSenhaConfirmacao()))
            erros.add("Senha e confirmação de senha não conferem");
        
        return erros;
    }
    
}
