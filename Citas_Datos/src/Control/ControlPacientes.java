package Control; 

import DAO.Pacientes;
import baseDatos.conexion;
import hospital.Paciente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlPacientes {
    private String servidor = "DESKTOP-3H3CLH5"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "itson"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    List nombresColumnasTablaProducts = new ArrayList<String>();
    public ControlPacientes() {
        //Llenar la lista con las columnas de la tabla
        nombresColumnasTablaProducts.add("PacienteID");
        nombresColumnasTablaProducts.add("Nombre");
        nombresColumnasTablaProducts.add("Apellido");
        nombresColumnasTablaProducts.add("Direccion");
        nombresColumnasTablaProducts.add("Telefono"); 
    }
    public void llenaTablaProductos(JFrame frame,DefaultTableModel model){
        try{
            Connection conn = conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            try{
                pacientes.tablaProductos(model);
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void agregaProducto(JFrame frame){
        System.out.println(frame); 
    }
    public void eliminaProducto(JFrame frame, Paciente paciente){
        StringBuffer respuesta = new StringBuffer("");
        if(paciente == null) return;
        
        try{
            Connection conn = conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            try{
                paciente = pacientes.obtenerProducto(paciente.getPacienteID());
                if(paciente==null){
                    JOptionPane.showMessageDialog(frame, "El producto no se encuentra en la base de datos", 
                            "ERROR!!!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(JOptionPane.showConfirmDialog(frame, "¿Está seguro que desea eliminar este producto?", 
                        "Eliminar Producto", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    pacientes.eliminarProducto(paciente.getPacienteID());
                }else{
                    return;
                }
            
            }
                catch (SQLException e){
                JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            catch(NullPointerException npe){
                JOptionPane.showMessageDialog(frame, "El producto no existe","ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
