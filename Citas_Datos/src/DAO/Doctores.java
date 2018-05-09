/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nava_
 */
public class Doctores extends RecordSet{
    private String nomTabla = "Doctor";
    
    public Doctores(Connection conn){
       super(conn); 
    }
    public void tablaDoctores(DefaultTableModel model) throws SQLException{
        String sql = "SELECT *"
                + "FROM "+nomTabla;
        llenarTablaDoctores(sql, model);
    }
    
    public void tablaDoctoresCorta(DefaultTableModel model) throws SQLException{
        String sql = "SELECT DoctorID,Nombre+' '+Apellido,Especialidad " +"FROM "+nomTabla;
        llenarTablaDoctoresCorta(sql, model);
    }
}
