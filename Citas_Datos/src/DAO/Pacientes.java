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
    public Paciente obtenerProducto(String nombre) throws SQLException, NullPointerException{
        ResultSet rs;
        NullPointerException npe = new NullPointerException(); 
        String sql = "SELECT * FROM "+nomTabla+" WHERE ProductName = '"+nombre+"'"; 
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
    public void agregarProducto(Paciente paciente)throws SQLException{
         String sql = "";   
         //Crea la sentencia con la llamada al SP
         sql = "{ CALL sp_insertarProductos(?,?,?,?,?,?) }";
         //Ejecuta el procedimiento almacenado
         sp_insertarPaciente(sql,paciente.getPacienteID(), paciente.getNombre(), paciente.getApellido(), paciente.getDireccion(), paciente.getTelefono());

    }
    public void tablaProductos(DefaultTableModel model) throws SQLException{
        String sql = "SELECT *"
                + "FROM Paciente P";
        llenarTabla(sql, model);
    }
}
