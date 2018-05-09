/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import hospital.Paciente; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class Pacientes extends RecordSet { 
    private String nomTabla = "Paciente";
    
    public Pacientes(Connection conn) {
        super(conn);
    }
    
    public Paciente obtenerPaciente(int PacienteID) throws SQLException, NullPointerException{
        ResultSet rs;
        NullPointerException npe = new NullPointerException(); 
        String sql = "SELECT * FROM "+nomTabla+" WHERE PacienteID = '"+PacienteID+"'"; 
        executeSelect(sql); 
        if((rs = readNext())!= null){ 
            Paciente paciente = new Paciente(rs.getInt("PacienteID"),
                                             rs.getString("nombre"),
                                             rs.getString("apellido"),
                                             rs.getString("direccion"),
                                             rs.getString("telefono"));
            return paciente;
        }
        throw npe;
    }
    
    public Paciente obtenerPaciente(String nombrePaciente,String apellido) throws SQLException, NullPointerException{
        ResultSet rs;
        NullPointerException npe = new NullPointerException(); 
        String sql = "SELECT * FROM "+nomTabla+" WHERE Nombre = '"+nombrePaciente+"' AND "+"Apellido = '"+apellido+"'"; 
        executeSelect(sql); 
        if((rs = readNext())!= null){ 
            Paciente paciente = new Paciente(rs.getInt("PacienteID"),
                                             rs.getString("nombre"),
                                             rs.getString("apellido"),
                                             rs.getString("direccion"),
                                             rs.getString("telefono"));
            return paciente;
        }
        throw npe;
    }
    
    public void agregarPaciente(Paciente paciente)throws SQLException{
         String sql = "";   
         //Crea la sentencia con la llamada al SP
         sql = "{ CALL sp_insertarPaciente(?,?,?,?,?) }";
         //Ejecuta el procedimiento almacenado
         sp_insertarPaciente(sql,paciente.getPacienteID(), paciente.getNombre(), paciente.getApellido(), paciente.getDireccion(), paciente.getTelefono());

    }
    
    public void tablaProductos(DefaultTableModel model) throws SQLException{
        String sql = "SELECT *"
                + "FROM Paciente P";
        llenarTabla(sql, model);
    }
   
    public void eliminarProducto (int PacienteID) throws SQLException{
       String sql = "";
       //Crea la sentencia para borrar
       sql += "DELETE FROM "+nomTabla;
       sql += " WHERE PacienteID = '"+PacienteID+"'";
       //Ejecuta la sentencia
       executeUpdate(sql);
   }
}
