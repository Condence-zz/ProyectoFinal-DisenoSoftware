package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

class RecordSet {

    // Conexión con la base de datos */
    private Connection conn;
    // Sentencia SQL que se le envia al manejador de la base de datos para
    // consultar, insertar, actualizar, borrar.
    private Statement stmt;
    // Respuesta del manejador de la base de datos a la sentencia SQL.
    private ResultSet rs;
    //Sentencia que se le envía al manejador de la base de datos para ejecutar un SP
    private CallableStatement cst;

    public RecordSet(Connection conn) {
        this.conn = conn;
    }

    public void executeSelect(String sql) throws SQLException {
        // Crea una sentencia para hacer la consulta
        stmt = conn.createStatement();

        rs = stmt.executeQuery(sql);
    }

    public ResultSet readNext() throws SQLException {
        // Si hay otro renglon en la tabla, regrésalo.
        if (rs.next()) {
            return rs;
        } // Si no, cierra la sentencia, la tabla y regresa null.
        else {
            // Cierra la sentencia y la tabla y regresa null.
            rs.close();
            stmt.close();
            return null;
        }
    }

    public void executeUpdate(String sql) throws SQLException {
        // Crea una sentencia para hacer la modificación.
        stmt = conn.createStatement();

        // Ejecuta la modificación.
        int i = stmt.executeUpdate(sql);

        // Cierra la sentencia y la tabla.
        stmt.close();
    }

    public void sp_insertarPaciente(String sql, int PacienteID, String Nombre, String Apellido,
            String Direccion, String Telefono) throws SQLException {

        cst = conn.prepareCall(sql);
        //Agregar parámetros
        cst.setInt(1, PacienteID);
        cst.setString(2, Nombre);
        cst.setString(3, Apellido);
        cst.setString(4, Direccion);
        cst.setString(5, Telefono);
        //Ejecuta el SP
        cst.execute();
        cst.close();
    }

    public void sp_insertarUsuarios(String sql, String Nombre, String Apellido,
            String password, String username) throws SQLException {

        cst = conn.prepareCall(sql);
        cst.setString(2, Nombre);
        cst.setString(3, Apellido);
        cst.setString(4, password);
        cst.setString(5, username);

        cst.execute();
        cst.close();
    }

    public void llenarTabla(String sql, DefaultTableModel model) throws SQLException {
        cst = conn.prepareCall(sql);
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            String datos[] = new String[10];
            for (int i = 0; i < 5; i++) {
                datos[i] = rs.getString(i + 1);
            }
            model.addRow(datos);
        }
        cst.close();
        conn.close();
    }
    
    public void llenarTablaDoctores(String sql, DefaultTableModel model) throws SQLException {
        cst = conn.prepareCall(sql);
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            String datos[] = new String[6];
            for (int i = 0; i < 6; i++) {
                datos[i] = rs.getString(i + 1);
            }
            model.addRow(datos);
        }
        cst.close();
        conn.close();
    }
    
    public void llenarTablaDoctoresCorta(String sql, DefaultTableModel model) throws SQLException {
        cst = conn.prepareCall(sql);
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            String datos[] = new String[3];
            for (int i = 0; i < 3; i++) {
                datos[i] = rs.getString(i+1);
            }
            model.addRow(datos);
        }
        cst.close();
        conn.close();
    }
}
