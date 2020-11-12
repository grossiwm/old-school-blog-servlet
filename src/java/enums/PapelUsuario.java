/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author gabriel
 */
public enum PapelUsuario {
    
    ADMINISTRADOR,
    AUTOR,
    COMENTARISTA;

    public int getValorInteiro() {
        return this.ordinal();
    }
    
    public static PapelUsuario getPapelUsuarioFromValorInteiro(int valorInteiro) {
        return PapelUsuario.values()[valorInteiro-1];
    }
    
}
