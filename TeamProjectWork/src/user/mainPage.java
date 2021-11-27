package user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import util.JDBCUtil;

public class mainPage implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		MediaPlayer mp;
		Media m = null;
		
		mp = new MediaPlayer(new Media(getClass().getResource("/music/메인화면.mp3").toString()));
        mp.play();
    
	}

	@FXML
	private Button gameStart;

	public void gameStart() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/mainGame/request.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) gameStart.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}

	public void friend() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/user/friendList.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) gameStart.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}

	public void myInfo() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/user/myInfo.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) gameStart.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}
	public void character() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/user/character.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) gameStart.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}

	public void logout() throws IOException {
		try {
			transOffLine();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		Parent par = FXMLLoader.load(getClass().getResource("/user/Login.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) gameStart.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}

	// 오프라인으로 변경
	public void transOffLine() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();

		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE `users` SET `login`= 'offLine' WHERE login = '" + ip + "'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
