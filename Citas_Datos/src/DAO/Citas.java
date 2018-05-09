package DAO;

import hospital.Cita;
import java.sql.Connection;import java.sql.ResultSet;
import java.sql.SQLException;
public class Citas extends RecordSet {

    private String nomTable = "Citas";

    public Citas(Connection conn) {
        super(conn);
    }

    public Cita obtenerCita(int IdCita) throws SQLException, NullPointerException {
        ResultSet rs;
        NullPointerException npe = new NullPointerException();
        String sql = "SELECT * FROM " + nomTable + " WHERE CitaID = '" + IdCita;
        executeSelect(sql);
        if ((rs = readNext()) != null) {
            Cita cita = new Cita(rs.getInt("CitaID"),
                    rs.getInt("DoctorID"),
                    rs.getInt("PacienteID"),
                    rs.getInt("UsuarioID"),
                    rs.getDate("Fecha"),
                    rs.getString("Comentario"),
                    rs.getBoolean("Status"),
                    rs.getInt("Duracion"),
                    rs.getString("Hora"));
            return cita;
        }
        throw npe;
    }
    
    
   
    

}
