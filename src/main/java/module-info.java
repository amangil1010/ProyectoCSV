module es.amangil.proyectoscv {
    requires javafx.controls;
    exports es.amangil.proyectoscv;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    opens es.amangil.proyectoscv to java.xml.bind;
}
