package test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class mediaview implements Initializable {
	public static MediaPlayer mp;
	Media m = null;
	@FXML
	private MediaView mediaView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mp = new MediaPlayer(new Media(getClass().getResource("/music/인트로.mp4").toString()));
		mediaView.setMediaPlayer(mp);

		mp.play();
		mp.setOnEndOfMedia(() -> {
			mp.stop();
			System.out.println("테스트");
			// 여기다가 이동할부분 넣으면됨
		});
	}

}
