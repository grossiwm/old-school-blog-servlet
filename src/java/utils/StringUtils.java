/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author gabriel
 */
public class StringUtils {
    
    public static String formataCpf(String cpfNaoFormatado) {
        return cpfNaoFormatado.replaceAll("\\.|-", "");
    }
}
