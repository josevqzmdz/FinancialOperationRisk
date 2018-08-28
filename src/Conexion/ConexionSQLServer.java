/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import javax.swing.JOptionPane;

/**
 *
 * @author Cavazos
 */
public class ConexionSQLServer {
    public static void main(String[] args) {
        Datosconexion da =new Datosconexion();
        
        if(da.probarconexion()==1){
        
            JOptionPane.showMessageDialog(null,"Conexion correcta");
        }else{
                    JOptionPane.showMessageDialog(null,"Conexion incorrecta");
        }
    }
}
