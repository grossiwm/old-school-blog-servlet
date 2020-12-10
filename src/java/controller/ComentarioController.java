/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.ComentarioBO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comentario;
import model.Usuario;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/comentario"})
public class ComentarioController extends HttpServlet {
    
    private ComentarioBO comentarioBO;
    
    @Override
    public void init() throws ServletException {
        comentarioBO = new ComentarioBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        switch (acao) {   
            case "deletar":
                int id = Integer.parseInt(request.getParameter("id"));
                int artigoId = Integer.parseInt(request.getParameter("artigoId"));
                comentarioBO.deletarComentario(id);
                response.sendRedirect("artigo?acao=mostrar&id=" + artigoId);
            break;
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        switch(acao) {
            case "criar":
                Comentario comentario = new Comentario();
                comentario.setIdArtigo(Integer.valueOf(request.getParameter("artigoId")));
                comentario.setComentario(request.getParameter("comentario"));
                comentario.setIdUsuario(Integer.valueOf(request.getParameter("usuarioId")));
                comentarioBO.criaComentario(comentario);
                response.sendRedirect("artigo?acao=mostrar&id=" + comentario.getIdArtigo());
            break;
        }
    }   
}
