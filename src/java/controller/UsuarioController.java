/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enums.PapelUsuario;
import model.Usuario;
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
import business.UsuarioBO;
import java.util.ArrayList;
import validator.UsuarioValidator;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/usuario"})
public class UsuarioController extends HttpServlet{
    
    private UsuarioBO usuarioBO;
    
    @Override
    public void init() throws ServletException {
        usuarioBO = new UsuarioBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        
        HttpSession session = request.getSession();
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        RequestDispatcher view = null;
        
        Integer id = null;

        
        switch (acao) {
            case "solicitar":
                
                view = request.getRequestDispatcher("jsp/solicitar.jsp");
                view.forward(request, response);
                break;
            case "solicitacoes":
                
                
                    if (!Objects.isNull(request.getParameter("sucesso"))) {
                        request.setAttribute("mensagemSucesso", "Ação executada com sucesso.");
                    }
                    
                    List<Usuario> usuarios = usuarioBO.getAllUsuarioAguardandoAceite();
                    
                    request.setAttribute("usuarios", usuarios);
                    
                    view = request.getRequestDispatcher("jsp/solicitacoes.jsp");
                    
                    view.forward(request, response);
                    break;
                    
            case "deletar":
                id = Integer.parseInt(request.getParameter("id"));
                usuarioBO.removeUsuarioPorId(id);
                request.setAttribute("sucesso", "usuario de id " + id + " deletado com sucesso");

                response.sendRedirect("usuario?acao=solicitacoes&sucesso");
                break;
                
                
            case "aceitar":
                id = Integer.parseInt(request.getParameter("id"));
                usuarioBO.aprovaUsuario(id);
                response.sendRedirect("usuario?acao=solicitacoes&sucesso");
                break;
                
            case "logout":
                session.invalidate();
                response.sendRedirect("login");
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        
        RequestDispatcher view = null;
        
        switch (acao) {
                
            case "solicitar":
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String cpf = request.getParameter("cpf");
                String senha = request.getParameter("senha");
                String senhaConfirmacao = request.getParameter("senha-confirmacao");
                Integer papel = null;
                if (!Objects.isNull(request.getParameter("papel")))
                    papel = PapelUsuario.valueOf(request.getParameter("papel")).getValorInteiro();
                
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setCpf(cpf);
                usuario.setPapel(papel);
                usuario.setSenha(senha);
                usuario.setSenhaConfirmacao(senhaConfirmacao);
                usuario.setCadastroAprovado('N');
                
                ArrayList<String> erros = UsuarioValidator.validaCadastro(usuario);
                 
                if (erros.size() > 0) {
                    request.setAttribute("erros", erros);
                    view = request.getRequestDispatcher("jsp/solicitar.jsp");
                    view.forward(request, response);
                } else {
                    
                    usuarioBO.salvaUsuario(usuario);

                    response.sendRedirect("artigo?acao=listar&sucesso");
                    
                }
                
                
        }
        
    }
    
}
