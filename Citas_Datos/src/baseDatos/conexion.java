package baseDatos; 
import static java.lang.Class.forName;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
 
public class Conexion {
    private static Connection conn;  
    public static Connection getConexion(String user, String password, String driver,String servidor, String baseDatos, String puerto) throws Exception {
        forName(driver).newInstance();
        conn= getConnection("jdbc:sqlserver://"+servidor+":"+puerto+";"+"databaseName="+baseDatos+";user="+user+";password="+password+";");
        return conn;
    }
}