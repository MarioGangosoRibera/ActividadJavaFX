package org.example.actividad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnInicio;

    @FXML
    void iniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        try(Connection connection=new DatabaseConnector().conectar()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND clave = ?");
            statement.setString(1, txtUsuario.getText());
            statement.setString(2, txtPassword.getText());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inicio de sesión");
                alert.setHeaderText(null);
                alert.setContentText("Inicio de sesion realizado.");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Credenciales inválidas.");
                alert.showAndWait();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al conectar con la base de datos.");
            alert.showAndWait();
        }
    }

}
