package user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.JDBCUtil;

public class mainPage {

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

	public void logout() throws IOException {
		try {
			transOffLine();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
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
