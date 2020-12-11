/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.UsuarioDAO;
import java.util.List;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class UsuarioBO {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }
    
    public void salvaUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }
    
    public List<Usuario> getAllUsuarioAguardandoAceite(){
        return usuarioDAO.findAllByCadastroAprovado('N');
    }
    
    public void removeUsuarioPorId(int id) {
        usuarioDAO.delete(id);
    }
   
    public void aprovaUsuario(int id) {
        Usuario usuario = usuarioDAO.find(id);
        usuario.setCadastroAprovado('S');
        usuarioDAO.save(usuario); 
    }
    
    public List<Usuario> getTodos() {
        return usuarioDAO.findAll();
    }
    
    public Usuario getUsuarioById(int id) {
        return usuarioDAO.find(id);
    }
}
