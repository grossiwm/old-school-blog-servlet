/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author gabriel
 */
public class ArtigoDAO extends HttpServlet {
    
    private Connection conexao;
    
    public ArtigoDAO() throws SQLException {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
}
