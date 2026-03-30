package sk.spse.uloha4.procedural;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;
    private Random random = new Random();

    @Override
    public void start(Stage stage) {
        // Hlavný koreňový prvok - BorderPane
        BorderPane root = new BorderPane();
        root.setPrefHeight(272.0);
        root.setPrefWidth(600.0);

        // Spodná časť - HBox s textom a tlačidlami
        HBox bottomBox = new HBox();
        bottomBox.setPrefHeight(62.0);
        bottomBox.setPrefWidth(600.0);

        // VBox s citátom
        VBox quoteBox = new VBox();
        quoteBox.setPrefWidth(100.0);
        Text quoteText = new Text("\"In the future, everyone will be world-famous for 15 minutes.\"");
        Text authorText = new Text("-Andy Warhol");
        quoteBox.getChildren().addAll(quoteText, authorText);
        HBox.setMargin(quoteBox, new Insets(10.0, 10.0, 10.0, 10.0));

        // Tlačidlo Randomize
        Button randomizeButton = new Button("Randomize");
        randomizeButton.setOnAction(event -> randomize());
        HBox.setMargin(randomizeButton, new Insets(15.0, 0.0, 0.0, 100.0));

        // Tlačidlo Close
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> javafx.application.Platform.exit());
        HBox.setMargin(closeButton, new Insets(15.0, 0.0, 0.0, 10.0));

        bottomBox.getChildren().addAll(quoteBox, randomizeButton, closeButton);
        root.setBottom(bottomBox);

        // Centrálna časť - TilePane s obrázkami
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);
        tilePane.setPrefRows(4);
        tilePane.setPrefWidth(200.0);
        tilePane.setPrefHeight(200.0);

        // Načítanie obrázka
        Image image = new Image(getClass().getResourceAsStream("soup2.png"));

        // Vytvorenie 4 VBoxov s obrázkami
        vbox1 = new VBox();
        vbox1.setPrefHeight(200.0);
        vbox1.setPrefWidth(100.0);
        vbox1.setStyle("-fx-background-color: #ffcccc;");
        ImageView imageView1 = new ImageView(image);
        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setPreserveRatio(true);
        VBox.setMargin(imageView1, new Insets(25.0, 0.0, 0.0, 0.0));
        vbox1.getChildren().add(imageView1);

        vbox2 = new VBox();
        vbox2.setPrefHeight(200.0);
        vbox2.setPrefWidth(100.0);
        vbox2.setStyle("-fx-background-color: #ffcccc;");
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setPreserveRatio(true);
        VBox.setMargin(imageView2, new Insets(25.0, 0.0, 0.0, 0.0));
        vbox2.getChildren().add(imageView2);

        vbox3 = new VBox();
        vbox3.setPrefHeight(200.0);
        vbox3.setPrefWidth(100.0);
        vbox3.setStyle("-fx-background-color: #ffcccc;");
        ImageView imageView3 = new ImageView(image);
        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(200.0);
        imageView3.setPreserveRatio(true);
        VBox.setMargin(imageView3, new Insets(25.0, 0.0, 0.0, 0.0));
        vbox3.getChildren().add(imageView3);

        vbox4 = new VBox();
        vbox4.setPrefHeight(200.0);
        vbox4.setPrefWidth(100.0);
        vbox4.setStyle("-fx-background-color: #ffcccc;");
        ImageView imageView4 = new ImageView(image);
        imageView4.setFitHeight(150.0);
        imageView4.setFitWidth(200.0);
        imageView4.setPreserveRatio(true);
        VBox.setMargin(imageView4, new Insets(25.0, 0.0, 0.0, 0.0));
        vbox4.getChildren().add(imageView4);

        tilePane.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
        root.setCenter(tilePane);

        // Vytvorenie scény
        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }

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