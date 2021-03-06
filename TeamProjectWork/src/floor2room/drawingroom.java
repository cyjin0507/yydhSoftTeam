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

public class drawingroom implements Initializable {
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
					if ((y == 390) && (x >= 700) && (x <= 750)) {
						getX = x;
						getY = y;
						table = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/table.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y == 60) && (x >= 180) && (x <= 330)) {
						getX = x;
						getY = y;
						picture = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/picture.fxml"));
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
		if (table) {
			imageView.setX(getX);
			imageView.setY(getY);
			table = false;
		}
		if (picture) {
			imageView.setX(getX);
			imageView.setY(getY);
			picture = false;
		}
	}

	static boolean table = false;
	static boolean picture = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
//?????????
		if ((y == 120) && (x >= 310) && (x <= 790)) {
			return "down";
		} else if ((x == 800) && (y >= 130) && (y <= 200)) {
			return "left";
		} else if ((y == 210) && (x >= 310) && (x <= 790)) {
			return "up";
		} else if ((x == 300) && (y >= 130) && (y <= 200)) {
			return "right";
		}
		// ?????????
		if ((y == 440) && (x >= 310) && (x <= 790)) {
			return "down";
		} else if ((x == 800) && (y >= 450) && (y <= 560)) {
			return "left";
		} else if ((y == 570) && (x >= 310) && (x <= 790)) {
			return "up";
		} else if ((x == 300) && (y >= 450) && (y <= 560)) {
			return "right";
		}
		// ?????????
		if ((y == 390) && (x >= 280) && (x <= 820)) {
			return "up";
		} else if ((y == 260) && (x >= 280) && (x <= 820)) {
			return "down";
		} else if ((x == 270) && (y >= 270) && (y <= 380)) {
			return "right";
		} else if ((x == 830) && (y >= 270) && (y <= 380)) {
			return "left";
		}
		if ((y == 260) && (x >= 840) && (x <= 980)) {
			return "down";
		} else if ((y == 380) && (x >= 840) && (x <= 980)) {
			return "up";
		} else if ((x == 830) && (y >= 270) && (y <= 370)) {
			return "right";
		} else if ((x == 990) && (y >= 270) && (y <= 370)) {
			return "left";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 60) && (x >= 530) && (x <= 570)) {
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

	}
}
