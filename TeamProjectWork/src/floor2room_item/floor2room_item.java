package floor2room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class floor2room_item {
	@FXML
	private ImageView grass_paper;
	@FXML
	private ImageView desk_paper;
	@FXML
	private ImageView book;

	public void grass_paper(MouseEvent e1) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("힌트");
		alert.setContentText("힌트");
		alert.show();
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) grass_paper.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void desk_paper(MouseEvent e1) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("힌트");
		alert.setContentText("상대방 힌트");
		alert.show();
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) desk_paper.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void book(MouseEvent e1) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("힌트");
		alert.setContentText("상대방 힌트");
		alert.show();
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) book.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
