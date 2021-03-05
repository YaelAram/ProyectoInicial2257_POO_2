package mx.unam.aragon.fes;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {
    private int numeroEmpleado;
    private String departamento;
    private double sueldo;
    private int horasExtra;
    private Direccion direccion;
    private long serialVersionUID = 1L;

    public Empleado() {
    }

    public Empleado(int numeroEmpleado, String departamento, float sueldo, int horasExtra, Direccion direccion) {
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.horasExtra = horasExtra;
        this.direccion = direccion;
    }

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String curp, int numeroEmpleado, String departamento, float sueldo, int horasExtra, Direccion direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, curp);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.horasExtra = horasExtra;
        this.direccion = direccion;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre=" + getNombre() +  '\n' +
                "paterno=" + getApellidoPaterno() +  '\n' +
                "materno=" + getApellidoMaterno() +  '\n' +
                "edad=" + getEdad() +  '\n' +
                "curp=" + getCurp() +  '\n' +
                "numeroEmpleado=" + numeroEmpleado + '\n' +
                ", departamento='" + departamento + '\n' +
                ", sueldo=" + sueldo + '\n' +
                ", horasExtra=" + horasExtra + '\n' +
                ", direccion=" + direccion.toString() +
                '}';
    }

    public double calcularSueldo(){
        return 30.0 * this.sueldo + (this.horasExtra * 150.0);
    }
}
