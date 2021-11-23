package B1room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gameStart.CharacterMove;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class B1hallway1 implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, setStopPoint(), imageView);
				event();

				KeyCode keyCode = event.getCode();
				if (keyCode.equals(KeyCode.SPACE)) {
					int x = (int) imageView.getX();
					int y = (int) imageView.getY();
					// 스페이스 바 이벤트
					if ((y == 60) && (x >= 50) && (x <= 240)) {
						getX = x;
						getY = y;
						pipe = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/pipegame/layout.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		move.stop(imageView);
		if (laboratory) {
			imageView.setX(getX);
			imageView.setY(getY);
			laboratory = false;
		}
		if (B1hallway2) {
			imageView.setX(getX);
			imageView.setY(new B1hallway2().getY);
			B1hallway2 = false;
		}
		if (pipe) {
			imageView.setX(getX);
			imageView.setY(getY);
			pipe = false;
		}
	}

	static boolean laboratory = false;
	static boolean B1hallway2 = false;
	static boolean pipe = false;
	
	public static boolean success = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((x == 1110) && (y >= 60) && (y <= 320)) {
			getX = x;
			getY = y;
			B1hallway2 = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/B1hallway2.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 640) && (x >= 70) && (x <= 200)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor1room/library.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 310) && (x >= 810) && (x <= 940)) {
			if(success) {
				getX = x;
				getY = y;
				laboratory = true;
				try {
					Parent root;
					root = FXMLLoader.load(getClass().getResource("/B1room/laboratory.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage) imageView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("잠김");
				alert.setHeaderText("");
				alert.setContentText("문이 잠겨있다");
				alert.showAndWait();
			}
		}

	}
}
