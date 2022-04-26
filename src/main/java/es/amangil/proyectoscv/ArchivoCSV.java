package es.amangil.proyectoscv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ArchivoCSV {
    
    Label label = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
        
    String paisAnterior = "";
    int añoAnterior = 0;
    float alturaAnterior = 0;
    float alturaAñoSeleccionado = 0;
    
    Datos listaDatos = new Datos();
    App app = new App();
    
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
            int AñoActual = Integer.valueOf(valores[2]);
            float alturaActual = Float.valueOf(valores[3]);
//            if (app.añoSeleccionado == AñoActual){
//                alturaAñoSeleccionado =  alturaActual;
//            }
            if (paisAnterior.equals(paisActual) == false){
                //
                alturaAnterior = alturaActual;
                añoAnterior = AñoActual;
                paisAnterior = paisActual;
                //
                System.out.println("Pais: " + paisAnterior);
                System.out.println("Año: " + añoAnterior);
                System.out.println("AlturaUltima: " + alturaAnterior);
//                System.out.println("AlturaEseAño: " + alturaAñoSeleccionado);
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
            // HAY QUE HACERLO CON DATO:AÑO DATO:PAIS DATO:ESTATICO
            System.out.println("Error al cerrar el fichero");
            ex.printStackTrace();
        }
    }
    }
    
        public void guardarDatosCSV() {
        String nombreFichero = "nuevo.csv";
        String texto = "Texto de prueba";
        BufferedWriter bw = null;
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            for (int x=0; x<listaDatos.getListaDato().size(); x++) {
                bw.write(listaDatos.getListaDato().get(x).getPais() + "," + listaDatos.getListaDato().get(x).getAño() + "," + listaDatos.getListaDato().get(x).getEstatura() +  "\n");
            }
        }
        // Comprobar si se ha producido algún error
        catch(Exception ex) {
           System.out.println("Error de escritura del fichero");
           ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }          
            }


        }
