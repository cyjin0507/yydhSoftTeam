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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class B1hallway2 implements Initializable {
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
			}
		});
		move.stop(imageView);

	}

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((x == -10) && (y >= 60) && (y <= 320)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/B1hallway1.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 60) && (x >= 840) && (x <= 910)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/prison.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if ((y == 310) && (x >= 810) && (x <= 940)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/storage.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 310) && (x >= 160) && (x <= 300)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/dataroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 스페이스 바 이벤트
		if ((y == 130) && (x >= 260) && (x <= 370)) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					KeyCode keyCode = event.getCode();
					if (keyCode.equals(KeyCode.SPACE)) {
//						try {
//							Parent root;
//							root = FXMLLoader.load(getClass().getResource("/btngame/MainLayout.fxml"));
//							Scene scene = new Scene(root);
//							Stage primaryStage = (Stage) imageView.getScene().getWindow();
//							primaryStage.setScene(scene);
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
					}
				}
			});
		}
	}
}
