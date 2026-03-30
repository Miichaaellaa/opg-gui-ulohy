package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

        private TextField usernameField;
        private PasswordField passwordField;
        private ToggleGroup pohlavieGroup;
        private RadioButton muzRadio;
        private RadioButton zenaRadio;
        private Button registrovatButton;
        private Button zavrietButton;

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Registračný formulár");

            // Vytvorenie GridPane ako koreňového prvku - 2 stĺpce, 5 riadkov
            GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(5);
            gridPane.setPadding(new Insets(10));

            // Nastavenie constraints pre stĺpce
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setMinWidth(20);
            col1.setPrefWidth(130.5);
            col1.setMaxWidth(151.4553451538086);
            col1.setHgrow(Priority.SOMETIMES);

            ColumnConstraints col2 = new ColumnConstraints();
            col2.setMinWidth(20);
            col2.setPrefWidth(212);
            col2.setMaxWidth(217.68467712402344);
            col2.setHgrow(Priority.SOMETIMES);
            col2.setFillWidth(false);

            gridPane.getColumnConstraints().addAll(col1, col2);

            // Nastavenie constraints pre riadky
            RowConstraints row1 = new RowConstraints();
            row1.setMinHeight(10);
            row1.setPrefHeight(41.52233123779297);
            row1.setMaxHeight(54.70701217651367);
            row1.setVgrow(Priority.SOMETIMES);

            RowConstraints row2 = new RowConstraints();
            row2.setMinHeight(10);
            row2.setPrefHeight(37.90129089355469);
            row2.setMaxHeight(46.47766876220703);
            row2.setVgrow(Priority.SOMETIMES);

            RowConstraints row3 = new RowConstraints();
            row3.setMinHeight(10);
            row3.setPrefHeight(38);
            row3.setMaxHeight(67.80884552001953);
            row3.setVgrow(Priority.SOMETIMES);

            RowConstraints row4 = new RowConstraints();
            row4.setMinHeight(10);
            row4.setPrefHeight(23.6688232421875);
            row4.setMaxHeight(67.80884552001953);
            row4.setVgrow(Priority.SOMETIMES);

            RowConstraints row5 = new RowConstraints();
            row5.setMinHeight(0.19115447998046875);
            row5.setPrefHeight(44.3311767578125);
            row5.setMaxHeight(44.3311767578125);
            row5.setVgrow(Priority.SOMETIMES);

            gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5);

            // RIADOK 0 - Užívateľské meno
            Label usernameLabel = new Label("Užívateľské meno:");
            usernameLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
            GridPane.setMargin(usernameLabel, new Insets(0, 10, 0, 0));
            gridPane.add(usernameLabel, 0, 0);

            usernameField = new TextField();
            usernameField.setPromptText("zadajte meno");
            usernameField.setPadding(new Insets(10, 10, 10, 10));
            gridPane.add(usernameField, 1, 0);

            // RIADOK 1 - Heslo
            Label passwordLabel = new Label("Heslo:");
            passwordLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
            GridPane.setMargin(passwordLabel, new Insets(0, 10, 0, 0));
            gridPane.add(passwordLabel, 0, 1);

            passwordField = new PasswordField();
            passwordField.setPromptText("zadajte heslo");
            passwordField.setPadding(new Insets(10, 10, 10, 10));
            gridPane.add(passwordField, 1, 1);

            // RIADOK 2 - Pohlavie
            Label pohlavieLabel = new Label("Pohlavie:");
            pohlavieLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
            GridPane.setMargin(pohlavieLabel, new Insets(0, 10, 0, 0));
            gridPane.add(pohlavieLabel, 0, 2);

            // Vytvorenie HBox pre RadioButton
            HBox pohlavieBox = new HBox(20);
            pohlavieBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            pohlavieBox.setPadding(new Insets(10, 10, 10, 10));

            // Vytvorenie RadioButtonov so spoločným toggleGroup
            pohlavieGroup = new ToggleGroup();

            muzRadio = new RadioButton("Muž");
            muzRadio.setToggleGroup(pohlavieGroup);

            zenaRadio = new RadioButton("Žena");
            zenaRadio.setToggleGroup(pohlavieGroup);

            pohlavieBox.getChildren().addAll(muzRadio, zenaRadio);
            gridPane.add(pohlavieBox, 1, 2);

            // RIADOK 3 - Separátor (spojené stĺpce)
            Separator separator = new Separator();
            GridPane.setColumnSpan(separator, 2);
            gridPane.add(separator, 0, 3);

            // RIADOK 4 - Tlačidlá (spojené stĺpce)
            HBox buttonBox = new HBox(20);
            buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
            buttonBox.setPadding(new Insets(10, 10, 10, 10));

            registrovatButton = new Button("Registrovať");
            zavrietButton = new Button("Zavrieť");

            buttonBox.getChildren().addAll(registrovatButton, zavrietButton);
            GridPane.setColumnSpan(buttonBox, 2);
            gridPane.add(buttonBox, 0, 4);

            // Nastavenie akcií pre tlačidlá
            registrovatButton.setOnAction(event -> {
                String username = usernameField.getText();
                String password = passwordField.getText();

                // Zistenie pohlavia - podľa zadania: ((RadioButton)pohlavieGroup.getSelectedToggle()).getText()
                String pohlavie = "";
                if (pohlavieGroup.getSelectedToggle() != null) {
                    pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();
                } else {
                    pohlavie = "nevybraté";
                }

                // Vytvorenie Alert boxu s hodnotami
                String message = "Užívateľské meno: " + username + "\n" +
                        "Heslo: " + password + "\n" +
                        "Pohlavie: " + pohlavie;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registrácia");
                alert.setHeaderText("Zadané údaje:");
                alert.setContentText(message);
                alert.showAndWait();
            });

            zavrietButton.setOnAction(event -> {
                Platform.exit();
            });

            // Vytvorenie scény a zobrazenie
            Scene scene = new Scene(gridPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }