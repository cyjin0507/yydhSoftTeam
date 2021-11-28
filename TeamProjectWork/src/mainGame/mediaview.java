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
			
			try {
				System.out.println(sorting());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(sorting().equals("user1")) {
					Parent par = null;
					try {
						par = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) mediaView.getScene().getWindow();
					scene.getStylesheets()
							.add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
				} else if(sorting().equals("user2")) {
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
			} catch (UnknownHostException e) {
			}
		});
	}
	
	public String sorting() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_info WHERE `user1` = '" + who() + "' OR `user2` = '" + who() + "'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String user1 = rs.getString("user1");
				String user2 = rs.getString("user2");
				if (user1.equals(who())) {
					return "user1";
				} else if (user2.equals(who())) {
					return "user2";
				}
					
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
