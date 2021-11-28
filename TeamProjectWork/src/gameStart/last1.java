package gameStart;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class last1 {
	
	@FXML
	private TextField ans;
	
	private static String check = "no";
	
	public void ans() throws IOException {
		if(ans.getText().equals("3")) {
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
	
	public void back() throws IOException {
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) ans.getScene().getWindow();
		primaryStage.setScene(scene);
	}

}
