package gameStart;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import mainGame.mediaview;
import user.sort;
import util.JDBCUtil;

public class last1 extends sort implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (check.equals("yes")) {
			try {
				if (check()) {
					new mediaview().ending = "같이_탈출";
					Parent par = FXMLLoader.load(getClass().getResource("/mainGame/mediaview.fxml"));
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) ans.getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
					gameDelete();
				} else {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("어?");
					alert.setHeaderText("아직 동료가 문제를 풀지 못했습니다");
					alert.setContentText("혼자 탈출할 경우 동료는 영원히 탈출 못합니다.");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						new mediaview().ending = "배신";
						Parent par = FXMLLoader.load(getClass().getResource("/mainGame/mediaview.fxml"));
						Scene scene = new Scene(par);
						Stage primaryStage = (Stage) ans.getScene().getWindow();
						scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
						primaryStage.setScene(scene);

					} else if (result.get() == ButtonType.CANCEL) {
						Parent root;
						root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
						Scene scene = new Scene(root);
						Stage primaryStage = (Stage) ans.getScene().getWindow();
						primaryStage.setScene(scene);
					}
				}
			} catch (UnknownHostException e) {

			} catch (IOException e) {

			}
		}
	}

	@FXML
	private TextField ans;

	private static String check = "no";

	public void ans() throws IOException {
		if (ans.getText().equals("6")) {
			trans();
			check = "yes";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("성공");
			alert.setContentText("최종 미션 성공");
			alert.show();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) ans.getScene().getWindow();
			primaryStage.setScene(scene);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("틀림");
			alert.setContentText("재도전");
			alert.show();
		}
	}
	
	public void trans() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE `game_info` SET `escape1` = 'yes' WHERE `user1` = '" + who() + "'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void back() throws IOException {
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) ans.getScene().getWindow();
		primaryStage.setScene(scene);
	}

}
