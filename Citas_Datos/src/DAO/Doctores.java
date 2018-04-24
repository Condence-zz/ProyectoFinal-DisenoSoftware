package DAO; 

import hospital.Doctor; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Doctores extends RecordSet { 
    private String nomTabla = "Doctor";
    public Doctores(Connection conn) {
        super(conn);
    }
    public Doctor obtenerDoctor(int DoctorID) throws SQLException, NullPointerException{
        ResultSet rs;
        NullPointerException npe = new NullPointerException(); 
        String sql = "SELECT * FROM "+nomTabla+" WHERE DoctorID = '"+DoctorID+"'"; 
        executeSelect(sql); 
        if((rs = readNext())!= null){ 
            Doctor doctor = new Doctor(rs.getInt("DoctorID"),
                                             rs.getString("nombre"),
                                             rs.getString("apellido"),
                                             rs.getString("especialidad"),
                                             rs.getString("direccion"),
                                             rs.getString("telefono"));
            return doctor;
        }
        throw npe;
    }
    public void agregarDoctor(Doctor doctor)throws SQLException{
         String sql = "";   
         //Crea la sentencia con la llamada al SP
         sql = "{ CALL sp_insertarDoctor(?,?,?,?,?) }";
         //Ejecuta el procedimiento almacenado
         sp_insertarDoctor(sql,doctor.getNombre(), doctor.getApellido(),doctor.getEspecialidad(),doctor.getDireccion(), doctor.getTelefono());

    }
    public void tablaDoctores(DefaultTableModel model) throws SQLException{
        String sql = "SELECT *"
                + "FROM Doctor d";
        llenarTablaDoctores(sql, model);
    }
    public void eliminarDoctor (int DoctorID) throws SQLException{
        String sql = "";
        //Crea la sentencia para borrar
        sql += "DELETE FROM "+nomTabla;
        sql += " WHERE DoctorID = '"+DoctorID+"'";
        //Ejecuta la sentencia
        executeUpdate(sql);
    }
    public void actualizarDoctor(Doctor doctor) throws SQLException {
        String sql="";
         
        //Crea la sentencia con la llamada al SP 
        sql = "{ CALL sp_actualizarDoctor(?,?,?,?,?,?) }";
        //Ejecuta el procedimiento almacenado 
        sp_actualizarDoctor(sql,doctor.getDoctorID(),doctor.getNombre(), doctor.getApellido(),doctor.getEspecialidad(),doctor.getDireccion(), doctor.getTelefono());
    }
}
