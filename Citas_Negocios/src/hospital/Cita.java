package hospital;


import java.sql.Date;
public class Cita {

    int citaID,doctorID,pacienteID,usuarioID;
    Date fecha;
    String comentario,hora;
    int duracion;
    boolean Status;
    
    public Cita() {
    }

    public Cita(int citaID, int doctorID, int pacienteID, int usuarioID,Date fecha, String comentario,boolean Status,int duracion,String hora) {
        this.citaID = citaID;
        this.doctorID = doctorID;
        this.pacienteID = pacienteID;
        this.usuarioID = usuarioID;
        this.fecha = fecha;
        this.comentario = comentario;
        this.Status = Status;
        this.duracion = duracion;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getCitaID() {
        return citaID;
    }

    public void setCitaID(int citaID) {
        this.citaID = citaID;
    }

    public int getDoctor() {
        return doctorID;
    }

    public void setDoctor(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPaciente() {
        return pacienteID;
    }

    public void setPaciente(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Cita{" + "citaID=" + citaID + ", doctorID=" + doctorID + ", pacienteID=" + pacienteID + ", usuarioID=" + usuarioID + ", fecha=" + fecha + ", comentario=" + comentario + ", hora=" + hora + ", duracion=" + duracion + ", Status=" + Status + '}';
    }
    
}
