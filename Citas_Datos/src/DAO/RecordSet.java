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

    // Ejecuta la consulta. El método executeQuery() regresa una tabla
    // que genera como resultado de la consulta
    rs = stmt.executeQuery(sql);
 } 
 public ResultSet readNext() throws SQLException {
    // Si hay otro renglon en la tabla, regrésalo.
    if(rs.next()) return rs;
    // Si no, cierra la sentencia, la tabla y regresa null.
    else
    {
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
  public void sp_insertarProducto (String sql, int PacienteID, String Nombre, String Apellido,
            String Direccion, String Telefono) throws SQLException {
  
      cst = conn.prepareCall(sql);
      //Agregar parámetros
      cst.setInt(1,PacienteID);
      cst.setString(2, Nombre);
      cst.setString(3, Apellido);
      cst.setString(4, Direccion);
      cst.setString(5, Telefono); 
      //Ejecuta el SP
      cst.execute();
      cst.close();
  } 
  public void sp_actualizarProducto(String sql, int ProductID, String ProductName, int SupplierID, int CategoryID,
          String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel,
          boolean Discontinued) throws SQLException{
      //Crea una sentencia para llamar el SP
      cst = conn.prepareCall(sql);
      //Agregar parámetros
      cst.setInt(1, ProductID);
      cst.setString(2, ProductName);
      cst.setInt(3, SupplierID);
      cst.setInt(4, CategoryID);
      cst.setString(5, QuantityPerUnit);
      cst.setDouble(6, UnitPrice);
      cst.setInt(7, UnitsInStock);
      cst.setInt(8, UnitsOnOrder);
      cst.setInt(9, ReorderLevel);
      cst.setBoolean(10, Discontinued);
      //Ejecutar el SP
      cst.execute();
      cst.close();
  } 
  public void llenarTabla(String sql,DefaultTableModel model)throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      
      while(rs.next()){
          String datos [] = new String[10];
          for (int i = 0; i < 5; i++) {
               datos[i]=rs.getString(i+1);
          }
          model.addRow(datos);
      }
      cst.close();
      conn.close();
  }
  public void obtenerProveedores(String sql, String proveedores[]) throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      int contador = 0;
      while(rs.next()){
          proveedores[contador]=rs.getString("CompanyName");
          contador++;
      }
  } 
  public void obtenerProveedores(String sql, int proveedores[]) throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      int contador = 0;
      while(rs.next()){
          proveedores[contador]=rs.getInt("SupplierID");
          contador++;
      }
  } 
  public void obtenerCategorias (String sql, String categorias[])throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      int contador = 0;
      while(rs.next()){
          categorias [contador] = rs.getString("CategoryName");
          contador++;
      }
  } 
  public void obtenerCategorias (String sql, int categorias[])throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      int contador = 0;
      while(rs.next()){
          categorias [contador] = rs.getInt("CategoryID");
          contador++;
      }
  } 
  public void obtenerProveedorNombre (String sql, int id, String proveedor) throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      while(rs.next()){
          proveedor = rs.getString("CompanyName");
      }
  } 
  public void obtenerProveedorID (String sql, int id, String proveedor) throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      while(rs.next()){
          id = rs.getInt("SupplierID");
      }
  } 
  public void obtenerCategoriaNombre(String sql, int id, String categoria) throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      while(rs.next()){
          categoria = rs.getString("CategoryName");
      }
  } 
  public void obtenerCategoriaID(String sql, int id, String categoria)throws SQLException{
      cst = conn.prepareCall(sql);
      ResultSet rs = cst.executeQuery();
      while (rs.next()){
          id = rs.getInt("CategoryID");
      }
  }
}