

public class CompetitionController {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField edadField;
    @FXML
    private TextField nivelField;
    @FXML
    private Button addPersonButton;

    @FXML
    public void handleAddPersonButton() {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        String nivel = nivelField.getText();

        try {
            InsertData.insertPlayer(nombre, edad, nivel);
        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }