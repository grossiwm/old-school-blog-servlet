/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.CategoriaDAO;
import java.util.List;
import model.Categoria;

/**
 *
 * @author gabriel
 */
public class CategoriaBO {
    
    private CategoriaDAO categoriaDAO;
    
    public CategoriaBO() {
        categoriaDAO = new CategoriaDAO();
    }
    
    public List<Categoria> getTodasCategorias() {
        return categoriaDAO.findAll();
    }
    
}
