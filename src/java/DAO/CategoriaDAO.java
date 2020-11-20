/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author gabriel
 */
public class CategoriaDAO {
    
    private Connection conexao;
    
    public CategoriaDAO() {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
    
    public List<Categoria> findAll() {
        
        List<Categoria> categorias = null;
        
        try {
            
            String sql = "select c.* from categoria c";
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            categorias = new ArrayList<Categoria>();
            
            while (rs.next()) {
                Categoria categoria = map(rs);
                categorias.add(categoria);
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }
    
    private Categoria map(ResultSet rs) throws SQLException {
        
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id"));
        categoria.setDescricao(rs.getString("descricao"));

        return categoria;
    }
    
}
