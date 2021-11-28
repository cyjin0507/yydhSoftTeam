package B1room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class B1item {
	@FXML
	private Button btn;
	@FXML
	private ImageView safe;
	
	public void storage() {
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
	public void prison() {
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
	public void safe(MouseEvent e) {
//		비번추가
		safe.setImage(new Image("/B1room_item/safeafter.png"));
	}
}
