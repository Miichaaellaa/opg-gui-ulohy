package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.util.Random;

public class Controller {

    @FXML
    private Button closeButton;

    @FXML
    private Button randomizeButton;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private VBox vbox3;

    @FXML
    private VBox vbox4;

    private Random random = new Random();

    @FXML
    public void initialize() {
        // Inicializácia nie je potrebná, pretože tlačidlá už majú onAction v FXML
        // Táto metóda sa volá automaticky po načítaní FXML
    }

    @FXML
    private void handleClose() {
        Platform.exit();
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor());
        vbox2.setStyle("-fx-background-color: " + getRandomColor());
        vbox3.setStyle("-fx-background-color: " + getRandomColor());
        vbox4.setStyle("-fx-background-color: " + getRandomColor());
    }

    private String getRandomColor() {
        return String.format("#%06x", random.nextInt(0xffffff + 1));
    }
}