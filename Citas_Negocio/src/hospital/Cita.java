package hospital;

import java.util.Date; 
public class Cita {
    int citaID;
    Doctor doctor;
    Paciente paciente;
    Date hora;
    String fecha,comentario;
    
    public Cita() {
    }

    public Cita(int citaID, Doctor doctor, Paciente paciente, Date hora, String fecha, String comentario) {
        this.citaID = citaID;
        this.doctor = doctor;
        this.paciente = paciente;
        this.hora = hora;
        this.fecha = fecha;
        this.comentario = comentario;
    }
    
    public int getCitaID() {
        return citaID;
    }

    public void setCitaID(int citaID) {
        this.citaID = citaID;
    } 

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
