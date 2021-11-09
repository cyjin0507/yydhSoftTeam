package user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.JDBCUtil;

public class userInfoController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dispaly();
		
	}
	

	@FXML
	private Label userId;
	@FXML
	private Label userPw;
	@FXML
	private Label userName;
	@FXML
	private Label userNick;
	@FXML
	private Label userSerial;

	// 유저 정보 표시
	public void dispaly() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();
						
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("pw");
				String name = rs.getString("name");
				String nick = rs.getString("nickname");
				String serial = rs.getString("serial_number");
				if(id.equals(who())) {
					userId.setText(id);
					userPw.setText(password);
					userName.setText(name);
					userNick.setText(nick);
					userSerial.setText(serial);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 누가 로그인 중인지 확인 (아이디 배출)
	public String who() throws UnknownHostException {

		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();

		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String login = rs.getString("login");
				String id = rs.getString("id");
				if (login.equals(ip)) {
					return id;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
	public void backInfo() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) userName.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
