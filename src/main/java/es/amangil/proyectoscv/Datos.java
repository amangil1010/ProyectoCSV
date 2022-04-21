package es.amangil.proyectoscv;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Datos {
    private ArrayList<Dato> listaDato = new ArrayList();
    
    public ArrayList<Dato> getListaDato(){
        return listaDato;
    }
    
    @XmlElement(name = "objeto")
    public void setListaDato( ArrayList<Dato> listaDato){
        this.listaDato = listaDato;
    }
    
}
