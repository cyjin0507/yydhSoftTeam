package gameStart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import B1room.B1hallway2;
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
import mainGame.gameReady;
import test.passward;
import user.sort;

public class MainHoll extends sort implements Initializable {
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
		if (library) {
			imageView.setX(getX + 10);
			imageView.setY(getY);
			library = false;
		}
		if (dinnerhall) {
			imageView.setX(getX - 10);
			imageView.setY(getY);
			dinnerhall = false;
		}
		if (stair) {
			imageView.setX(getX);
			imageView.setY(getY + 10);
			stair = false;
		}
		if (new floor1room.library().mainhall) {
			imageView.setX(50);
			imageView.setY(120);
			new floor1room.library().mainhall = false;
		}
		if (new floor1room.dinnerhall().mainhall) {
			imageView.setX(1070);
			imageView.setY(120);
			new floor1room.dinnerhall().mainhall = false;
		}
	}

	public static boolean library = false;
	static boolean dinnerhall = false;
	static boolean stair = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);

//		계단 손잡이
		if ((x == 610) && (y >= 70) && (y <= 110)) {
			return "right";
		} else if ((x == 490) && (y >= 70) && (y <= 110)) {
			return "left";
		}
		if ((y == 120) && (x <= 480) && (x >= 420)) {
			return "up";
		} else if ((y == 120) && (x >= 620) && (x <= 680)) {
			return "up";
		}
		if ((x == 410) && (y >= 60) && (y <= 110)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((x == 690) && (y >= 60) && (y <= 110)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		}
//오른쪽 벽
		if ((x == 1030) && (y <= 70)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		}

		if ((x == 1080) && (y <= 290)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 300) && (x >= 1080) && (x <= 1110)) {
			if (x == 1110) {
				return "rightup";
			}
			return "up";
		}
		// 왼 벽
		if ((x == 80) && (y <= 70)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		}
		if ((x == 40) && (y <= 290)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((y == 300) && (x <= 40) && (x >= -10)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		}
		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 490) && (x <= 610)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("닫힘");
			alert.setContentText("결계가 쳐져있다");
			alert.show();
		}
		if ((x == 40) && (y >= 80) && (y <= 140)) {
			getX = x;
			getY = y;
			library = true;
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
		if ((x == 1080) && (y >= 80) && (y <= 140)) {
			getX = x;
			getY = y;
			dinnerhall = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor1room/dinnerhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 640) && (x >= 450) && (y <= 650)) {
			new floor1room.passward().ans = 33;
			try {
				Parent root = null;
				if(new gameReady().user1media) {
					root = FXMLLoader.load(getClass().getResource("/gameStart/last1.fxml"));					
				} else if(new gameReady().user2media) {
					root = FXMLLoader.load(getClass().getResource("/gameStart/last2.fxml"));					
				}
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 마지막 넘어가는거
		}

	}

	// 게임 끝났을때
	public void gameEnd() {

	}

}
