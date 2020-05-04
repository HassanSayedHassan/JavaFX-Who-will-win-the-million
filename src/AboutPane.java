
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class AboutPane extends StackPane implements ScreenBounds {

    Sounds mySounds = new Sounds();

    Label label = new Label("تم تصميم هذه اللعبة لتشجيع الطلاب على التعلم و لمساعدتهم في إختبار قدراتهم على الحفظ\n"
            + "اللعبة من إعداد المبرمج مجد تلجي وهي مجانية بالكامل");

    AboutButtonShape buttonShape = new AboutButtonShape(220, 40);

    Label buttonLabel = new Label("رجوع");

    VBox vBox = new VBox(30);

    public AboutPane() {
        
        this.setBackground(Main.getBGImage());

        label.setTextFill(Color.WHITE);
        label.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 18));
        label.setTextAlignment(TextAlignment.CENTER);

        buttonLabel.setPrefSize(220, 40);
        buttonLabel.setAlignment(Pos.CENTER);
        buttonLabel.setTextFill(Color.WHITE);
        buttonLabel.setFont(Font.loadFont(Main.class.getResourceAsStream("res/fonts/droidnaskh-regular-webfon.ttf"), 18));
        buttonLabel.setPadding(new Insets(-5, 0, 0, 0));

        StackPane buttonPane = new StackPane();
        buttonPane.setPrefSize(220, 40);
        buttonPane.getChildren().addAll(buttonLabel, buttonShape);

        vBox.getChildren().addAll(label, buttonPane);

        vBox.setAlignment(Pos.CENTER);
        this.getChildren().add(vBox);
        
        buttonShape.setOnMouseClicked((MouseEvent event) -> {
            mySounds.clickSound();
            Main.STAGE.getScene().setRoot(Main.PANE_MENU);
        });
    }

}
