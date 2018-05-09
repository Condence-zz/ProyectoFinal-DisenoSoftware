/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import excepciones.DAOException;
import hospital.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.*;
import baseDatos.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Nava_
 */
public class ControlUsuario {
    private String servidor = "localhost"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "197126"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    List nombresColumnasTablaUsuario = new ArrayList();
    
    public ControlUsuario() {
        //Llenar la lista con las columnas de la tabla
        nombresColumnasTablaUsuario.add("UsuarioID");
        nombresColumnasTablaUsuario.add("Nombre");
        nombresColumnasTablaUsuario.add("Apellido");
        nombresColumnasTablaUsuario.add("Password");
        nombresColumnasTablaUsuario.add("UserName"); 
    }
    
    public Usuario LoginUsuario(String username,String password){
        Usuario log = null;
        try{
            Connection conn = Conexion.getConexion(user,this.password, driver, servidor, baseDatos, puerto);
            Usuarios usuarios = new Usuarios(conn);
            log = usuarios.obtenerUsuario(username,password);
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
    public void agregaUsuario(Usuario usuario){
       try{
            Connection conn = Conexion.getConexion(user,password, driver, servidor, baseDatos, puerto);
            Usuarios usuarios = new Usuarios(conn);
            Statement a = conn.createStatement();
            a.executeUpdate("INSERT INTO dbo.Usuario(Nombre,Apellido,Password,UserName) values('"+usuario.getNombre()+"','"+
                  usuario.getApellido()+"','"+ usuario.getPassword()+"','"+usuario.getUsername()+"')");
            a.close();
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            throw new DAOException("No Se Pudo Agregar el Usuario,Intente Mas Tarde");
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
}
