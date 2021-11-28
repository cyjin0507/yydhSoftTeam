package test;

import java.io.IOException;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mp = new MediaPlayer(new Media(getClass().getResource("/music/인트로.mp4").toString()));
		mediaView.setMediaPlayer(mp);

		mp.play();
		mp.setOnEndOfMedia(() -> {
			mp.stop();
			System.out.println("테스트");
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) mediaView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
