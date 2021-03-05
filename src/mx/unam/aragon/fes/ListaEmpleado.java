package mx.unam.aragon.fes;

import java.io.*;
import java.util.ArrayList;

public class ListaEmpleado {
    private static final ArrayList<Empleado> listaDeEmpleado = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = "empleado.dat";

    static {
        try(ObjectInputStream archivoEmpleado = new ObjectInputStream(new BufferedInputStream(new FileInputStream(NOMBRE_ARCHIVO)))){
            boolean eof = false;
            while(!eof){
                try{
                    Empleado empleado = (Empleado) archivoEmpleado.readObject();
                    listaDeEmpleado.add(empleado);
                }
                catch (EOFException eofException){
                    eof = true;
                }
            }
        }
        catch (IOException | ClassNotFoundException exception){
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static void escribirArchivo(){
        try(ObjectOutputStream archivoEmpleado = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(NOMBRE_ARCHIVO)))){
            for(Empleado empleado : listaDeEmpleado){
                archivoEmpleado.writeObject(empleado);
            }
        }
        catch (IOException ioException){
            System.out.println("Error: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }

    public static ArrayList<Empleado> getListaDeEmpleado() {
        return listaDeEmpleado;
    }
}
