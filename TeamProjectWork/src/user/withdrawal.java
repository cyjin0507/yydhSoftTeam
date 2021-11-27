package user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.JDBCUtil;

public class withdrawal {

	@FXML
	private TextField input;
	@FXML
	private Label example;

	public void withdrawal() throws IOException {
		if (input.getText().equals(example.getText())) {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("프로그램 종료");
			alert.setHeaderText("잠깐! 정말로 탈퇴하시겠습니까?");
			alert.setContentText("탈퇴시 다시 정보를 복구할 수 없습니다.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				JDBCUtil db = new JDBCUtil();
				Connection con = db.getConnection();

				PreparedStatement pstmt = null;

				String sql = "DELETE FROM users WHERE nickname = '" + who() + "'";

				try {
					pstmt = con.prepareStatement(sql);

					pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("알림");
				alert2.setHeaderText("탈퇴가 정상적으로 처리되었습니다.");
				alert2.setContentText("지금까지 저희 게임을 이용해주셔서 감사합니다.");
				alert2.showAndWait();
				
				Parent par = FXMLLoader.load(getClass().getResource("/user/Login.fxml"));
				Scene scene = new Scene(par);
				Stage primaryStage = (Stage) input.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
			} else if (result.get() == ButtonType.CANCEL) {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("알림");
				alert2.setHeaderText("탈퇴 취소");
				alert2.setContentText("탈퇴가 취소 되었습니다");
				alert2.showAndWait();
			}
			
			
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림");
			alert.setHeaderText("위 문장과 똑같이 입력");
			alert.setContentText("탈퇴를 원하시면 위 문장과 똑같이 입력해주세요");
			alert.showAndWait();
		}
	}
	
	public void back() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) input.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}

	// 누가 로그인 중인지 확인
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
				String nickname = rs.getString("nickname");
				if (login.equals(ip)) {
					return nickname;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
