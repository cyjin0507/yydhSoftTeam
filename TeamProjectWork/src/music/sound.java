package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class sound {

	MediaPlayer mp;
	Media m = null;

	public void main() {
		mp = new MediaPlayer(new Media(getClass().getResource("/mp3/clickBtn.mp3").toString()));
		mp.play();
	}

}
