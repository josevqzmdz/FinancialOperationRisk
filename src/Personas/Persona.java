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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jose miguel
 */
public abstract class Persona {
    String Nombre, Direccion, CURP, fecha;
    int Dia, Mes, Año;
    long edad;
    public Persona(){
        
    }
    public Persona(String Nombre, String Direccion, String CURP, int Dia, int Mes, int Año){
        //este es el constructor
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.CURP = CURP;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        edad = this.calcEdad();
    }
    
    private String fecha(){      
        return fecha = Integer.toString(Dia) + "-"+ Integer.toString(Mes)+"-"+Integer.toString(Año);
    }
    
    public long calcEdad(){
        
        /*
        creamos el objeto SimpleDateFormat para calcular la fecha
        despues creamos el objeto Date para convertir la fecha reciba
        a formato Date
        Date es un long
        */
        
        try{
            return 16;
        /*    
            SimpleDateFormat SDF = new SimpleDateFormat("dd-mm-aaaa");
            Date fecha = SDF.parse(this.fecha());
            Date hoy = new Date();
            //se calcula la fecha aqui
            long ms = System.currentTimeMillis() - fecha.getTime();
            edad = (long)((long)ms/(1000.0*60*60*24*365));
            System.out.println("edad: "+edad);
            return edad;
        */
            /* 
            aqui esta el error :v
            */
        
        }catch(Exception n){
            JOptionPane.showMessageDialog(null, "Ingresa una edad");
            return -1;
            //-1 significa que no se esta calculando 
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }
    
    
}
