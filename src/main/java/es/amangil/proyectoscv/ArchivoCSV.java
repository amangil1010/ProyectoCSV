package es.amangil.proyectoscv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class ArchivoCSV {
    Label label = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    
    TextArea textArea = new TextArea();
    
    String paisAnterior = "";
    String añoAnterior = "";
    String alturaAnterior = "";
    
    Datos listaDatos = new Datos();

    public void leer(){
        
    String nombreFichero = "average-height-of-men-for-selected-countries.csv";
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(nombreFichero));
        String texto = br.readLine();
        texto = br.readLine();
        while(texto != null) {
            String[] valores = texto.split(",");
            String paisActual = valores[0];
            String AñoActual = valores[2];
            String alturaActual = valores[3];
            if (paisAnterior.equals(paisActual) == false){
                //
                alturaAnterior = alturaActual;
                añoAnterior = AñoActual;
                paisAnterior = paisActual;
                //
                System.out.println(paisAnterior);
                System.out.println(añoAnterior);
                System.out.println(alturaAnterior);
                //
                textArea.appendText(paisAnterior + " " + añoAnterior + " " + alturaAnterior + "\n");
                //
                label.setText(paisAnterior);
                label2.setText(añoAnterior);
                label3.setText(alturaAnterior);
                //
                
                Dato p1 = new Dato(paisAnterior, añoAnterior, alturaAnterior);
                listaDatos.getListaDato().add(p1);
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
