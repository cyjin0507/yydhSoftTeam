package floor3room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import floor2room.stair;
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

public class guestroom implements Initializable {
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
					if ((x == 800) && (y >= 200) && (y <= 310)) {
						getX = x;
						getY = y;
						bed = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/bedbottom.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (((x == 270) && (y >= 60) && (y <= 100)) || ((y == 110) && (x >= 280) && (x <= 320))) {
						getX = x;
						getY = y;
						lighting = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/lighting.fxml"));
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
			imageView.setY(getY + 10);
			stair = false;
		}
		if (powderroom) {
			imageView.setX(getX);
			imageView.setY(getY + 10);
			powderroom = false;
		}
		if (bed) {
			imageView.setX(getX);
			imageView.setY(getY + 10);
			bed = false;
		}
		if (lighting) {
			imageView.setX(getX - 10);
			imageView.setY(getY);
			lighting = false;
		}
	}

	static boolean stair = false;
	static boolean powderroom = false;
	static boolean lighting = false;
	static boolean bed = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((x == 270) && (y >= 60) && (y <= 100)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 110) && (x >= 280) && (x <= 320)) {
			if (x == 320) {
				return "rightup";
			}
			return "up";
		} else if ((x == 320) && (y >= 120) && (y <= 310)) {
			return "right";
		} else if ((x == 800) && (y >= 60) && (y <= 310)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((y == 320) && (x >= 340) && (x <= 790)) {
			return "up";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 1040) && (x <= 1080)) {
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
		if ((y == 60) && (x >= 20) && (x <= 60)) {
			new floor3room.passward().ans = 6573;

			getX = x;
			getY = y;
			powderroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/passward.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
