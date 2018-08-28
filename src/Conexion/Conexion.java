

package Conexion;
import java.sql.*;
public class Conexion {
    public Connection cadena_conexion(){
        Connection cn=null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SAMS;integratedSecurity=true;");
        }catch(Exception e){
            
        }
        return cn;
    }
}
