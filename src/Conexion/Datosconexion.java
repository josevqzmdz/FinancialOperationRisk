package Conexion;
import java.sql.*;
public class Datosconexion extends Conexion {
    
    Connection cn = cadena_conexion();
    public int probarconexion(){
        int conexion=0; 
        try {
            PreparedStatement ps =null;
            ResultSet rs =null;
            ps=cn.prepareStatement("SELECT COUNT(*) from Proveedores");
            rs=ps.executeQuery();
            if(rs.next()){
                conexion=1;
            }
        }catch(Exception e){
            System.out.println("");
        }
        return conexion;
        
    }
}
