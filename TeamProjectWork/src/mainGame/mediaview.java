package mainGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class mediaview implements Initializable {
	public static MediaPlayer mp;
	Media m = null;
	@FXML
	private MediaView mediaView;

	public static String ending = "";
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mp = new MediaPlayer(new Media(getClass().getResource("/music/"+ending+".mp4").toString()));
		mediaView.setMediaPlayer(mp);

		mp.play();
		mp.setOnEndOfMedia(() -> {
			mp.stop();
			
		});
	}

}
