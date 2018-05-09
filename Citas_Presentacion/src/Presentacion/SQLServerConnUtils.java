package Presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SQLServerConnUtils {
     
    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    public static Connection getSQLServerConnection_SQLJDBC()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "Citas";
        String userName = "sa";
        String password = "197126";
 
        return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName,
                database, userName, password);
    }
 
    
    // Connect to SQLServer & using JTDS library
    public static Connection getSQLServerConnection_JTDS() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "Citas";
        String userName = "sa";
        String password = "197126";
 
        return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database,
                userName, password);
    }
    
    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    private static Connection getSQLServerConnection_SQLJDBC(String hostName,
            String sqlInstanceName, String database, String userName,
            String password) throws ClassNotFoundException, SQLException {
 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
                + ";instance=" + sqlInstanceName + ";databaseName=" + database;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
    
    // Connect to SQLServer & using JTDS library
    private static Connection getSQLServerConnection_JTDS(String hostName,
            String sqlInstanceName, String database, String userName,
            String password) throws ClassNotFoundException, SQLException {
 
        // Declare the class Driver for SQLServer DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.    
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
 
        // jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
        String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"
                + database + ";instance=" + sqlInstanceName;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
 
}