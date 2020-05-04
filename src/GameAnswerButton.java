
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class GameAnswerButton extends Rectangle {

    Polygon clip;
    Label label = new Label();
    Pane pane = new Pane();

    GameAnswerButton(int width, int height, int x, int y) {

        clip = new Polygon(
                0, height / 2,
                20, height / 2,
                40, 0,
                width - 40, 0,
                width - 20, height / 2,
                width, height / 2,
                width - 20, height / 2,
                width - 40, height,
                40, height,
                20, height / 2
        );

        clip.setStroke(Color.color(1, 1, 1, 0.75));

        clip.fillProperty().bind(Bindings.when(pressedProperty())
                .then(Color.color(0, 0, 0, 0.50))
                .otherwise(Color.color(0, 0, 0, 0.25)));

        this.setWidth(width);
        this.setHeight(height);

        this.setDefaultBGC();
        this.setStyle("-fx-cursor: hand;");

        this.setClip(clip);

        label.setFont(new Font(16));
        label.setTextFill(Color.WHITE);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setPrefSize(width, height);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setPadding(new Insets(-5, 45, 0, 45));

        pane.getChildren().addAll(label, this);
        pane.setTranslateX(x);
        pane.setTranslateY(y);
        pane.setPrefSize(width, height);
    }

    public void setWinBGC() {
        this.setFill(Color.GREEN);
    }

    public void setLooseBGC() {
        this.setFill(Color.ORANGE);
    }

    public void setDefaultBGC() {
        this.setFill(Color.BLUE);
    }

    public void setText(String s) {
        this.label.setText(s);
    }

    public String getText() {
        return this.label.getText();
    }

    public Pane getPane() {
        return this.pane;
    }

    public void hide() {
        this.setVisible(false);
        this.label.setVisible(false);
    }

    public void show() {
        this.setVisible(true);
        this.label.setVisible(true);
    }

}
