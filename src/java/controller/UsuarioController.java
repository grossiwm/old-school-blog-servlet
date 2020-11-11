/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.PapelUsuario;
import application.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/usuario"})
public class UsuarioController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        
        HttpSession session = request.getSession();
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        RequestDispatcher view = null;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Integer id = null;
        
        switch (acao) {
            case "solicitar":
                
                view = request.getRequestDispatcher("jsp/solicitacao.jsp");
                view.forward(request, response);
                
            case "solicitacoes":
                
//                if (!Objects.isNull(usuarioLogado) && usuarioLogado.getPapel() == PapelUsuario.ADMINISTRADOR.getValorInteiro()) {
                
                    if (!Objects.isNull(request.getParameter("sucesso"))) {
                        request.setAttribute("mensagemSucesso", "Ação executada com sucesso.");
                    }
                    
                    List<Usuario> usuarios = usuarioDAO.findUsuariosByCadastroAprovado('N');
                    
                    request.setAttribute("usuarios", usuarios);
                    
                    view = request.getRequestDispatcher("jsp/solicitacoes.jsp");
                    
                    view.forward(request, response);
                    
//                }
                    
            case "deletar":
                id = Integer.parseInt(request.getParameter("id"));
                usuarioDAO = new UsuarioDAO();
                usuarioDAO.delete(id);
                
                request.setAttribute("sucesso", "usuario de id " + id + " deletado com sucesso");

                response.sendRedirect("usuario?acao=solicitacoes&sucesso");
                return;
                
                
            case "aceitar":
                id = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = usuarioDAO.find(id);
                usuario.setCadastroAprovado('S');
                usuarioDAO.save(usuario); 
                
                response.sendRedirect("usuario?acao=solicitacoes&sucesso");
                return;
        }
        
    }
    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        String acao = (String) request.getParameter("acao");
//        Integer id = null;
//        
//        RequestDispatcher view = null;
//        
//        switch (acao) {
//            case "deletar":
//                id = Integer.parseInt(request.getParameter("id"));
//                usuarioDAO = new UsuarioDAO();
//                usuarioDAO.delete(id);
//                
//                request.setAttribute("sucesso", "usuario de id " + id + " deletado com sucesso");
//
//                view = request.getRequestDispatcher("jsp/solicitacoes.jsp");
//
//                view.forward(request, response);
//                
//                
//            case "aceitar":
//                id = Integer.parseInt(request.getParameter("id"));
//                Usuario usuario = usuarioDAO.find(id);
//                usuario.setCadastroAprovado('S');
//                usuarioDAO.save(usuario); 
//                
//                request.setAttribute("sucesso", "usuario de id " + id + " aceito com sucesso");
//
//                view = request.getRequestDispatcher("jsp/solicitacoes.jsp");
//
//                view.forward(request, response);
//        }
//        
//    }
    
}
