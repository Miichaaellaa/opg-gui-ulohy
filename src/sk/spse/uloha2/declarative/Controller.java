package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ToggleGroup pohlavieGroup;

    @FXML
    private Button registrovatButton;

    @FXML
    private Button zavrietButton;

    @FXML
    public void initialize() {
        registrovatButton.setOnAction(event -> handleRegistrovat());
        zavrietButton.setOnAction(event -> handleZavriet());
    }

    private void handleRegistrovat() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        String pohlavie = "";
        if (pohlavieGroup.getSelectedToggle() != null) {
            pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();
        } else {
            pohlavie = "nevybraté";
        }

        String message = "Užívateľské " + username + "(" + pohlavie + ")" + "s heslom " + password;

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registrácia užívateľa");
        alert.setHeaderText("Registrácia prebehla úspešne");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleZavriet() {
        Platform.exit();
    }
}