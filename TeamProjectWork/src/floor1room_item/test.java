package floor1room_item;

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
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	
	
	public void action() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room/library.fxml"));
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
			root = FXMLLoader.load(getClass().getResource("/floor1room/kitchen.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn2.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void action3() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room/dinnerhall.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn3.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
