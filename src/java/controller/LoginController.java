/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.LoginBO;

/**
 *
 * @author gabriel
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
    
    private LoginBO loginBO;
    
    @Override
    public void init() throws ServletException {
        loginBO = new LoginBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher view = request.getRequestDispatcher("jsp/login.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        LoginBO loginBO = new LoginBO();
        
        if (loginBO.autenticaUsuario(request)) {
            sucessoHandle(request, response);
        } else {
           erroHandle(request, response);
        }
            
    }
    
    private void sucessoHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        response.sendRedirect("usuario?acao=solicitacoes");
        
    }
    
    private void erroHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<String> erros = new ArrayList();
        erros.add("Não pôde autenticar.");
        request.setAttribute("erros", erros);
        request.setAttribute("temErros", true);
        RequestDispatcher view = request.getRequestDispatcher("jsp/login.jsp");
        view.forward(request, response);
        
    }
    
}
