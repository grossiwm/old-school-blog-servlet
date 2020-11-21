/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import DTO.ArtigoDTO;
import business.ArtigoBO;
import business.CategoriaBO;
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
import model.Artigo;
import model.Categoria;
import model.Usuario;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/artigo"})
public class ArtigoController extends HttpServlet {
    
    private ArtigoBO artigoBO;
    private CategoriaBO categoriaBO;
    
    @Override
    public void init() throws ServletException {
        artigoBO = new ArtigoBO();
        categoriaBO = new CategoriaBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = (String) request.getParameter("acao");
        
        HttpSession session = request.getSession();
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        RequestDispatcher view = null;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        String idParam = null;
        
        ArtigoDTO artigoDTO = null;
        
        Artigo artigo = null;
        
        switch (acao) {
            case "novo":
                
                List<Categoria> categorias = categoriaBO.getTodasCategorias();
                
                view = request.getRequestDispatcher("jsp/novoArtigo.jsp");
                request.setAttribute("categorias", categorias);
                request.setAttribute("uid", usuarioLogado.getId());
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
                idParam = (String) request.getParameter("id");
                if (!Objects.isNull(idParam)) {
                    int id = (Integer) Integer.valueOf(idParam);
                    artigoDTO = artigoBO.getArtigoById(id);
                    request.setAttribute("artigo", artigoDTO);
                    view = request.getRequestDispatcher("jsp/artigo.jsp");
                    view.forward(request, response);
                }
                break;
            case "meusArtigos":
                String mensagemSucesso = null;
                if (!Objects.isNull(request.getParameter("sucesso"))) {
                    mensagemSucesso = "Ação efetuada com sucesso.";
                    request.setAttribute("mensagemSucesso", mensagemSucesso);
                }
                request.setAttribute("artigos", artigoBO.getArtigoDTOByUsuarioID(usuarioLogado.getId()));
                view = request.getRequestDispatcher("jsp/meusArtigos.jsp");
                view.forward(request, response);
                break;
            case "liberar":
                idParam = (String) request.getParameter("id");
                if (!Objects.isNull(idParam)) {
                    int id = (Integer) Integer.valueOf(idParam);
                    artigoBO.liberarArtigo(id);
                    response.sendRedirect("artigo?acao=meusArtigos&mensagem");
                }
                break;
            case "tornarNaoLiberado":
                idParam = (String) request.getParameter("id");
                if (!Objects.isNull(idParam)) {
                    int id = (Integer) Integer.valueOf(idParam);
                    artigoBO.liberarArtigo(id);
                    response.sendRedirect("artigo?acao=meusArtigos&sucesso");
                }
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
                    Artigo artigo = new Artigo();
                    artigo.setTitulo(request.getParameter("titulo"));
                    artigo.setConteudo(request.getParameter("conteudo"));
                    artigo.setIdCategoria(Integer.valueOf(request.getParameter("categoria")));
                    artigo.setIdUsuario(Integer.valueOf(request.getParameter("uid")));
                    String liberarParam = request.getParameter("liberar");
                    
                    if (!Objects.isNull(liberarParam) && liberarParam.equals("on")) {
                        artigo.setLiberar('S');
                    } else {
                        artigo.setLiberar('N');
                    }
                    
                    artigoBO.criaArtigo(artigo);
                    response.sendRedirect("artigo?acao=meusArtigos&sucesso");
                    break;
            }
    }
    
}
