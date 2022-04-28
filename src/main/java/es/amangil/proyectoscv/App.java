package es.amangil.proyectoscv;

import javafx.application.Application;
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
    static float añoSeleccionado ;
    ArchivoCSV archivoCSV = new ArchivoCSV();

    
    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        var scene = new Scene(root, 815, 500);
        stage.setTitle("CSV Altura");
        stage.setScene(scene);
        stage.show();
        
        archivoCSV.leer();
        archivoCSV.listaDatos.getListaDato();
                
        final Label label = new Label("Estatura Ultimo Año");
        label.setFont(new Font("Arial", 20));
        
        //Creamos la tabla
        TableView table = new TableView();
        table.setEditable(true);
        table.setMaxHeight(300);
        table.setMinHeight(300);
        table.setMaxWidth(800);
        table.setMinWidth(800);
        table.setStyle("-fx-background-color: black;");//Cambiar linea de borde
        table.setBorder(new Border(new BorderStroke(Color.valueOf("#FFFFFF"),//Cambiar linea de borde
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            new BorderWidths(5))));
        
        //Creamos las columnas
        TableColumn colPais = new TableColumn("Pais");
        colPais.setMinWidth(161);//Tamaño
        //
        TableColumn colAño = new TableColumn("Año");
        colAño.setMinWidth(161);//Tamaño
        //
        TableColumn colEstatura = new TableColumn("Estatura");
        colEstatura.setMinWidth(161);//Tamaño
        //
        TableColumn colEstaturaDiferencial = new TableColumn("EstaturaDeAñoSeleccionado");
        colEstatura.setMinWidth(161);//Tamaño
        //
        TableColumn colDiferenciaDeAltura = new TableColumn("DiferenciaDeAltura");
        colEstatura.setMinWidth(161);//Tamaño
        //Las añadimos a la tabla
        table.getColumns().addAll(colPais, colAño, colEstatura, colEstaturaDiferencial, colDiferenciaDeAltura);
        //Aqui indicamos como se llaman las variables que vamos a introducir
        colPais.setCellValueFactory(new PropertyValueFactory<>("Pais"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("Año"));
        colEstatura.setCellValueFactory(new PropertyValueFactory<>("Estatura"));
        colEstaturaDiferencial.setCellValueFactory(new PropertyValueFactory<>("AlturaDeAñoSeleccionado"));
        colDiferenciaDeAltura.setCellValueFactory(new PropertyValueFactory<>("DiferenciaDeAltura"));
        //Aqui introducimos el ArrayList para que consiga los datos de ahi
        table.getItems().addAll(archivoCSV.listaDatos.getListaDato());
        //Creamos el boton que cuando le demos se guarde el CSV
        Button buttonSelecFile = new Button("Guardar");
        buttonSelecFile.setAlignment(Pos.CENTER);
        buttonSelecFile.setLayoutY(0);
        buttonSelecFile.setOnAction((t) -> {
            archivoCSV.guardarDatosCSV();
        });
        //Creacion del 1º VBOX
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));        
        System.out.println("ARRY: " + archivoCSV.listaDatos.getListaDato().size());
        
        //Creacion del 2º VBOX
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(buttonSelecFile);
        
        //Creacion del 3º VBOX
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        TextField textField = new TextField ();
        //Creacion del boton para la comparativa de años
        Button buttonvisualizar = new Button("Visualizar");
        buttonvisualizar.setAlignment(Pos.CENTER);
        buttonvisualizar.setOnAction((t) -> {
            añoSeleccionado = Integer.valueOf(textField.getText());
            System.out.println("añoSeleccionado: " + añoSeleccionado);
            System.out.println("alturaAñoSeleccionado: " + archivoCSV.alturaAñoSeleccionado);
            archivoCSV.leer();
            archivoCSV.listaDatos.getListaDato().clear();//Limpiamos la lista
            System.out.println("MOSTRAR EL TAMAÑO DE LA LISTA: " + archivoCSV.listaDatos.getListaDato().size());//Miramos el tamaño de la lista
            table.refresh();//Refrescamos la tabla
            table.getItems().clear();//Limpiamos la tabla
            table.refresh();//Refrescamos la tabla
            archivoCSV.leer();//Llamamos al metodo
            table.getItems().addAll(archivoCSV.listaDatos.getListaDato());//Añadimos a la tabla
        });
        vbox3.getChildren().addAll(textField, buttonvisualizar);
        //Agregar al VBOX principal
        vbox.getChildren().addAll(label, table, vbox2, vbox3);
        //Añadirlo al root
        root.getChildren().add(vbox);
    }

    public static void main(String[] args) {
        launch();
    }

}