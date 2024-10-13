package org.example.actividad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
        CompetitionController controller = new CompetitionController();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("competicion.fxml"));
        loader.setController(controller);
        VBox vBox = loader.load();

        controller.cargarDatos();

        Scene scene = new Scene(loader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}