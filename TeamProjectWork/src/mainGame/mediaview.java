package mainGame;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.ResultSet;
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
import util.JDBCUtil;

public class mediaview extends gameReady implements Initializable {
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
			
			
		
				if(new gameReady().user1media) {
					Parent par = null;
					try {
						par = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) mediaView.getScene().getWindow();
					scene.getStylesheets()
							.add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
				} else if(new gameReady().user2media) {
					Parent par = null;
					try {
						par = FXMLLoader.load(getClass().getResource("/B1room/prison.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) mediaView.getScene().getWindow();
					scene.getStylesheets()
							.add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
				}
		});
	}
	

}
