package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.util.Locale;
import java.util.Random;

public class Controller {

    @FXML public VBox vbox1, vbox2, vbox3, vbox4;
    @FXML public ImageView image1, image2, image3, image4;

    private static Random rand = new Random();

    public static String getRandomColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public static String getRandomOpaque() {
        double x = 0.4 + (rand.nextDouble() * 0.6);
        return String.format(Locale.ROOT, "%.2f", x);
    }

    public static String getRandomRotate() {
        return String.format("%d", rand.nextInt(360));
    }

    public static String getRandomScale() {
        double x = 0.4 + (rand.nextDouble() * 1.1);
        return String.format(Locale.ROOT, "%.2f", x);
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + ";");

        image1.setStyle("-fx-opacity: " + getRandomOpaque() + "; -fx-rotate: " + getRandomRotate() + "; -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + ";");
        image2.setStyle("-fx-opacity: " + getRandomOpaque() + "; -fx-rotate: " + getRandomRotate() + "; -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + ";");
        image3.setStyle("-fx-opacity: " + getRandomOpaque() + "; -fx-rotate: " + getRandomRotate() + "; -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + ";");
        image4.setStyle("-fx-opacity: " + getRandomOpaque() + "; -fx-rotate: " + getRandomRotate() + "; -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + ";");
    }

    @FXML
    private void handleClose() {
        Platform.exit();
    }
}