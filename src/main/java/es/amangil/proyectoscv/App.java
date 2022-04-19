package es.amangil.proyectoscv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        ArchivoCSV archivoCSV = new ArchivoCSV();
        archivoCSV.leer();
                
        
        
        
//        HBox hbox1 = new HBox();
//        hbox1.getChildren().add(archivoCSV.ArchivoCSV());
        
    }

    public static void main(String[] args) {
        launch();
    }

}