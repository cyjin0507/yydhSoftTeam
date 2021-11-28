package floor3room;

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

public class musicroom implements Initializable {
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
					if ((y == 580) && (x >= 460) && (x <= 1000)) {
						getX = x;
						getY = y;
						piano = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/piano.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (((y == 460) && (x >= -10) && (x <= 140)) || ((x == 150) && (y >= 470) && (y <= 590))
							|| ((y == 600) && (x >= -10) && (x <= 140))) {
						getX = x;
						getY = y;
						cello = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/cello.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (((x == 120) && (y >= 80) && (y <= 130)) || ((y == 140) && (x >= -10) && (x <= 110))) {
						getX = x;
						getY = y;
						musicbox = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/musicbox.fxml"));
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
		if (piano) {
			imageView.setX(getX);
			imageView.setY(getY);
			piano = false;
		}
		if (cello) {
			imageView.setX(getX);
			imageView.setY(getY);
			cello = false;
		}
		if (musicbox) {
			imageView.setX(getX);
			imageView.setY(getY);
			musicbox = false;
		}
	}

	static boolean piano = false;
	static boolean cello = false;
	static boolean musicbox = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 320) && (x >= 460) && (x <= 1000)) {
			return "down";
		} else if ((x == 1010) && (y >= 330) && (y <= 570)) {
			return "left";
		} else if ((x == 450) && (y >= 330) && (y <= 570)) {
			return "right";
		} else if ((y == 580) && (x >= 460) && (x <= 1000)) {
			return "up";
		}

		if ((y == 460) && (x >= -10) && (x <= 140)) {
			if (x == -10) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 150) && (y >= 470) && (y <= 590)) {
			return "left";
		} else if ((y == 600) && (x >= -10) && (x <= 140)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		}
		if ((x == 120) && (y >= 80) && (y <= 130)) {
			if (y == 80) {
				return "leftup";
			}
			return "left";
		} else if ((y == 140) && (x >= -10) && (x <= 110)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		}

		if ((x == 420) && (y >= 60) && (y <= 70)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((x == 40) && (y >= 60) && (y <= 70)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 80) && (x >= 50) && (x <= 410)) {
			return "up";
		}

		if ((x == 660) && (y >= 60) && (y <= 70)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((x == 1060) && (y >= 60) && (y <= 70)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((y == 80) && (x >= 670) && (x <= 1050)) {
			return "up";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 530) && (x <= 570)) {
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
	}
}
