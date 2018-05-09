/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Nava_
 */
public class DAOException extends RuntimeException{
    
    public DAOException(String message){
        super(message);
    }
    
    public DAOException(){
        
    }
}
