
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class ResultPane extends StackPane implements ScreenBounds {

    Sounds mySounds = new Sounds();

    static Label label = new Label();
    Button buttonClose = new Button("خروج");
    Button buttonRetry = new Button("إلعب من جديد");
    VBox vBox = new VBox(20);

    public ResultPane() {
        this.setBackground(Main.getBGImage());

        String labelStyle
                = "-fx-text-fill: white;"
                + "-fx-font-size: 24;"
                + "-fx-padding: 0 0 20 0;"
                + "-fx-alignment: CENTER;";

        String btnStyle
                = "-fx-focus-color: transparent; "
                + "-fx-border-widht: 2;"
                + "-fx-border-color: #00f;"
                + "-fx-border-radius: 10;"
                + "-fx-text-fill: white;"
                + "-fx-background-color: rgba(30,30,30,0.5);"
                + "-fx-cursor: hand;"
                + "-fx-font-size: 18;"
                + "-fx-padding: 10 0 10 0;"
                + "-fx-pref-width: 220;"
                + "-fx-pref-height: 40;"
                + "-fx-padding: 10 0 10 0;";

        label.setStyle(labelStyle);
        buttonClose.setStyle(btnStyle);
        buttonRetry.setStyle(btnStyle);

        vBox.getChildren().addAll(label, buttonRetry, buttonClose);
        vBox.setAlignment(Pos.CENTER);

        this.getChildren().add(vBox);

        buttonRetry.setOnAction((ActionEvent event) -> {
            mySounds.clickSound();
            Main.STAGE.getScene().setRoot(new GamePane());
        });

        buttonClose.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
    }

    public static void setResult(int answeredQuestions, int totalEarning) {
        if (answeredQuestions == 0) {
            label.setText("لم تعرف إجابة أي سؤال لذلك لم تفز بأي مبلغ !");
        } else if (answeredQuestions < 15) {
            label.setText("لقد تخطيت السؤال رقم "
                    + answeredQuestions + " و فزت بمبلغ "
                    + totalEarning + " €");
        } else if (answeredQuestions == 15) {
            label.setText("لقد تخطيت جميع الأسئلة و فزت بمبلغ"
                    + totalEarning + " €");
        }
    }

}
