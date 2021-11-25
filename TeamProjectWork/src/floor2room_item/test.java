package floor2room_item;

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
			root = FXMLLoader.load(getClass().getResource("/floor2room/drawingroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
