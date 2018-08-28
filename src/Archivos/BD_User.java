package Archivos;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class BD_User {
    String linea;         
    String Nombre, Direccion, CURP;
    int Dia, Mes, Anio;
    ArrayList<String> Arr_Nombre,Arr_Direccion,Arr_CURP;
    ArrayList<Integer> Arr_Dia, Arr_Mes, Arr_Anio;    
    
    public BD_User()
    {
        Arr_Nombre=new ArrayList();
        Arr_Direccion=new ArrayList();
        Arr_CURP=new ArrayList();
        Arr_Dia=new ArrayList();
        Arr_Mes=new ArrayList();
        Arr_Anio=new ArrayList();
        
        try{
               BufferedReader entrada =new BufferedReader( 
                       new FileReader("C:\\Users\\Public\\USUARIOS.csv"));

               entrada.readLine();


               while ((linea=entrada.readLine())!=null) {

                   StringTokenizer str =new StringTokenizer(linea,";");

                   Nombre=str.nextToken();
                   Direccion=str.nextToken();
                   CURP=str.nextToken();

                   int dia=Integer.parseInt(str.nextToken());
                   Dia=dia;
                   int mes=Integer.parseInt(str.nextToken());
                   Mes=mes;
                   int año=Integer.parseInt(str.nextToken());
                   Anio=año;
                   
                   Arr_Nombre.add(Nombre);
                   Arr_Direccion.add(Direccion);
                   Arr_CURP.add(Nombre);
                   Arr_Dia.add(Dia);
                   Arr_Mes.add(Mes);
                   Arr_Anio.add(Anio);
                   
                }
               if (entrada!=null) {
                   entrada.close();
               }

           }
           catch(FileNotFoundException ex){
               System.out.println("No existe el fichero");
               ex.printStackTrace();
           }
           catch(IOException ex){
                   System.out.println("Error");
                   ex.printStackTrace();
           } 
        
        
    }

    

    public ArrayList<String> getArr_Nombre() {
        return Arr_Nombre;
    }

    public void setArr_Nombre(ArrayList<String> Arr_Nombre) {
        this.Arr_Nombre = Arr_Nombre;
    }

    public ArrayList<String> getArr_Direccion() {
        return Arr_Direccion;
    }

    public void setArr_Direccion(ArrayList<String> Arr_Direccion) {
        this.Arr_Direccion = Arr_Direccion;
    }

    public ArrayList<String> getArr_CURP() {
        return Arr_CURP;
    }

    public void setArr_CURP(ArrayList<String> Arr_CURP) {
        this.Arr_CURP = Arr_CURP;
    }

    public ArrayList<Integer> getArr_Dia() {
        return Arr_Dia;
    }

    public void setArr_Dia(ArrayList<Integer> Arr_Dia) {
        this.Arr_Dia = Arr_Dia;
    }

    public ArrayList<Integer> getArr_Mes() {
        return Arr_Mes;
    }

    public void setArr_Mes(ArrayList<Integer> Arr_Mes) {
        this.Arr_Mes = Arr_Mes;
    }

    public ArrayList<Integer> getArr_Anio() {
        return Arr_Anio;
    }

    public void setArr_Anio(ArrayList<Integer> Arr_Anio) {
        this.Arr_Anio = Arr_Anio;
    }
    
    
    
    
    
    
}
