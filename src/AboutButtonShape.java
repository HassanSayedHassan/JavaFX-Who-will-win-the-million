
import javafx.beans.binding.Bindings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class AboutButtonShape extends Rectangle {

    Polygon polygon;

    public AboutButtonShape(int width, int height) {
        polygon = new Polygon(
                0, height / 2,
                20, 0,
                width - 20, 0,
                width, height / 2,
                width - 20, height,
                20, height,
                0, height / 2
        );

        polygon.setStroke(Color.color(1, 1, 1, 0.75));

        polygon.fillProperty().bind(Bindings.when(pressedProperty())
                .then(Color.color(0, 0, 0, 0.50))
                .otherwise(Color.color(0, 0, 0, 0.25)));

        this.setWidth(width);
        this.setHeight(height);

        this.setFill(Color.BLUE);
        this.setStyle("-fx-cursor: hand;");

        this.setClip(polygon);
    }

}
