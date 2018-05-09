/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import hospital.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nava_
 */
public class Usuarios extends RecordSet{
    private String nomTabla = "Usuario";
    
    public Usuarios(Connection conn) {
        super(conn);
    }
    
    public Usuario obtenerUsuario (String username,String password) throws SQLException, NullPointerException{
       ResultSet rs;
       NullPointerException npe = new NullPointerException();
       String sql = "SELECT * FROM "+nomTabla+" WHERE UserName = '"+username+"' AND Password = '"+password+"'";
        executeSelect(sql);
       //Si hay un renglón en la tabla con el producto deseado
       if((rs = readNext())!= null){
           Usuario usuario = new Usuario(rs.getInt("UsuarioID"),
                                         rs.getString("Nombre"),
                                         rs.getString("Apellido"),  
                                         rs.getString("Password"),
                                         rs.getString("UserName"));
           return usuario;
       }
       throw npe;
   }
    
    public void agregarUsuario(Usuario usuario)throws SQLException{
         String sql = "";   
         //Crea la sentencia con la llamada al SP
         sql = "{ CALL sp_insertarUsuarios(?,?,?,?,?) }";
         //Ejecuta el procedimiento almacenado
         sp_insertarUsuarios(sql,usuario.getNombre(), usuario.getApellido(), usuario.getPassword(), usuario.getUsername());

    }
    
   
    
}
