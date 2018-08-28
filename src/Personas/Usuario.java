/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jose miguel
 */
public class Usuario extends Persona {
        
    public Usuario(String Nombre, String Direccion, String CURP, int Dia, int Mes, int Año){
        //campos de nombre y direccion ya se heredaron de "Persona"
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.CURP = CURP;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año; 
        
        archivocsv("C:\\Users\\Public\\USUARIOS.csv",true);
        
    }
    
    
    public void archivocsv(String nombrefichero, boolean agregar)
    {
        File f;
        f=new File (nombrefichero);
        boolean encabezado = false;
            if(f.exists() && !agregar)
            {
                f.delete();
                encabezado=true;
            }
            if (!f.exists()) {
                encabezado=true;
            }
            FileWriter flujosalida=null;
            BufferedWriter salida=null;

        try{
            flujosalida=new FileWriter(f,agregar);
            salida=new BufferedWriter(flujosalida);
            if (encabezado) {
                salida.write("Nombre; Direccion; CURP; Dia; Mes; Año; Edad");
                salida.newLine();
            }
            salida.write(this.Nombre+";");
            salida.write(this.Direccion+";");
            salida.write(this.CURP+";");
            salida.write(this.Dia+";");
            salida.write(this.Mes+";");
            salida.write(this.Año+";");
            salida.write(16+";");
            salida.newLine();
            salida.close();
            flujosalida.close();
        }
        catch(IOException ex){
            System.out.println("Error de Salida");
            ex.printStackTrace();
        }
        finally{
            try{
            salida.close();
            flujosalida.close();
            }
            catch(IOException ex){
            System.out.println("Error al cerrar fichero");
            ex.printStackTrace();
        }
        } 
    }  
}
