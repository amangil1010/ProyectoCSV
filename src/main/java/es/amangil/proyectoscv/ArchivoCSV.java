package es.amangil.proyectoscv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class ArchivoCSV {
    Label label = new Label();
    Label label2 = new Label();
    
    TextArea textArea = new TextArea();
    
    String paisAnterior = "";
    String alturaAnterior = "";
    
    public void leer(){
    
    String nombreFichero = "average-height-of-men-for-selected-countries.csv";
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(nombreFichero));
        String texto = br.readLine();
        while(texto != null) {
            String[] valores = texto.split(",");
            String paisActual = valores[0];
            String alturaActual = valores[3];
            if (paisAnterior.equals(paisActual) == false){
                alturaAnterior = alturaActual;
                paisAnterior = paisActual;
                System.out.println(paisAnterior);
                System.out.println(alturaAnterior);
//                textArea.setText(paisAnterior + " " + alturaAnterior);
                textArea.appendText(paisAnterior + " " + alturaAnterior + "\n");
                label.setText(paisAnterior);
                label2.setText(alturaAnterior);
            }
            
            texto = br.readLine();
        }

    }
    catch (FileNotFoundException ex) {
        System.out.println("Error: Fichero no encontrado");
        ex.printStackTrace();
    }
    catch(Exception ex) {
        System.out.println("Error de lectura del fichero");
        ex.printStackTrace();
    }
    finally {
        try {
            if(br != null) {
                br.close();
            }
        }
        catch (Exception ex) {
            System.out.println("Error al cerrar el fichero");
            ex.printStackTrace();
        }
    }
    }

    
}
