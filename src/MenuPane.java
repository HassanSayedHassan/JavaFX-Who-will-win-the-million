
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class MenuPane extends Pane implements ScreenBounds {

    Text title = new Text("من سيربح المليون");
    VBox vBox = new VBox(5);
    Line line = new Line();
    Sounds mySounds = new Sounds();

    private void addLine() {
        double xStart = (WIDTH / 2) + 110;
        double yStart = (HEIGHT / 2) - (vBox.getChildren().size() * 40 / 2);

        double xEnd = xStart;
        double yEnd = (HEIGHT / 2) + (vBox.getChildren().size() * 40 / 2) + (vBox.getChildren().size() * 5) - 5;

        line = new Line(xStart, yStart, xEnd, yEnd);
        line.setStrokeWidth(3);
        line.setStroke(Color.color(0, 0, 1, 0.75));
        line.setEffect(new DropShadow(5, Color.BLACK));
        line.setScaleY(0);

        this.getChildren().add(line);
    }

    private void startAnimation() {
        ScaleTransition st1 = new ScaleTransition(Duration.seconds(1));
        st1.setNode(title);
        st1.setToY(1);
        st1.play();

        ScaleTransition st2 = new ScaleTransition(Duration.seconds(1));
        st2.setDelay(Duration.seconds(1));
        st2.setNode(line);
        st2.setToY(1);
        st2.setOnFinished((ActionEvent event) -> {

            for (int i = 0; i < vBox.getChildren().size(); i++) {
                Node n = vBox.getChildren().get(i);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(1 + i * 0.15), n);
                tt.setToX(0);
                tt.setOnFinished(e2 -> n.setClip(null));
                tt.play();
            }
        });
        st2.play();
    }

    private void addVBox() {
        double x = (WIDTH / 2) - (220 / 2);
        double y = (HEIGHT / 2) - (vBox.getChildren().size() * 40 / 2);

        vBox.setTranslateX(x);
        vBox.setTranslateY(y);

        this.getChildren().add(vBox);
    }

    private void addTitle() {
        title.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 36));
        title.setFill(Color.WHITE);
        title.setEffect(new DropShadow(30, Color.BLACK));

        title.setTranslateX(WIDTH / 2 - title.getLayoutBounds().getWidth() / 2);
        title.setTranslateY(HEIGHT / 3);
        title.setScaleY(0);

        this.getChildren().add(title);
    }

    private void addItems() {

        MenuItemShape item1 = new MenuItemShape(220, 40);
        MenuItemShape item2 = new MenuItemShape(220, 40);
        MenuItemShape item3 = new MenuItemShape(220, 40);

        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();

        pane1.setPrefSize(220, 40);
        pane2.setPrefSize(220, 40);
        pane3.setPrefSize(220, 40);

        Label label1 = new Label("إبدأ التحدي");
        label1.setPrefSize(220, 40);
        label1.setAlignment(Pos.CENTER_RIGHT);
        label1.setPadding(new Insets(-5, 15, 0, 0));
        label1.setFont(Font.loadFont(getClass().getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 14));
        label1.setTextFill(Color.WHITE);

        Label label2 = new Label("حول اللعبة");
        label2.setPrefSize(220, 40);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setPadding(new Insets(-5, 15, 0, 0));
        label2.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 14));
        label2.setTextFill(Color.WHITE);

        Label label3 = new Label("خروج من اللعبة");
        label3.setPrefSize(220, 40);
        label3.setAlignment(Pos.CENTER_RIGHT);
        label3.setPadding(new Insets(-5, 15, 0, 0));
        label3.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 14));
        label3.setTextFill(Color.WHITE);

        pane1.getChildren().addAll(label1, item1);
        pane2.getChildren().addAll(label2, item2);
        pane3.getChildren().addAll(label3, item3);

        pane1.setTranslateX(220);
        Rectangle clip1 = new Rectangle(220, 40);
        pane1.setClip(clip1);
        clip1.translateXProperty().bind(pane1.translateXProperty().negate());

        pane2.setTranslateX(220);
        Rectangle clip2 = new Rectangle(220, 40);
        pane2.setClip(clip2);
        clip2.translateXProperty().bind(pane2.translateXProperty().negate());

        pane3.setTranslateX(220);
        Rectangle clip3 = new Rectangle(220, 40);
        pane3.setClip(clip3);
        clip3.translateXProperty().bind(pane3.translateXProperty().negate());

        vBox.getChildren().addAll(pane1, pane2, pane3);

        item1.setOnMouseClicked((MouseEvent event) -> {
            mySounds.clickSound();
            Main.STAGE.getScene().setRoot(Main.PANE_GAME);
        });

        item2.setOnMouseClicked((MouseEvent event) -> {
            mySounds.clickSound();
            Main.STAGE.getScene().setRoot(Main.PANE_ABOUT);
        });

        item3.setOnMouseClicked((MouseEvent event) -> {
            Platform.exit();
        });
    }

    public MenuPane() {
        setPrefSize(WIDTH, HEIGHT);
        setBackground(Main.getBGImage());
        addItems();
        addTitle();
        addLine();
        addVBox();
        startAnimation();
        mySounds.introSound();
    }

}
