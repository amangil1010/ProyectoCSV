package es.amangil.proyectoscv;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
                
        Dato dato = new Dato();
        
        ArchivoCSV archivoCSV = new ArchivoCSV();
        archivoCSV.leer();
        archivoCSV.listaDatos.getListaDato();
                
        final Label label = new Label("Estatura Ultimo Año");
        label.setFont(new Font("Arial", 20));
        
        TableView table = new TableView();
        table.setEditable(true);
        
        TableColumn colPais = new TableColumn("Pais");
        colPais.setMinWidth(206);
        
        TableColumn colAño = new TableColumn("Año");
        colAño.setMinWidth(206);
        
        TableColumn colEstatura = new TableColumn("Estatura");
        colEstatura.setMinWidth(206);
        
        table.getColumns().addAll(colPais, colAño, colEstatura);
           
        colPais.setCellValueFactory(new PropertyValueFactory<>("Pais"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("Año"));
        colEstatura.setCellValueFactory(new PropertyValueFactory<>("Estatura"));

//        Dato p1 = new Dato("España", "Perez", "2012-11-01");
//        Dato p2 = new Dato("Maria", "Loza", "2013-01-15");
//        Dato p3 = new Dato("Adriana", "Mendez", "2014-07-20");

        table.getItems().addAll(archivoCSV.listaDatos.getListaDato());
//        table.getItems().addAll(p1);
        
//        final TextField addFirstName = new TextField();
//        addFirstName.setPromptText("First Name");
//        addFirstName.setMaxWidth(colPais.getPrefWidth());
//        final TextField addLastName = new TextField();
//        addLastName.setMaxWidth(colAño.getPrefWidth());
//        addLastName.setPromptText("Last Name");
//        final TextField addEmail = new TextField();
//        addEmail.setMaxWidth(colEstatura.getPrefWidth());
//        addEmail.setPromptText("Email");
//        
//        final Button addButton = new Button("Add");
//        addButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
////                data.add(new Person(
////                        addFirstName.getText(),
////                        addLastName.getText(),
////                        addEmail.getText()));
////                addFirstName.clear();
////                addLastName.clear();
////                addEmail.clear();
//            }
//        });
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        root.getChildren().add(vbox);
        System.out.println("ARRY: " + archivoCSV.listaDatos.getListaDato().size());
         
    }

    public static void main(String[] args) {
        launch();
    }

}