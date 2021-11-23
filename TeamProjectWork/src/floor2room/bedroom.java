package floor2room;

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

public class bedroom implements Initializable {
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
					if ((y == 105) && (x <= 270) && (x >= 220)) {
						getX = x;
						getY = y;
						findObject = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/findHiddenObject/play.fxml"));
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
		if (stair) {
			imageView.setX(getX);
			imageView.setY(new stair().getY);
			stair = false;
		}
		if (powderroom) {
			imageView.setX(getX);
			imageView.setY(getY);
			powderroom = false;
		}
		if (findObject) {
			imageView.setX(getX);
			imageView.setY(getY);
			findObject = false;
		}
	}

	static boolean stair = false;
	static boolean powderroom = false;
	static boolean findObject = false;
	public static boolean success = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		CharacterMove move = new CharacterMove();

//		침대랑 전등이랑 전부다
		if ((x == 270) && (y <= 185) && (y >= 115)) {
			if (y == 115) {
				return "rightup";
			}
			return "right";
		} else if ((y == 195) && (x <= 350) && (x >= 270)) {
			if (x == 350) {
				return "rightup";
			}
			return "up";
		} else if ((x == 350) && (y <= 295) && (y >= 195)) {
			return "right";
		} else if ((y == 305) && (x >= 360) && (x <= 730)) {
			return "up";
		} else if ((x == 740) && (y <= 295) && (y >= 215)) {
			return "left";
		} else if ((y == 205) && (x >= 740) && (x <= 870)) {
			if (x == 740) {
				return "leftup";
			}
			return "up";
		} else if ((x == 880) && (y <= 195) && (y >= 115)) {
			if (y == 115) {
				return "leftup";
			}
			return "left";
		} else {
			return move.frame(x, y);
		}
	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 105) && (x >= 920) && (x <= 980)) {
			getX = x;
			getY = y;
			stair = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 105) && (x >= 100) && (x <= 170)) {
			if (success) {
				getX = x;
				getY = y;
				powderroom = true;
				try {
					Parent root;
					root = FXMLLoader.load(getClass().getResource("/floor2room/powderroom.fxml"));
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
