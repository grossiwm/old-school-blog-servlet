/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.ArtigoDAO;
import DTO.ArtigoDTO;
import java.util.ArrayList;
import java.util.List;
import model.Artigo;

/**
 *
 * @author gabriel
 */
public class ArtigoBO {
    
    private ArtigoDAO artigoDAO;
    
    public ArtigoBO() {
        artigoDAO = new ArtigoDAO();
    }
    
    public void criaArtigo(Artigo artigo) {
        artigoDAO.save(artigo);
    }
    
    public List<ArtigoDTO> getArtigosPublicos() {
        return artigoDAO.getArtigoDTOsByLiberarAndAprovado('S', 'S');
    }
    
    public ArtigoDTO getArtigoById(int id) {
        return artigoDAO.getArtigoDTOById(id);
    }
    
    public List<ArtigoDTO> getArtigoDTOByUsuarioID(int id) {
        return artigoDAO.getArtigoDTOsByUsuarioID(id);
    }
    
    public void liberarArtigo(int id) {
        artigoDAO.setLiberarArtigoById("S", id);
    }
    
    public void tornarArtigoNaoLiberado(int id) {
        artigoDAO.setLiberarArtigoById("N", id);
    }
    
    public void aprovarArtigo(int id) {
        artigoDAO.setAprovadoArtigoById("S", id);
    }
    
    public List<ArtigoDTO> getArtigoDTOsNaoAprovadosEliberados() {
        return artigoDAO.getArtigoDTOsByAprovadoAndLiberar('N', 'S');
    }    
    
}
