package mx.unam.aragon.fes.persistencia;

import java.io.*;
import java.util.ArrayList;
import mx.unam.aragon.fes.Empleado;

public class ListaEmpleado {
    private static final ArrayList<Empleado> listaEmpleado = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = "empleado.dat";

    static {
        try(ObjectInputStream archivoEmpleado = new ObjectInputStream(new BufferedInputStream(new FileInputStream(NOMBRE_ARCHIVO)))){
            boolean eof = false;
            while(!eof){
                try{
                    Empleado empleado = (Empleado) archivoEmpleado.readObject();
                    if(empleado != null)
                        listaEmpleado.add(empleado);
                }
                catch (EOFException eofException){
                    System.out.println(eofException.getMessage());
                    eof = true;
                }
            }
            archivoEmpleado.close();
        }
        catch (IOException | ClassNotFoundException exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public static void escribirArchivo(){
        try(ObjectOutputStream archivoEmpleado = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(NOMBRE_ARCHIVO)))){
            for(Empleado empleado : listaEmpleado){
                archivoEmpleado.writeObject(empleado);
            }
            archivoEmpleado.close();
        }
        catch (IOException ioException){
            System.out.println("Error: " + ioException.getMessage());
        }
    }
    
    public static void escribirArchivo(String RUTA){
        try(ObjectOutputStream archivoEmpleado = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(RUTA)))){
            for(Empleado empleado : listaEmpleado){
                archivoEmpleado.writeObject(empleado);
            }
            archivoEmpleado.close();
        }
        catch (IOException ioException){
            System.out.println("Error: " + ioException.getMessage());
        }
    }

    public static ArrayList<Empleado> getListaDeEmpleado() {
        return listaEmpleado;
    }
}
