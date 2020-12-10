/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.ComentarioDAO;
import DTO.ComentarioDTO;
import java.util.List;
import model.Comentario;

/**
 *
 * @author gabriel
 */
public class ComentarioBO {
    
    private ComentarioDAO comentarioDAO;
    
    public ComentarioBO() {
        comentarioDAO = new ComentarioDAO();
    }
    
    public List<ComentarioDTO> getComentariosPorArtigo(int artigoId) {
        List<ComentarioDTO> comentarios = comentarioDAO.getComentariosDTOByArtigo(artigoId);
        return comentarios;
    }
    
    public void criaComentario(Comentario comentario) {
        comentarioDAO.save(comentario);
    }
    
    public void deletarComentario(int id) {
        comentarioDAO.delete(id);
    }
    
}
