package floor3room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class f3item {
	@FXML
	private Button btn;

	public void dressroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/dressroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void powderroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/powderroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void livingroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/livingroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void musicroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/musicroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guestroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/guestroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bedbottom(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room_item/bedbottomafter.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
