package sk.spse.uloha5.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private TableView<Jedlo> tabulka;

    @FXML
    private TableColumn<Jedlo, Integer> id;

    @FXML
    private TableColumn<Jedlo, String> nazov;

    @FXML
    private TableColumn<Jedlo, Integer> kalorie;

    @FXML
    private TableColumn<Jedlo, Double> cena;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;

    private List<Jedlo> jedloList = new ArrayList<>();

    {
        jedloList.add(new Jedlo(0, "Chlieb", 200, 2.0));
        jedloList.add(new Jedlo(1, "Mlieko", 300, 0.65));
        jedloList.add(new Jedlo(2, "Kebab", 500, 12.5));
        jedloList.add(new Jedlo(3, "Coca Cola", 30, 1.39));
        jedloList.add(new Jedlo(4, "Jablko", 50, 0.99));
    }

    public void initialize(){
        id.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().id()).asObject());
        nazov.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().nazov()));
        kalorie.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().kalorie()).asObject());
        cena.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().cena()).asObject());
        tabulka.getItems().setAll(jedloList);
    }

    @FXML
    private void handleDelete() {
        Jedlo selected = tabulka.getSelectionModel().getSelectedItem();
        if (selected != null) {
            jedloList.remove(selected);
            tabulka.getItems().remove(selected);
        }
    }

    @FXML
    private void handleClose() {
        Platform.exit();
    }
}