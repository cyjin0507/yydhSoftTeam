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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class powderroom implements Initializable {
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
					if ((y == 580) && (x >= 680) && (x <= 780)) {
						getX = x;
						getY = y;
						mirror = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/powdermirror.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y == 580) && (x >= 470) && (x <= 630)) {
						getX = x;
						getY = y;
						leftcosmetic = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/cosmeticleft.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y == 580) && (x >= 360) && (x <= 440)) {
						getX = x;
						getY = y;
						rightcosmetic = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/cosmeticright.fxml"));
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
		if (bathroom) {
			imageView.setX(getX + 10);
			imageView.setY(getY);
			bathroom = false;
		}
		if (dressroom) {
			imageView.setX(getX);
			imageView.setY(getY + 10);
			dressroom = false;
		}
		if (bedroom) {
			imageView.setX(getX - 10);
			imageView.setY(getY);
			bedroom = false;
		}
		if (mirror) {
			imageView.setX(getX);
			imageView.setY(getY);
			mirror = false;
		}
		if (leftcosmetic) {
			imageView.setX(getX);
			imageView.setY(getY);
			leftcosmetic = false;
		}
		if (rightcosmetic) {
			imageView.setX(getX);
			imageView.setY(getY);
			rightcosmetic = false;
		}
	}

	static boolean dressroom = false;
	static boolean bathroom = false;
	static boolean bedroom = false;
	static boolean mirror = false;
	static boolean leftcosmetic = false;
	static boolean rightcosmetic = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

//		방 전체 틀 잡기
		if ((x == 260) && (y <= 580) && (y >= 60)) {
			if (y == 60) {
				return "leftup";
			} else if (y == 580) {
				return "leftdown";
			}
			return "left";
		} else if ((x == 840) && (y <= 580) && (y >= 60)) {
			if (y == 60) {
				return "rightup";
			} else if (y == 580) {
				return "rightdown";
			}
			return "right";
		} else if ((y == 580) && (x >= 270) && (x <= 830)) {
			return "down";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 520) && (x <= 580)) {
			getX = x;
			getY = y;
			dressroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/dressroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((x == 260) && (y <= 380) && (y >= 210)) {
			getX = x;
			getY = y;
			bathroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/bathroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((x == 840) && (y <= 380) && (y >= 210)) {
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
	}
}
