/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import enums.PapelUsuario;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author gabriel
 */
@WebFilter(urlPatterns = "/artigo")
public class ArtigoFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        String acao = httpRequest.getParameter("acao");
        
        if (Objects.isNull(usuarioLogado)) {
            
            if (!(acao.equals("listar") || acao.equals("mostrar"))) {
                HttpServletResponse httpResponse = (HttpServletResponse) response; 
                httpResponse.sendRedirect("login");
                return;
            }

        } else {
            
            if (acao.equals("novo") || acao.equals("criar")) {
                
                if (!( usuarioLogado.getPapel() == PapelUsuario.AUTOR.getValorInteiro() || usuarioLogado.getPapel() == PapelUsuario.ADMINISTRADOR.getValorInteiro() )) {
                    HttpServletResponse httpResponse = (HttpServletResponse) response; 
                    httpResponse.sendRedirect("artigo?acao=listar");
                    return;
                }

            }
            
        }
        
        chain.doFilter(request, response);  // invokes next filter in the chain
 
    }
    
    @Override
    public void destroy() {}
 
}
