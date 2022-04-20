package es.amangil.proyectoscv;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class App extends Application {

    private TableView table = new TableView();
    
    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 500);
        stage.setScene(scene);
        stage.show();
        
        ArchivoCSV archivoCSV = new ArchivoCSV();
        archivoCSV.leer();
                
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(archivoCSV.textArea);
        vbox.getChildren().add(archivoCSV.label);
        vbox.getChildren().add(archivoCSV.label2);
        root.getChildren().add(vbox);
        
//        final Label label = new Label("Estatura");
//        label.setFont(new Font("Arial", 20));
// 
//        table.setEditable(true);
// 
//        TableColumn firstNameCol = new TableColumn("Pais");
//        TableColumn lastNameCol = new TableColumn("Año");
//        TableColumn emailCol = new TableColumn("Estatura");
//        
//        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
// 
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//        root.getChildren().add(vbox);
         
    }

    public static void main(String[] args) {
        launch();
    }

}