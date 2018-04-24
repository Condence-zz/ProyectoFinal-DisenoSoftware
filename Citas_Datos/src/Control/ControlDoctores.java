package Control; 

import DAO.Doctores;
import DAO.Pacientes;
import baseDatos.conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlDoctores {
    private String servidor = "DESKTOP-3H3CLH5"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "itson"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    List nombresColumnasTablaDoctores = new ArrayList<String>();
    public ControlDoctores() {
        //Llenar la lista con las columnas de la tabla
        nombresColumnasTablaDoctores.add("PacienteID");
        nombresColumnasTablaDoctores.add("Nombre");
        nombresColumnasTablaDoctores.add("Apellido");
        nombresColumnasTablaDoctores.add("Especialidad");
        nombresColumnasTablaDoctores.add("Direccion");
        nombresColumnasTablaDoctores.add("Telefono"); 
    }
    public void llenaTablaDoctores(JFrame frame,DefaultTableModel model){
        try{
            Connection conn = conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
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
}
