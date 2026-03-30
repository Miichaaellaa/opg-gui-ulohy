package sk.spse.uloha5.procedural;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Application extends javafx.application.Application {

    public record Jedlo(Integer id, String nazov, Integer kalorie, Double cena) {}

    private TableView<Jedlo> tabulka;
    private List<Jedlo> jedloList = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        // Hlavný koreňový prvok - BorderPane
        BorderPane root = new BorderPane();
        root.setPrefHeight(400.0);
        root.setPrefWidth(600.0);

        // Horná časť - nadpis
        Text nadpis = new Text("Zoznam potravín");
        nadpis.setFont(new Font(25.0));
        nadpis.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        BorderPane.setMargin(nadpis, new Insets(20.0, 0.0, 20.0, 0.0));
        root.setTop(nadpis);

        // Centrálna časť - TableView
        tabulka = createTableView();
        root.setCenter(tabulka);

        // Spodná časť - HBox s tlačidlami
        HBox bottomBox = createBottomBox();
        root.setBottom(bottomBox);

        // Vytvorenie scény
        Scene scene = new Scene(root);
        stage.setTitle("Zoznam potravín");
        stage.setScene(scene);
        stage.show();
    }

    private TableView<Jedlo> createTableView() {
        TableView<Jedlo> tableView = new TableView<>();
        tableView.setPrefHeight(200.0);
        tableView.setPrefWidth(200.0);

        // Vytvorenie stĺpcov
        TableColumn<Jedlo, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setPrefWidth(50.0);

        TableColumn<Jedlo, String> nazovColumn = new TableColumn<>("Názov");
        nazovColumn.setPrefWidth(300.0);
        nazovColumn.setMinWidth(50.0);

        TableColumn<Jedlo, Integer> kalorieColumn = new TableColumn<>("Kalórie");
        kalorieColumn.setPrefWidth(100.0);

        TableColumn<Jedlo, Double> cenaColumn = new TableColumn<>("Cena");
        cenaColumn.setPrefWidth(75.0);

        // Nastavenie cell value factories
        idColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().id()).asObject());
        nazovColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().nazov()));
        kalorieColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().kalorie()).asObject());
        cenaColumn.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().cena()).asObject());

        // Pridanie stĺpcov do tabuľky
        tableView.getColumns().addAll(idColumn, nazovColumn, kalorieColumn, cenaColumn);

        // Nastavenie politiky zmeny veľkosti stĺpcov
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        // Naplnenie zoznamu testovacími dátami
        jedloList.add(new Jedlo(1, "Jablko", 52, 0.50));
        jedloList.add(new Jedlo(2, "Banán", 89, 0.60));
        jedloList.add(new Jedlo(3, "Chlieb", 265, 1.20));
        jedloList.add(new Jedlo(4, "Mlieko", 42, 0.90));
        jedloList.add(new Jedlo(5, "Syr", 402, 2.50));

        // Nastavenie údajov do tabuľky
        tableView.getItems().setAll(jedloList);

        return tableView;
    }

    private HBox createBottomBox() {
        HBox hbox = new HBox();
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);

        // Tlačidlo Pridaj potravinu
        Button addButton = new Button("Pridaj potravinu");
        addButton.setOnAction(event -> handleAdd());
        HBox.setMargin(addButton, new Insets(0.0, 0.0, 0.0, 360.0));

        // Tlačidlo Vymaž
        Button deleteButton = new Button("Vymaž");
        deleteButton.setOnAction(event -> handleDelete());
        HBox.setMargin(deleteButton, new Insets(0.0, 0.0, 0.0, 10.0));

        // Tlačidlo Zatvor
        Button closeButton = new Button("Zatvor");
        closeButton.setOnAction(event -> Platform.exit());
        HBox.setMargin(closeButton, new Insets(0.0, 0.0, 0.0, 10.0));

        hbox.getChildren().addAll(addButton, deleteButton, closeButton);

        return hbox;
    }

    private void handleAdd() {
        int newId = jedloList.size() + 1;
        Jedlo newJedlo = new Jedlo(newId, "Nová potravina", 100, 1.00);
        jedloList.add(newJedlo);
        tabulka.getItems().add(newJedlo);
    }

    private void handleDelete() {
        Jedlo selected = tabulka.getSelectionModel().getSelectedItem();
        if (selected != null) {
            jedloList.remove(selected);
            tabulka.getItems().remove(selected);
        }
    }
}