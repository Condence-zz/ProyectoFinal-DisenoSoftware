/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.Citas;
import baseDatos.Conexion;
import excepciones.DAOException;
import hospital.Cita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nava_
 */
public class ControlCitas {

    private String servidor = "localhost"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "197126"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String[] arregloCombo = new String[32];

    public ControlCitas() {

    }
    
    public void agregarHora(Timestamp inico,Timestamp fin){
        try {
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Statement a = conn.createStatement();
            a.executeUpdate("INSERT INTO dbo.Horarios(FechaInicio,HoraFin,Duracion) "
                    + "values('"+ inico +"','"+fin+"',"+0+")");
            a.close();
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            throw new DAOException("No Se Pudo Agregar la Cita,Intente Mas Tarde");
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregaCita(Cita cita) { 
        try {
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Citas citas = new Citas(conn);
            Statement a = conn.createStatement(); 
            a.executeUpdate("INSERT INTO dbo.Citas(Comentario,DoctorID,Duracion,Fecha,PacienteID,Status,UsuarioID,Hora) "
                    + "values('" + cita.getComentario() + "'," + cita.getDoctorID() + "," + cita.getDuracion() + ",'" 
                    + cita.getFecha() + "',"+ cita.getPacienteID() + "," + 1 + "," + cita.getUsuarioID() +",'"+cita.getHora() +"')");
            a.close();
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            throw new DAOException("No Se Pudo Agregar la Cita,Intente Mas Tarde");
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getDuraciones(LocalDate fecha){
        LocalDate fecha1 = fecha;
        Date date = java.sql.Date.valueOf(fecha1); 
    
        int duracion = 0 ;
        try { 
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Citas citas = new Citas(conn);
            Statement a = conn.createStatement();
            ResultSet query = a.executeQuery("SELECT ISNULL(SUM(c.Duracion), 0) AS Duracion " 
                    + "FROM [dbo].[Citas] C " 
                    + "WHERE c.Fecha = '"+date+"'"); 
            while (query.next()) {
            int c = query.getInt(1);
            duracion = duracion + c;
          }
        } catch (Exception e) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
        }  
        return duracion;
    }  
    
     public void tablaCitasCancelar(DefaultTableModel model,int doctorID){
         java.sql.Date fecha = new Date(System.currentTimeMillis());
         
        try { 
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Citas citas = new Citas(conn);
            Statement a = conn.createStatement();
            ResultSet rs = a.executeQuery("SELECT c.CitaID,c.Fecha,p.Nombre+' '+p.Apellido,d.Nombre+' '+d.Apellido,d.Especialidad\n" +
                        "FROM dbo.Citas c INNER JOIN dbo.Doctor d ON d.DoctorID = c.DoctorID INNER JOIN dbo.Paciente p "
                      + "ON c.PacienteID = p.PacienteID"
                        + " WHERE c.DoctorID = "+doctorID+" AND c.Fecha >= '"+fecha.toString()+"' AND Status = "+1); 
            while (rs.next()) {
            String datos[] = new String[5];
            for (int i = 0; i < 5; i++) {
                datos[i] = rs.getString(i + 1);
            }
            model.addRow(datos);
            }
            conn.close();
            a.close();
        } catch (Exception e) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
        }  
    }
     
     
     public void cancelarCita(int CitaID){
         try { 
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Statement a = conn.createStatement();
            a.executeUpdate("UPDATE dbo.Citas SET Status = 0 WHERE CitaID = "+CitaID); 
            conn.close();
            a.close();
        } catch (Exception e) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, e);
        }  
     }
}
