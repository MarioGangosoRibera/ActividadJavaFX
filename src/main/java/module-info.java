module org.example.actividad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.actividad to javafx.fxml;
    exports org.example.actividad;
}