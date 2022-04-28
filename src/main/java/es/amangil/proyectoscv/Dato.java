package es.amangil.proyectoscv;

public class Dato {
    
    private String Pais;
    private int Año;
    private float Estatura;
    private float AlturaDeAñoSeleccionado;
    private float DiferenciaDeAltura;
    
    public Dato(){
        
    }
    //
    public Dato(String Pais, int Año, float Estatura){
        this.Pais = Pais;
        this.Año = Año;
        this.Estatura = Estatura;
    }
    //
    public Dato(String Pais, int Año, float Estatura, float AlturaDeAñoSeleccionado, float DiferenciaDeAltura){
        this.Pais = Pais;
        this.Año = Año;
        this.Estatura = Estatura;
        this.AlturaDeAñoSeleccionado = AlturaDeAñoSeleccionado;
        this.DiferenciaDeAltura = DiferenciaDeAltura;
    }
    //
    public String getPais() {
        return Pais;
    }
    
    public void setPais(String Pais){
        this.Pais = Pais;
    }
    //
    public int getAño() {
        return Año;
    }
    
    public void setAño(int Año){
        this.Año = Año;
    }
    //
    public float getEstatura() {
        return Estatura;
    }
    
    public void setEstatura(float Estatura){
        this.Estatura = Estatura;
    }
    //
    public float getAlturaDeAñoSeleccionado() {
        return AlturaDeAñoSeleccionado;
    }
    
    public void setAlturaDeAñoSeleccionado(float AlturaDeAñoSeleccionado){
        this.AlturaDeAñoSeleccionado = AlturaDeAñoSeleccionado;
    }
    //
    public float getDiferenciaDeAltura() {
        return DiferenciaDeAltura;
    }
    
    public void setDiferenciaDeAltura(float DiferenciaDeAltura){
        this.DiferenciaDeAltura = DiferenciaDeAltura;
    }
    
}
