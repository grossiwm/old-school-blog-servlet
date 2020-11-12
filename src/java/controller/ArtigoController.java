/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import business.ArtigoBO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Artigo;
import model.Usuario;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/artigo"})
public class ArtigoController extends HttpServlet {
    
    private ArtigoBO artigoBO;
    
    @Override
    public void init() throws ServletException {
        artigoBO = new ArtigoBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        
        HttpSession session = request.getSession();
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        RequestDispatcher view = null;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Integer id = null;
        
        switch (acao) {
            case "novo":
                view = request.getRequestDispatcher("jsp/novoArtigo.jsp");
                view.forward(request, response);
        }       
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acao = (String) request.getParameter("acao");
            HttpSession session = request.getSession();
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
            
            switch(acao) {
                case "criar":
                    Artigo artigo = new Artigo();
                    artigo.setTitulo(request.getParameter("titulo"));
                    artigo.setConteudo(request.getParameter("conteudo"));
                    artigoBO.criaArtigo(artigo);
            }
    }
    
}
