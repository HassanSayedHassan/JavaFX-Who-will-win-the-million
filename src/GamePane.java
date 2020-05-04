
import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class GamePane extends Pane implements ScreenBounds {

    Sounds mySounds = new Sounds();

    Button btnExit = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/res/images/Close-icon.png"))));
    Button btnBack = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/res/images/Go-back-icon.png"))));
    Button btnCallFriend = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/res/images/Phone-icon.png"))));
    Button btnAskAudience = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/res/images/User-Group-icon.png"))));
    Button btnDeleteTwoAnswers = new Button("", new ImageView(new Image(getClass().getResourceAsStream("/res/images/Number-2-icon.png"))));
    Button btnPlayGame = new Button("إبدأ الآن");
    Label timerLabel = new Label();
    StackPane playbuttonPane = new StackPane();
    ArrayList<Label> moneyLabels = new ArrayList();

    GameQuestionShape questionShape = new GameQuestionShape(640, 60);

    GameAnswerButton answer1 = new GameAnswerButton(320, 40, 320, 10);
    GameAnswerButton answer2 = new GameAnswerButton(320, 40, 0, 10);
    GameAnswerButton answer3 = new GameAnswerButton(320, 40, 320, 60);
    GameAnswerButton answer4 = new GameAnswerButton(320, 40, 0, 60);

    HBox hBox = new HBox();
    VBox vBox = new VBox();
    Pane answersPane = new Pane();
    HBox topMenuBox = new HBox(10);
    VBox moneyBox = new VBox(4);

    Questions questions;

    Question question;

    boolean isGameOver;
    int initialSeconds;
    Integer remainingSeconds;
    boolean anAnswerButtonIsClicked;
    boolean isAnswerCorrect;
    String whichButtonIsClicked;
    int correntAnswersCounter;
    int totalEarning;

    Timeline timeline;

    int hiddenButtonCounter;

    boolean aFriendIsCalled;

    boolean userIsAskingAudience;

    public void initialValues() {
        questions = new Questions();
        isGameOver = false;
        timeline = new Timeline();
        initialSeconds = 30;
        remainingSeconds = initialSeconds;
        anAnswerButtonIsClicked = false;
        isAnswerCorrect = false;
        whichButtonIsClicked = "";
        correntAnswersCounter = 0;
        totalEarning = 0;
        hiddenButtonCounter = 0;
        aFriendIsCalled = false;
        userIsAskingAudience = false;
    }

    public void playGame() {
        initialValues();
        mySounds.clickSound();
        displayNewQestion();
        checkAnswer();
    }

    public void markLastPassedLevel() {
        for (Label label : moneyLabels) {
            label.setTextFill(Color.YELLOW);
            label.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        }
        moneyLabels.get(correntAnswersCounter).setTextFill(Color.WHITE);
        moneyLabels.get(correntAnswersCounter).setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(5), Insets.EMPTY)));
        totalEarning = Integer.parseInt(moneyLabels.get(correntAnswersCounter).getText());
    }

    public void displayNewQestion() {
        if (userIsAskingAudience == true) {
            userIsAskingAudience = false;
        }

        if (aFriendIsCalled == true) {
            aFriendIsCalled = false;
        }

        if (correntAnswersCounter >= 15) {
            timeline.stop();
            ResultPane.setResult(correntAnswersCounter, totalEarning);
            Main.STAGE.getScene().setRoot(Main.PANE_RESULT);
        } else if (hiddenButtonCounter != 0) {
            hiddenButtonCounter = 0;
            answer1.show();
            answer2.show();
            answer3.show();
            answer4.show();
        }
        question = questions.getQuestion();
        Collections.shuffle(question.answers);

        answer1.setDefaultBGC();
        answer2.setDefaultBGC();
        answer3.setDefaultBGC();
        answer4.setDefaultBGC();

        questionShape.setText(question.getPhrase());
        answer1.setText(question.getAnswer(0).getText());
        answer2.setText(question.getAnswer(1).getText());
        answer3.setText(question.getAnswer(2).getText());
        answer4.setText(question.getAnswer(3).getText());
        System.out.println("--------------------------------");
        System.out.println(question.getAnswer(0).isCorrect());
        System.out.println(question.getAnswer(1).isCorrect());
        System.out.println(question.getAnswer(2).isCorrect());
        System.out.println(question.getAnswer(3).isCorrect());
    }

    public void displayResult() {
        timeline.stop();
        ResultPane.setResult(correntAnswersCounter, totalEarning);
        Main.STAGE.getScene().setRoot(Main.PANE_RESULT);
    }

    public void checkAnswer() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {

            if (remainingSeconds == 0) {
                timerLabel.setText("إنتهى الوقت");
                remainingSeconds = -5;
                isAnswerCorrect = false;
                anAnswerButtonIsClicked = true;
            } else if (anAnswerButtonIsClicked == false) {
                if (aFriendIsCalled == true) {
                    if (remainingSeconds == 40) {
                        timerLabel.setText("يتم الآن الإتصال بصديقك");
                    } else if (remainingSeconds == 37) {
                        timerLabel.setText("مرحبا بك أيها الصديق");
                    } else if (remainingSeconds == 34) {
                        timerLabel.setText("معك 30 ثانية للإجابة على السؤال التالي");
                    } else if (remainingSeconds == 30) {
                        timerLabel.setText(question.getPhrase());
                    } else if (remainingSeconds == 22) {
                        timerLabel.setText("أعتقد أن الجواب الصحيح هو");
                    } else if (remainingSeconds == 18) {
                        if (question.getAnswer(0).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(0).getText());
                        } else if (question.getAnswer(1).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(1).getText());
                        } else if (question.getAnswer(2).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(2).getText());
                        } else if (question.getAnswer(3).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(3).getText());
                        }
                    } else if (remainingSeconds == 1) {
                        aFriendIsCalled = false;
                        remainingSeconds = initialSeconds;
                    }
                } else if (userIsAskingAudience == true) {
                    if (remainingSeconds == 40) {
                        timerLabel.setText("سيساعدك الآن الجمهور باختيار الإجابة الصحيحة");
                    } else if (remainingSeconds == 35) {
                        timerLabel.setText("النسبة الأكبر من الأصوات إختارت الإجابة");
                    } else if (remainingSeconds == 30) {
                        if (question.getAnswer(0).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(0).getText());
                        } else if (question.getAnswer(1).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(1).getText());
                        } else if (question.getAnswer(2).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(2).getText());
                        } else if (question.getAnswer(3).isCorrect == true) {
                            timerLabel.setText(question.getAnswer(3).getText());
                        }
                    } else if (remainingSeconds == 20) {
                        userIsAskingAudience = false;
                        remainingSeconds = initialSeconds;
                    }
                } else {
                    timerLabel.setText(remainingSeconds.toString());
                }
                remainingSeconds--;
            } else if (anAnswerButtonIsClicked == true) {

                if (remainingSeconds > 0) {
                    remainingSeconds = 0;
                }

                remainingSeconds--;

                if (remainingSeconds <= -2 && remainingSeconds >= -5) {
                    if (isAnswerCorrect == true) {
                        timerLabel.setText("الإجابة صحيحة");
                    } else {
                        timerLabel.setText("الإجابة غير صحيحة");
                        switch (whichButtonIsClicked) {
                            case "answer1":
                                answer1.setLooseBGC();
                                break;
                            case "answer2":
                                answer2.setLooseBGC();
                                break;
                            case "answer3":
                                answer3.setLooseBGC();
                                break;
                            case "answer4":
                                answer4.setLooseBGC();
                                break;
                        }
                        if (remainingSeconds == -3) {
                            if (question.getAnswer(0).isCorrect == true) {
                                answer1.setWinBGC();
                            } else if (question.getAnswer(1).isCorrect == true) {
                                answer2.setWinBGC();
                            } else if (question.getAnswer(2).isCorrect == true) {
                                answer3.setWinBGC();
                            } else if (question.getAnswer(3).isCorrect == true) {
                                answer4.setWinBGC();
                            }
                        }
                    }
                } else if (remainingSeconds <= -6 && remainingSeconds >= -9) {
                    if (isAnswerCorrect == true) {
                        if (remainingSeconds == -6) {
                            timerLabel.setText("أصبح رصيدك" + moneyLabels.get(correntAnswersCounter).getText());
                            markLastPassedLevel();
                            correntAnswersCounter++;
                        }

                        if (correntAnswersCounter == 15 && remainingSeconds == -9) {
                            displayResult();
                        }
                    } else if (remainingSeconds == -9) {
                        displayResult();
                    }
                } else if (remainingSeconds <= -10 && remainingSeconds >= -13) {
                    timerLabel.setText("إستعد للسؤال التالي");
                } else if (remainingSeconds <= -14 && remainingSeconds >= -16) {
                    if (remainingSeconds == -16) {
                        anAnswerButtonIsClicked = false;
                        remainingSeconds = initialSeconds;
                        displayNewQestion();
                    }
                }
            }

            if (remainingSeconds >= 0
                    && remainingSeconds < 10
                    && aFriendIsCalled == false
                    && userIsAskingAudience == false) {
                mySounds.clockTickSound();
            }
        }));
        timeline.playFromStart();
    }

    public GamePane() {

        answer1.setOnMousePressed((MouseEvent event) -> {
            if (anAnswerButtonIsClicked == false) {
                answer1.setWinBGC();
                if (question.getAnswer(0).isCorrect == true) {
                    mySounds.clickOnCorrentAnswerSound();
                    isAnswerCorrect = true;
                } else {
                    mySounds.clickOnWrongAnswerSound();
                    isAnswerCorrect = false;
                }
                anAnswerButtonIsClicked = true;
                whichButtonIsClicked = "answer1";
            }
        });

        answer2.setOnMousePressed((MouseEvent event) -> {
            if (anAnswerButtonIsClicked == false) {
                answer2.setWinBGC();
                if (question.getAnswer(1).isCorrect == true) {
                    mySounds.clickOnCorrentAnswerSound();
                    isAnswerCorrect = true;
                } else {
                    mySounds.clickOnWrongAnswerSound();
                    isAnswerCorrect = false;
                }
                anAnswerButtonIsClicked = true;
                whichButtonIsClicked = "answer2";
            }
        });

        answer3.setOnMousePressed((MouseEvent event) -> {
            if (anAnswerButtonIsClicked == false) {
                answer3.setWinBGC();
                if (question.getAnswer(2).isCorrect == true) {
                    mySounds.clickOnCorrentAnswerSound();
                    isAnswerCorrect = true;
                } else {
                    mySounds.clickOnWrongAnswerSound();
                    isAnswerCorrect = false;
                }
                anAnswerButtonIsClicked = true;
                whichButtonIsClicked = "answer3";
            }
        });

        answer4.setOnMousePressed((MouseEvent event) -> {
            if (anAnswerButtonIsClicked == false) {
                answer4.setWinBGC();
                if (question.getAnswer(3).isCorrect == true) {
                    mySounds.clickOnCorrentAnswerSound();
                    isAnswerCorrect = true;
                } else {
                    mySounds.clickOnWrongAnswerSound();
                    isAnswerCorrect = false;
                }
                anAnswerButtonIsClicked = true;
                whichButtonIsClicked = "answer4";
            }
        });

        this.setPrefSize(WIDTH, HEIGHT);
        setGameImage();

        answersPane.setPrefSize(640, 100);
        moneyBox.setPrefSize(130, 510);

        btnExit.setPrefSize(100, 50);
        btnBack.setPrefSize(100, 50);
        btnCallFriend.setPrefSize(100, 50);
        btnAskAudience.setPrefSize(100, 50);
        btnDeleteTwoAnswers.setPrefSize(100, 50);

        timerLabel.setPrefSize(640, 300);
        timerLabel.setFont(new Font(30));
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setContentDisplay(ContentDisplay.CENTER);
        timerLabel.setAlignment(Pos.CENTER);

        String btnStyle
                = "-fx-focus-color: transparent;"
                + "-fx-border-width: 2px;"
                + "-fx-border-color: #87cefa;"
                + "-fx-border-radius: 50;"
                + "-fx-background-radius: 50;"
                + "-fx-background-color: rgba(30,30,30,0.5);"
                + "-fx-cursor: hand;";
        btnExit.setStyle(btnStyle);
        btnBack.setStyle(btnStyle);
        btnCallFriend.setStyle(btnStyle);
        btnAskAudience.setStyle(btnStyle);
        btnDeleteTwoAnswers.setStyle(btnStyle);

        btnStyle
                = "-fx-focus-color: transparent;"
                + "-fx-border-width: 2px;"
                + "-fx-border-color: #00f;"
                + "-fx-border-radius: 10;"
                + "-fx-text-fill: white;"
                + "-fx-background-color: rgba(30,30,30,0.5);"
                + "-fx-cursor: hand;"
                + "-fx-font-size: 18px;"
                + "-fx-padding: 10 0 10 0;"
                + "-fx-pref-width: 220;"
                + "-fx-pref-height: 40;";

        btnPlayGame.setStyle(btnStyle);

        playbuttonPane.setPrefSize(640, 300);
        playbuttonPane.getChildren().add(btnPlayGame);

        topMenuBox.setPadding(new Insets(0, 0, 0, 50));

        topMenuBox.getChildren().addAll(btnExit, btnBack, btnCallFriend, btnAskAudience, btnDeleteTwoAnswers);
        answersPane.getChildren().addAll(answer1.getPane(), answer2.getPane(), answer3.getPane(), answer4.getPane());
        vBox.getChildren().addAll(topMenuBox, playbuttonPane, questionShape, answersPane);
        hBox.getChildren().addAll(vBox, moneyBox);

        hBox.autosize();

        hBox.setTranslateX((WIDTH / 2) - (hBox.getWidth() / 2));
        hBox.setTranslateY((HEIGHT / 2) - (hBox.getHeight() / 2));

        this.getChildren().add(hBox);
        addMoneyBox();

        btnExit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        btnBack.setOnAction((ActionEvent event) -> {
            questionShape.setText("");
            mySounds.clickSound();
            Main.STAGE.getScene().setRoot(Main.PANE_MENU);
            timeline.stop();
            timeline = null;
            questions = null;
            vBox.getChildren().set(1, playbuttonPane);
            answer1.setText("");
            answer1.setDefaultBGC();
            answer1.setVisible(true);
            answer2.setText("");
            answer2.setDefaultBGC();
            answer2.setVisible(true);
            answer3.setText("");
            answer3.setDefaultBGC();
            answer3.setVisible(true);
            answer4.setText("");
            answer4.setDefaultBGC();
            answer4.setVisible(true);
            initialValues();
            btnCallFriend.setDisable(false);
            btnAskAudience.setDisable(false);
            btnDeleteTwoAnswers.setDisable(false);
        });

        btnCallFriend.setOnAction((ActionEvent event) -> {
            mySounds.clickSound();
            btnCallFriend.setDisable(true);
            remainingSeconds = 40;
            aFriendIsCalled = true;
        });

        btnAskAudience.setOnAction((ActionEvent event) -> {
            mySounds.clickSound();
            btnAskAudience.setDisable(true);
            remainingSeconds = 40;
            userIsAskingAudience = true;
        });

        btnDeleteTwoAnswers.setOnAction((ActionEvent event) -> {
            mySounds.clickSound();
            btnDeleteTwoAnswers.setDisable(true);

            if (question.getAnswer(0).isCorrect == false && hiddenButtonCounter < 2) {
                answer1.hide();
                hiddenButtonCounter++;
            }

            if (question.getAnswer(1).isCorrect == false && hiddenButtonCounter < 2) {
                answer2.hide();
                hiddenButtonCounter++;
            }

            if (question.getAnswer(2).isCorrect == false && hiddenButtonCounter < 2) {
                answer3.hide();
                hiddenButtonCounter++;
            }

            if (question.getAnswer(3).isCorrect == false && hiddenButtonCounter < 2) {
                answer4.hide();
                hiddenButtonCounter++;
            }
        });

        btnPlayGame.setOnAction((ActionEvent event) -> {
            vBox.getChildren().set(1, timerLabel);
            playGame();
        });

    }

    public void setGameImage() {
        this.setBackground(Main.getBGImage());
    }

    public void addMoneyBox() {
        moneyLabels.add(new Label("100"));
        moneyLabels.add(new Label("200"));
        moneyLabels.add(new Label("300"));
        moneyLabels.add(new Label("500"));
        moneyLabels.add(new Label("1000"));
        moneyLabels.add(new Label("2000"));
        moneyLabels.add(new Label("4000"));
        moneyLabels.add(new Label("8000"));
        moneyLabels.add(new Label("16000"));
        moneyLabels.add(new Label("22000"));
        moneyLabels.add(new Label("64000"));
        moneyLabels.add(new Label("125000"));
        moneyLabels.add(new Label("250000"));
        moneyLabels.add(new Label("500000"));
        moneyLabels.add(new Label("1000000"));

        for (int i = moneyLabels.size() - 1; i > -1; i--) {
            moneyLabels.get(i).setAlignment(Pos.CENTER);
            moneyLabels.get(i).setStyle(
                    "-fx-border-color: #aaa;"
                    + "-fx-border-radius: 5;"
                    + "-fx-background-color: black;"
                    + "-fx-text-fill: yellow;"
                    + "-fx-font-family: calibry;"
                    + "-fx-font-size: 17px;"
                    + "-fx-text-alignment: center;"
                    + "-fx-pref-width: 120px;"
                    + "-fx-pref-height: 30px;"
            );
            moneyBox.getChildren().add(moneyLabels.get(i));
        }
        moneyBox.setAlignment(Pos.CENTER_RIGHT);
    }
}
