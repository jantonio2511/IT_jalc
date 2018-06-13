package modelo;
// Generated 13-jun-2018 20:03:22 by Hibernate Tools 4.3.1



/**
 * Bebe generated by hbm2java
 */
public class Bebe  implements java.io.Serializable {


     private String dni;
     private String nombrePadre;
     private String nombreMadre;
     private String horaNacimiento;
     private String horaSalidaIncubadora;

    public Bebe() {
    }

	
    public Bebe(String dni, String nombrePadre, String nombreMadre, String horaNacimiento) {
        this.dni = dni;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.horaNacimiento = horaNacimiento;
    }
    public Bebe(String dni, String nombrePadre, String nombreMadre, String horaNacimiento, String horaSalidaIncubadora) {
       this.dni = dni;
       this.nombrePadre = nombrePadre;
       this.nombreMadre = nombreMadre;
       this.horaNacimiento = horaNacimiento;
       this.horaSalidaIncubadora = horaSalidaIncubadora;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombrePadre() {
        return this.nombrePadre;
    }
    
    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }
    public String getNombreMadre() {
        return this.nombreMadre;
    }
    
    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }
    public String getHoraNacimiento() {
        return this.horaNacimiento;
    }
    
    public void setHoraNacimiento(String horaNacimiento) {
        this.horaNacimiento = horaNacimiento;
    }
    public String getHoraSalidaIncubadora() {
        return this.horaSalidaIncubadora;
    }
    
    public void setHoraSalidaIncubadora(String horaSalidaIncubadora) {
        this.horaSalidaIncubadora = horaSalidaIncubadora;
    }




}

