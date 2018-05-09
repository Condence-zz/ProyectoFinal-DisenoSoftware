package Control; 

import DAO.Pacientes;
import DAO.Usuarios;
import baseDatos.Conexion;
import excepciones.DAOException;
import hospital.Paciente;
import hospital.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlPacientes {
    private String servidor = "localhost"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "197126"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    List nombresColumnasTablaProducts = new ArrayList();
    public ControlPacientes() {
        //Llenar la lista con las columnas de la tabla
        nombresColumnasTablaProducts.add("PacienteID");
        nombresColumnasTablaProducts.add("Nombre");
        nombresColumnasTablaProducts.add("Apellido");
        nombresColumnasTablaProducts.add("Direccion");
        nombresColumnasTablaProducts.add("Telefono"); 
    }
    public void llenaTablaPacientes(JFrame frame,DefaultTableModel model){
        try{
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
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
    
    public void agregaPaciente(Paciente paciente){
       try{
            Connection conn = Conexion.getConexion(user,password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            Statement a = conn.createStatement();
            a.executeUpdate("INSERT INTO dbo.Paciente(Nombre,Apellido,Direccion,Telefono) values('"+paciente.getNombre()+"','"+
                  paciente.getApellido()+"','"+ paciente.getDireccion()+"','"+paciente.getTelefono()+"')");
            a.close();
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            throw new DAOException("No Se Pudo Agregar el Usuario,Intente Mas Tarde");
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
    public void eliminaPacientes(JFrame frame, Paciente paciente){
        StringBuffer respuesta = new StringBuffer("");
        if(paciente == null) return;
        
        try{
            Connection conn = Conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            try{
                paciente = pacientes.obtenerPaciente(paciente.getPacienteID());
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
    public Paciente verificarNombre(String nombrePaciente,String apellido){
        Paciente log = null;
        try{
            Connection conn = Conexion.getConexion(user,this.password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            log = pacientes.obtenerPaciente(nombrePaciente,apellido);
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }  
    public Paciente verificarID(int id){
        Paciente log = null;
        try{
            Connection conn = Conexion.getConexion(user,this.password, driver, servidor, baseDatos, puerto);
            Pacientes pacientes = new Pacientes(conn);
            log = pacientes.obtenerPaciente(id);
            conn.close();
        } catch (SQLException | NullPointerException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
}
