package user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class explanation {
	
	@FXML
	private Button back;
	
	public void back() throws IOException {
		Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
		Scene scene = new Scene(par);
		Stage primaryStage = (Stage) back.getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}
	
}
