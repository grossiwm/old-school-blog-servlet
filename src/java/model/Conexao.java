/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author gabriel
 */
public class Conexao extends HttpServlet {
    private static Connection conexao;
    
    public static Connection criaConexao() throws SQLException{
        
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver carregado.");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
                System.out.println("Conexão realizada com sucesso.");
                
            } catch(ClassNotFoundException e) {
                System.out.println("Driver não foi localizado");
            }
        }
        
        return conexao;
    }
    
}
