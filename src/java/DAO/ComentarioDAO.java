/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author gabriel
 */
public class ComentarioDAO {
    
    private Connection conexao;
    
    public ComentarioDAO() throws SQLException {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
    
}
