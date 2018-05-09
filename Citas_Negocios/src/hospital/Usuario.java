package hospital;

public class Usuario {
    int usuarioID;
    String nombre,apellido,password,username;

    public Usuario(String username){
        this.username = username;
    }
    
    public Usuario(){
        
    }

    public Usuario(int usuarioID, String nombre, String apellido, String password, String username) {
        this.usuarioID = usuarioID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.username = username;
    }
    
    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
