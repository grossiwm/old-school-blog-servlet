/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import application.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author gabriel
 */
public class UsuarioDAO extends HttpServlet {
    
    private Connection conexao;
    
    public UsuarioDAO() {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
    
    public Usuario find(Integer id) {
        
        Usuario usuario = null;
        
        try {
            String sql = "select u.* from usuario u where id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                    usuario = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public Usuario findByCpf(String cpf) {
        
        Usuario usuario = null;

        try {
            String sql = "select u.* from usuario u where REPLACE(REPLACE(cpf, '.', ''), '-', '') = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = map(rs);
            }
            } catch(SQLException e) {
                e.printStackTrace();
            }

        return usuario;
}
    

public List<Usuario> findUsuariosByCadastroAprovado(char letra) {

    List<Usuario> usuarios = null;
    
    try {
        PreparedStatement pst;
        String sql = "select u.* from usuario u where cadastro_aprovado = ?";
        pst = conexao.prepareStatement(sql);
        pst.setString(1, String.valueOf(letra));
        ResultSet rs = pst.executeQuery();
        usuarios = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = map(rs);
            usuarios.add(usuario);
        } 
    } catch(SQLException e) {
        e.printStackTrace();
    }
    
    return usuarios;
}    
    

    

public void save(Usuario entity) {
        try {
            String insert_sql = "insert into usuario (cadastro_aprovado, cpf, email, nome, papel, senha) values (?, ?, ?, ?, ?, ?)";
            String update_sql = "update usuario set cadastro_aprovado = ?, cpf = ?, email = ?, nome = ?, papel = ? , senha = ? where id = ?";
            PreparedStatement pst;
            if (entity.getId() == 0) {
                    pst = conexao.prepareStatement(insert_sql);
            } else {
                    pst = conexao.prepareStatement(update_sql);
                    pst.setInt(7, entity.getId());
            }
            
            pst.setString(1, String.valueOf(entity.getCadastroAprovado()));
            pst.setString(2, entity.getCpf());
            pst.setString(3, entity.getEmail());
            pst.setString(4, entity.getNome());
            pst.setInt(5, entity.getPapel());
            pst.setString(6, entity.getSenha());
            
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        
        try {
            String sql = "delete from usuario where id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private Usuario map(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setCpf(rs.getString("cpf"));
        usuario.setEmail(rs.getString("email"));
        usuario.setNome(rs.getString("nome"));
        usuario.setPapel(rs.getInt("papel"));
        usuario.setSenha(rs.getString("senha"));

        return usuario;
    }
    
}
