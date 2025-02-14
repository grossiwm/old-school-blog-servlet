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
@WebFilter(urlPatterns = "/usuario")
public class UsuarioFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        
        String acao = httpRequest.getParameter("acao");
        
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        
        if (!Objects.isNull(usuarioLogado)) {
            
            PapelUsuario papelUsuario = PapelUsuario.getPapelUsuarioFromValorInteiro(usuarioLogado.getPapel());
            
            
            
            if (!(acao.equals("logout") )) {
                
                if (!papelUsuario.equals(PapelUsuario.ADMINISTRADOR)) {
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.sendRedirect("artigo?acao=listar");
                    return;
                }
            }
        } else {
            
            if (!(acao.equals("solicitar") )) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("login");
                return;
            }

        }
            

        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {}
}
