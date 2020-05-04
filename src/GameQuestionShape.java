
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class GameQuestionShape extends Pane {

    Label label = new Label();

    public GameQuestionShape(int width, int height) {

        Polyline polyline = new Polyline(
                0, 30,
                20, 30,
                40, 0,
                600, 0,
                620, 30,
                640, 30,
                620, 30,
                600, 60,
                40, 60,
                20, 30
        );

        polyline.setStroke(Color.color(1, 1, 1, 0.75));

        label.setTranslateX(0);
        label.setTranslateY(0);
        label.setPrefSize(width, height);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setPadding(new Insets(-10, 40, 0, 40));
        label.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 16));
        label.setTextFill(Color.WHITE);

        getChildren().addAll(polyline, label);
    }

    public void setText(String s) {
        this.label.setText(s);
    }

}
