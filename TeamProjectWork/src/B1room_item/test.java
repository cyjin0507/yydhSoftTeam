package B1room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class test {
	@FXML
	private Button btn;
	
	public void action() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/B1room/storage.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void action2() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/B1room/prison.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
