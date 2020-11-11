/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("jsp/login.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cpf = request.getParameter("cpf").replaceAll("\\.|-", "");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            Usuario usuario = usuarioDAO.findByCpf(cpf);
            
            if (usuario != null && usuario.getSenha().equals(senha)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
            } else {
                
                List<String> erros = new ArrayList();
                erros.add("Não pôde autenticar.");
                request.setAttribute("erros", erros);
                
                request.setAttribute("temErros", true);
                RequestDispatcher view = request.getRequestDispatcher("jsp/login.jsp");
                view.forward(request, response);
                
            }
        
            
    }
}
