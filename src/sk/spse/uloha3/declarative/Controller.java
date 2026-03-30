package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.HostServices;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Button zavrietButton;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private ImageView obrazok;

    @FXML
    private Slider slider;

    private HostServices hostServices;

    @FXML
    public void initialize() {
        zavrietButton.setOnAction(event -> handleZavriet());
        slider.setValue(0);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            obrazok.setRotate(newValue.doubleValue());
        });
    }

    private void handleZavriet() {
        Platform.exit();
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    private void handleHyperlinkAction() {
        if (hostServices != null) {
            hostServices.showDocument("https://spse-po.sk");
        } else {
            System.err.println("HostServices nie sú inicializované.");
        }
    }

    @FXML
    public void rotuj(MouseEvent mouseEvent) {
        obrazok.setRotate(slider.getValue());
    }

}