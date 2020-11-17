/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import DTO.ArtigoDTO;
import business.ArtigoBO;
import java.io.IOException;
import java.util.Objects;
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
        
        switch (acao) {
            case "novo":
                view = request.getRequestDispatcher("jsp/novoArtigo.jsp");
                view.forward(request, response);
                break;
            case "listar":
                if (!Objects.isNull(request.getParameter("sucesso"))) {
                    request.setAttribute("mensagemSucesso", "Sua solicitação de acesso foi efetuada com sucesso, enquanto aguarda vc pode navegar pelo artigos.");
                }
                request.setAttribute("artigos", artigoBO.getArtigosPublicos());
                view = request.getRequestDispatcher("jsp/artigos.jsp");
                view.forward(request, response);
                break;
            case "mostrar":  
                String idParam = (String) request.getParameter("id");
                if (!Objects.isNull(idParam)) {
                    int id = (Integer) Integer.valueOf(idParam);
                    ArtigoDTO artigo = artigoBO.getArtigoById(id);
                    request.setAttribute("artigo", artigo);
                    view = request.getRequestDispatcher("jsp/artigo.jsp");
                    view.forward(request, response);
                }

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
                    break;
            }
    }
    
}
