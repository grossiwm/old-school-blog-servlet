/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ArtigoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Artigo;

/**
 *
 * @author gabriel
 */
public class ArtigoDAO {
    
    private Connection conexao;
    
    public ArtigoDAO() {
            
        try {
            
            conexao = Conexao.criaConexao();
            
        } catch(Exception e) {
            System.out.println("Erro na criação de conexão DAO");
        }
    }
    
    public ArtigoDTO getArtigoDTOById(int id) {
        
        ArtigoDTO artigo = null;
        
        try {
            PreparedStatement pst;
            String sql = "select distinct a.id as id, a.titulo, a.conteudo, c.descricao as categoria, u.nome as usuario "
                    + "from artigo a inner join usuario u on u.id = a.id_usuario inner join categoria c on c.id = a.id_categoria"
                    + " where a.id = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            artigo = new ArtigoDTO();
            
            if (rs.next()) {
                artigo.setId(rs.getInt("id"));
                artigo.setAutor(rs.getString("usuario"));
                artigo.setCategoria(rs.getString("categoria"));
                artigo.setConteudo(rs.getString("conteudo"));
                artigo.setTitulo(rs.getString("titulo"));
            }
                
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return artigo;
    }
    
    public List<ArtigoDTO> getArtigoDTOsByLiberarAndAprovado(char liberar, char aprovado) {
        
        List<ArtigoDTO> artigos = null;

        try {
            PreparedStatement pst;
            String sql = "select distinct a.id as id, a.titulo, a.conteudo, c.descricao as categoria, u.nome as usuario from artigo a inner join usuario u on u.id = a.id_usuario inner join categoria c on c.id = a.id_categoria"
                    + " where aprovado = ? and liberar = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, String.valueOf(aprovado));
            pst.setString(2, String.valueOf(liberar));

            ResultSet rs = pst.executeQuery();
            artigos = new ArrayList<ArtigoDTO>();
            while (rs.next()) {
                ArtigoDTO artigo = new ArtigoDTO();
                artigo.setId(rs.getInt("id"));
                artigo.setAutor(rs.getString("usuario"));
                artigo.setCategoria(rs.getString("categoria"));
                artigo.setConteudo(rs.getString("conteudo"));
                artigo.setTitulo(rs.getString("titulo"));
                artigos.add(artigo);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return artigos;
    }
    
        public List<ArtigoDTO> getArtigoDTOsByUsuarioID(int usuarioId) {
        
        List<ArtigoDTO> artigos = null;

        try {
            PreparedStatement pst;
            String sql = "select distinct a.id as id, a.titulo, a.conteudo, c.descricao as categoria, u.nome as usuario, a.aprovado, a.liberar as liberado from artigo a inner join usuario u on u.id = a.id_usuario inner join categoria c on c.id = a.id_categoria"
                    + " where u.id = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, String.valueOf(usuarioId));

            ResultSet rs = pst.executeQuery();
            artigos = new ArrayList<ArtigoDTO>();
            while (rs.next()) {
                ArtigoDTO artigo = new ArtigoDTO();
                artigo.setId(rs.getInt("id"));
                artigo.setAutor(rs.getString("usuario"));
                artigo.setCategoria(rs.getString("categoria"));
                artigo.setConteudo(rs.getString("conteudo"));
                artigo.setTitulo(rs.getString("titulo"));
                artigo.setAprovado(rs.getString("aprovado"));
                artigo.setLiberado(rs.getString("liberado"));
                artigos.add(artigo);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return artigos;
    }
    
    
    public List<Artigo> findAllByUsuarioId(int usuarioId) {
        
        List<Artigo> artigos = null;

        try {
            PreparedStatement pst;
            String sql = "select a.* from artigo a where usuarioId = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, String.valueOf(usuarioId));
            ResultSet rs = pst.executeQuery();
            artigos = new ArrayList<Artigo>();
            while (rs.next()) {
                Artigo artigo = map(rs);
                artigos.add(artigo);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return artigos;
    }
    
    public void save(Artigo entity) {
        try {
            String insert_sql = "insert into artigo (id_usuario, id_categoria, titulo, conteudo, liberar, aprovado) values (?, ?, ?, ?, ?, ?)";
            String update_sql = "update artigo set id_usuario = ?, id_categoria = ?, titulo = ?, conteudo = ?, liberar = ? , aprovado = ? where id = ?";
            PreparedStatement pst;
            if (entity.getId() == 0) {
                    pst = conexao.prepareStatement(insert_sql);
            } else {
                    pst = conexao.prepareStatement(update_sql);
                    pst.setInt(7, entity.getId());
            }
            
            pst.setInt(1, entity.getIdUsuario());
            pst.setInt(2, entity.getIdCategoria());
            pst.setString(3, entity.getTitulo());
            pst.setString(4, entity.getConteudo());
            pst.setString(5, String.valueOf(entity.getLiberar()));
            pst.setString(6, String.valueOf(entity.getAprovado()));
            
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        
        try {
            String sql = "delete from artigo where id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void setLiberarArtigoById(String liberar, int id) {
        try {
            String sql = "update artigo set liberar = ? where id = ?";
            
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(2, id);
            pst.setString(1, liberar);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Artigo map(ResultSet rs) throws SQLException {
        Artigo artigo = new Artigo();
        artigo.setId(rs.getInt("id"));
        artigo.setIdCategoria(rs.getInt("id_categoria"));
        artigo.setIdUsuario(rs.getInt("id_usuario"));
        artigo.setTitulo(rs.getString("titulo"));
        artigo.setConteudo(rs.getString("conteudo"));
        artigo.setLiberar(rs.getString("liberar").charAt(0));
        artigo.setAprovado(rs.getString("aprovado").charAt(0));
        return artigo;
    }
    
    
    
}
