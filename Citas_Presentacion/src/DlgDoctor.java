
import DAO.Doctores;
import baseDatos.conexion;
import hospital.Doctor;  
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class DlgDoctor extends javax.swing.JFrame {
    private int operacion=0;
    private String servidor = "DESKTOP-3H3CLH5"; //Nombre del servidor 
    private String puerto = "1433"; //IP
    private String user = "sa"; //usuario loggin SQL Server
    private String password = "itson"; //Contraseña
    private String baseDatos = "Citas"; //Nombre de la base de datos
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public DlgDoctor() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.DoctorID.setText("");
        this.Nombre.setText("");
        this.Apellido.setText("");
        this.Especialidad.setText("");
        this.Direccion.setText("");
        this.Telefono.setText(""); 
        this.DoctorID.setEditable(false); 
        this.DoctorID.setBackground(Color.gray); 
        
    }
    public DlgDoctor(Doctor doctor, int operacion) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.DoctorID.setEditable(false); 
        this.DoctorID.setBackground(Color.gray); 
        this.operacion=operacion;
        
        if(this.operacion==ConstantesGUI.AGREGAR)
            botonAceptar.setText("Agregar");
        else if(this.operacion==ConstantesGUI.ACTUALIZAR)
            botonAceptar.setText("Actualizar");
        if(this.operacion == ConstantesGUI.ACTUALIZAR)   {
            this.DoctorID.setText(Integer.toString(doctor.getDoctorID()));
            this.Nombre.setText(doctor.getNombre());
            this.Apellido.setText(doctor.getApellido());
            this.Especialidad.setText(doctor.getEspecialidad());
            this.Direccion.setText(doctor.getDireccion());
            this.Telefono.setText(doctor.getTelefono());
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        DoctorID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Especialidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Doctor ID:");

        DoctorID.setText("jTextField1");

        jLabel2.setText("Nombre:");

        Nombre.setText("jTextField2");

        jLabel3.setText("Apellido:");

        Apellido.setText("jTextField3");

        jLabel4.setText("Especialidad:");

        Especialidad.setText("jTextField4");

        jLabel5.setText("Direccion:");

        Direccion.setText("jTextField5");

        jLabel6.setText("Telefono:");

        Telefono.setText("jTextField6");

        botonAceptar.setText("Agregar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DoctorID)
                    .addComponent(Nombre)
                    .addComponent(Apellido)
                    .addComponent(Especialidad)
                    .addComponent(Direccion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Telefono))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(botonAceptar)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        Doctor doctor = new Doctor(); 
        doctor.setNombre(Nombre.getText());
        doctor.setApellido(Apellido.getText());
        doctor.setEspecialidad(Especialidad.getText());
        doctor.setDireccion(Direccion.getText());
        doctor.setTelefono(Telefono.getText());
        Connection conn = null;
        try {
            conn = conexion.getConexion(user, password, driver, servidor, baseDatos, puerto);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
        Doctores doctores = new Doctores(conn);
       
        dispose();
        if(this.operacion==ConstantesGUI.ACTUALIZAR) {
            try {
                doctores.actualizarDoctor(doctor); 
            } catch (Exception e) { 
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                doctores.agregarDoctor(doctor); 
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }  
        } 
    }//GEN-LAST:event_botonAceptarActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField DoctorID;
    private javax.swing.JTextField Especialidad;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
