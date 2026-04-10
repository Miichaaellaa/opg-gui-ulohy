package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import java.awt.Desktop;
import java.net.URI;

public class Controller {

    @FXML
    private Button zavrietButton;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    public void initialize() {
        if (zavrietButton != null) {
            zavrietButton.setOnAction(event -> Platform.exit());
        }
    }

    @FXML
    private void handleHyperlinkAction() {
        try {
            String url = hyperlink.getText();
            if (!url.startsWith("http")) {
                url = "https://" + url;
            }
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            System.err.println("Nepodarilo sa otvoriť prehliadač: " + e.getMessage());
        }
    }
}