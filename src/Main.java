
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage STAGE;
    static Pane PANE_MENU = new MenuPane();
    static Pane PANE_ABOUT = new AboutPane();
    static Pane PANE_RESULT = new ResultPane();
    static Pane PANE_GAME = new GamePane();

    @Override
    public void start(Stage stageStart) throws Exception {

        STAGE = stageStart;
        STAGE.setFullScreen(true);
        STAGE.setResizable(false);
        STAGE.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        STAGE.getIcons().add(new Image(Main.class.getResourceAsStream("res/images/icon.png")));
        STAGE.setTitle("من سيربح المليون - أسئلة إسلامية");

        STAGE.setScene(new Scene(PANE_MENU));

        STAGE.show();
    }

    public static Background getBGImage() {
        BackgroundImage myBI = new BackgroundImage(
                new Image("res/images/black-wallpaper.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return new Background(myBI);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
