package hospital;

public class Paciente {
    int PacienteID;
    String nombre,apellido,direccion,telefono;

    public Paciente() {
    }
    
    public Paciente(int PacienteID, String nombre, String apellido, String direccion, String telefono) {
        this.PacienteID = PacienteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public int getPacienteID() {
        return PacienteID;
    }

    public void setPacienteID(int PacienteID) {
        this.PacienteID = PacienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
