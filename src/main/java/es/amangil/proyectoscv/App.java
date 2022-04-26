package es.amangil.proyectoscv;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class App extends Application {

    private TableView table = new TableView();
    int añoSeleccionado;
    
    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 500);
        stage.setTitle("CSV Altura");
        stage.setScene(scene);
        stage.show();
        
        ArchivoCSV archivoCSV = new ArchivoCSV();
        archivoCSV.leer();
        archivoCSV.listaDatos.getListaDato();
                
        final Label label = new Label("Estatura Ultimo Año");
        label.setFont(new Font("Arial", 20));
        
        TableView table = new TableView();
        table.setEditable(true);
        table.setMaxHeight(200);
        table.setMinHeight(200);
        table.setMaxWidth(640);
        table.setMinWidth(640);
//        table.setStyle("-fx-background-color: red;");
//        //
//        table.setBorder(new Border(new BorderStroke(Color.valueOf("#ADD8E6"),
//            BorderStrokeStyle.DASHED,
//            CornerRadii.EMPTY,
//            new BorderWidths(5))));

//
        
        TableColumn colPais = new TableColumn("Pais");
        colPais.setMinWidth(206);
        
        TableColumn colAño = new TableColumn("Año");
        colAño.setMinWidth(206);
        
        TableColumn colEstatura = new TableColumn("Estatura");
        colEstatura.setMinWidth(206);
        
//        TableColumn colEstaturaDiferencial = new TableColumn("EstaturaDiferencial");
//        colEstatura.setMinWidth(206);
        
        table.getColumns().addAll(colPais, colAño, colEstatura);
           
        colPais.setCellValueFactory(new PropertyValueFactory<>("Pais"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("Año"));
        colEstatura.setCellValueFactory(new PropertyValueFactory<>("Estatura"));
//        colEstaturaDiferencial.setCellValueFactory(new PropertyValueFactory<>("EstaturaDiferencial"));

//        Dato p1 = new Dato("España", "Perez", "2012-11-01");
//        Dato p2 = new Dato("Maria", "Loza", "2013-01-15");
//        Dato p3 = new Dato("Adriana", "Mendez", "2014-07-20");

        table.getItems().addAll(archivoCSV.listaDatos.getListaDato());
//        table.getItems().addAll(p1);
       
///////////////////////
        Button buttonSelecFile = new Button("Guardar");
        buttonSelecFile.setAlignment(Pos.CENTER);
        buttonSelecFile.setLayoutY(0);
        buttonSelecFile.setOnAction((t) -> {
        archivoCSV.guardarDatosCSV();
        });
        
        
//////////////////////
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table, buttonSelecFile);
        
        System.out.println("ARRY: " + archivoCSV.listaDatos.getListaDato().size());
        
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(buttonSelecFile);
        
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        TextField textField = new TextField ();
        
        Button buttonvisualizar = new Button("Visualizar");
        buttonvisualizar.setAlignment(Pos.CENTER);
        buttonvisualizar.setOnAction((t) -> {
            int añoSeleccionado = Integer.valueOf(textField.getText());
            System.out.println("HOLA" + añoSeleccionado);
        });
        
        vbox3.getChildren().addAll(textField, buttonvisualizar);

        
        vbox.getChildren().addAll(label, table, vbox2, vbox3);
        root.getChildren().add(vbox);
    }

    public static void main(String[] args) {
        launch();
    }

}