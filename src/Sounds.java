
import javafx.scene.media.AudioClip;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class Sounds {

    AudioClip audioClip_1 = new AudioClip(getClass().getResource("res/sounds/general-click.wav").toString());
    AudioClip audioClip_2 = new AudioClip(getClass().getResource("res/sounds/playing-click.wav").toString());
    AudioClip audioClip_3 = new AudioClip(getClass().getResource("res/sounds/intro.MP3").toString());
    AudioClip audioClip_4 = new AudioClip(getClass().getResource("res/sounds/clock-tick.wav").toString());
    AudioClip audioClip_5 = new AudioClip(getClass().getResource("res/sounds/win-sound.mp3").toString());

    public void clickSound() {
        audioClip_1.play();
    }

    public void clickOnWrongAnswerSound() {
        audioClip_2.play();
    }

    public void clickOnCorrentAnswerSound() {
        audioClip_5.play();
    }

    public void introSound() {
        audioClip_3.play();
    }

    public void clockTickSound() {
        audioClip_4.play();
    }

}
