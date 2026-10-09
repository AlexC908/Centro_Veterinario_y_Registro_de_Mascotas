// utilice package para identificar la carpeta modelo que contiene la clase
package modelo;

import java.time.LocalDate;

// se define la clase mascota
public class Mascota {
    // sus atributos
    private String nombre;
    private int edad;
    private String tipo;
    private boolean vacunadoAlDia;
    // mejoras al codigo
    private String nombreDueno;
    private String telefono;
    // para la fecha actualizada
    private LocalDate fechaRegistro = LocalDate.now();

    // constructor vacio para que ingrese los datos a ingresar
    public Mascota() {
    }

    // constructor con todos los datos
    public Mascota(String nombre, int edad, String tipo, boolean vacunadoAldia, String nombreDueno, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.vacunadoAlDia = vacunadoAldia;
        this.nombreDueno = nombreDueno;
        this.telefono = telefono;
    }

    // metodos get y set
    public String getNombre() {
        return this.nombre;

    }

    public int getEdad() {
        return this.edad;
    }

    public String getTipo() {
        return this.tipo;

    }

    public boolean isVacunadoAlDia() {
        return this.vacunadoAlDia;
    }

    public String getNombreDueno() {
        return this.nombreDueno;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVacunadoAlDia(boolean vacunadoAldia) {
        this.vacunadoAlDia = vacunadoAldia;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // devuelve la fecha como texto dd/mm/aaaa no se mofica la fecha a mano
    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public String obtenerFechaTexto() {
        return String.format("%02d/%02d/%04d",
                fechaRegistro.getDayOfMonth(),
                fechaRegistro.getMonthValue(),
                fechaRegistro.getYear());
    }

    // devuelve una recomendacion segun el estado de vacunacion
    public String obtenerRecomendacion() {
        if (vacunadoAlDia) {
            return "Vacuna al dia, sin pendientes. ";
        } else {
            return "Se recomienda agendar vacunacion. ";
        }
    }

    public String generarResumen() {
        String textoEdad = edad + " años";
        if (edad == 1) {
            textoEdad = edad + " año";
        }
        String textoVacunas = "no";
        if (vacunadoAlDia) {
            textoVacunas = "si";
        }
        return "---Ficha de atencion---\n"
                + "Fecha de registro: " + obtenerFechaTexto() + "\n"
                + "Nombre: " + nombre + "\n"
                + "Edad: " + textoEdad + "\n"
                + "tipo de mascota: " + tipo + "\n"
                + "Vacunas al dia; " + textoVacunas + "\n"
                + "Dueño: " + nombreDueno + "\n"
                + "Telefono: " + telefono + "\n"
                + "recomendacion: " + obtenerRecomendacion() + "\n"
                + "---------------------------------------";

    }
}
