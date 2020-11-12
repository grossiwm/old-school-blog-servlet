/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Usuario;
import utils.StringUtils;

/**
 *
 * @author gabriel
 */
public class LoginBO {
    
    public boolean autenticaUsuario(HttpServletRequest request) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        String cpf = StringUtils.formataCpf(request.getParameter("cpf"));
        String senha = request.getParameter("senha");
        
        Usuario usuario = usuarioDAO.findByCpf(cpf);

        if (usuario.getSenha().equals(senha)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            return true;
        }
        
        return false;
       
    }

}
