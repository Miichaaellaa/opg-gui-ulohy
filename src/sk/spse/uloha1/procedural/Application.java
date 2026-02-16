package sk.spse.uloha1.procedural;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private TextField cField;
    private TextField fField;

    public void convertCtoF(KeyEvent keyEvent) {
        try {
            double c = Double.parseDouble(cField.getText());
            double f = (c * 9.0 / 5.0) + 32.0;
            fField.setText(String.valueOf(f));
        } catch (NumberFormatException e) {
            fField.setText("");
        }
    }

    public void convertFtoC(KeyEvent keyEvent) {
        try {
            double f = Double.parseDouble(fField.getText());
            double c = (f - 32.0) * 5.0 / 9.0;
            cField.setText(String.valueOf(c));
        } catch (NumberFormatException e) {
            cField.setText("");
        }
    }

    @Override
    public void start(Stage stage) {

        Label cLabel = new Label("Stupne Celsius         ");
        cField = new TextField();
        cField.setOnKeyTyped(this::convertCtoF);
        Label cUnit = new Label("°C");

        Label fLabel = new Label("Stupne Fahrenheita");
        fField = new TextField();
        fField.setOnKeyTyped(this::convertFtoC);
        Label fUnit = new Label("°F");

        HBox cel = new HBox(20, cLabel, cField, cUnit);
        HBox fah = new HBox(20, fLabel, fField, fUnit);
        VBox root = new VBox(20, cel, fah);

        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        stage.setTitle("Declarative Application 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}