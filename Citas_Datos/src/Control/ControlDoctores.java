/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.Doctores;
import DAO.Pacientes;
import baseDatos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nava_
 */
public class ControlDoctores {
    private String servidor = "localhost"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "197126"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    List nombresColumnasTablaProducts = new ArrayList();
    
    public ControlDoctores(){
        //Llenar la lista con las columnas de la tabla
        nombresColumnasTablaProducts.add("DoctorID");
        nombresColumnasTablaProducts.add("Nombre");
        nombresColumnasTablaProducts.add("Apellido");
        nombresColumnasTablaProducts.add("Especialidad");
        nombresColumnasTablaProducts.add("Direccion");
        nombresColumnasTablaProducts.add("Telefono"); 
    }
    
    public void llenaTablaDoctores(JFrame frame,DefaultTableModel model){
        try{
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Doctores doctores = new Doctores(conn);
            try{
                doctores.tablaDoctores(model);        
            } catch(SQLException e){
                JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenaTablaDoctores4(JFrame frame,DefaultTableModel model){
        try{
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Doctores doctores = new Doctores(conn);
            doctores.tablaDoctoresCorta(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
