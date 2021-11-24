package floor2room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import B1room.B1hallway2;
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

public class stair implements Initializable {
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
		if (stair) {
			imageView.setX(getX);
			imageView.setY(getY);
			stair = false;
		}
		if (mainhall) {
			imageView.setX(getX);
			imageView.setY(getY);
			mainhall = false;
		}
		if (floor2hallway) {
			imageView.setX(getX);
			imageView.setY(new floor2hallway().getY);
			floor2hallway = false;
		}
		if (bedroom) {
			imageView.setX(getX);
			imageView.setY(getY);
			bedroom = false;
		}
		if (study) {
			imageView.setX(getX);
			imageView.setY(getY);
			study = false;
		}

	}

	static boolean stair = false;
	static boolean mainhall = false;
	static boolean floor2hallway = false;
	static boolean bedroom = false;
	static boolean study = false;

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
		// 아래 계단
		if ((x == 260) && (y >= 60) && (y <= 90)) {
			getX = x;
			getY = y;
			mainhall = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((x == 840) && (y >= 60) && (y <= 90)) {
			getX = x;
			getY = y;
			mainhall = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 위 계단
		if ((x == 190) && (y >= 110) && (y <= 220)) {
			getX = x;
			getY = y;
			stair = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((x == 910) && (y >= 110) && (y <= 220)) {
			getX = x;
			getY = y;
			stair = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 오른쪽 복도
		if ((x == 1110) && (y >= 60) && (y <= 640)) {
			getX = x;
			getY = y;
			floor2hallway = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/floor2hallway.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 방들
		if ((y == 640) && (x >= 120) && (x <= 290)) {
			getX = x;
			getY = y;
			bedroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/bedroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 640) && (x >= 810) && (x <= 970)) {
			getX = x;
			getY = y;
			study = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
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