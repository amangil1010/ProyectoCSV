package es.amangil.proyectoscv;

public class Dato {
    
    private String Pais;
    private String Año;
    private String Estatura;
    
    public Dato(){
        
    }
    
    public Dato(String Pais, String Año, String Estatura){
        this.Pais = Pais;
        this.Año = Año;
        this.Estatura = Estatura;
    }
    //
    public String getPais() {
        return Pais;
    }
    
    public void setPais(String Pais){
        this.Pais = Pais;
    }
    //
    public String getAño() {
        return Año;
    }
    
    public void setAño(String Año){
        this.Año = Año;
    }
    //
    public String getEstatura() {
        return Estatura;
    }
    
    public void setEstatura(String Estatura){
        this.Estatura = Estatura;
    }
}
