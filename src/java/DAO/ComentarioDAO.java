/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ComentarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comentario;

/**
 *
 * @author gabriel
 */
public class ComentarioDAO {
    
    private Connection conexao;
    
    public ComentarioDAO() {
        
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
    
    public void save(Comentario entity) {
        try {
            String insert_sql = "insert into comentario (comentario, id_artigo, id_usuario) values (?, ?, ?)";
            String update_sql = "update comentario set comentario = ?, id_artigo = ?, id_usuario = ? where id = ?";
            PreparedStatement pst;
                if (entity.getId() == 0) {
                        pst = conexao.prepareStatement(insert_sql);
                } else {
                        pst = conexao.prepareStatement(update_sql);
                        pst.setInt(4, entity.getId());
                }

            pst.setString(1, entity.getComentario());
            pst.setInt(2, entity.getIdArtigo());
            pst.setInt(3, entity.getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public List<ComentarioDTO> getComentariosDTOByArtigo(int artigoId) {

        List<ComentarioDTO> comentarios = null;

        try {

            String sql = "select c.id, u.nome as autor, c.comentario, u.id as autor_id from comentario c inner join artigo a on a.id = c.id_artigo inner join usuario u on u.id = c.id_usuario where a.id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, artigoId);

            ResultSet rs = pst.executeQuery();
            comentarios = new ArrayList<>();

            while (rs.next()) {
                ComentarioDTO comentario = new ComentarioDTO();
                comentario.setId(rs.getInt("id"));
                comentario.setAutor(rs.getString("autor"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setAutorId(rs.getInt("autor_id"));
                comentarios.add(comentario);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return comentarios;
    }
    
    public void delete(int id) {
        try {
            String sql = "delete from comentario where id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
}
