/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author gabriel
 */
public class LoginException extends Exception {
    
    public LoginException(String mensagem) {
        super(mensagem);
    }
}
