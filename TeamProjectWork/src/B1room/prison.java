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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class prison implements Initializable {
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView back;
	@FXML
	private ImageView ironbar;

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
					if ((y == 60) && (x >= 270) && (x <= 290)) {
						getX = x;
						getY = y;
						btngame = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/btngame/MainLayout.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 60) && (x >= 230) && (x <= 260)) {
						getX = x;
						getY = y;
						toilet = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/toilet.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (((x == 290) && (y >= 70) && (y <= 200)) || ((y == 210) && (x >= 300) && (x <= 390))) {
						getX = x;
						getY = y;
						bed = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/bed.fxml"));
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
		if (success) {
			back.setImage(new Image("/B1room_item/prisonopen.png"));
			ironbar.setImage(new Image("/B1room_item/ironbaropen.png"));
		}

		if (btngame) {
			imageView.setX(getX);
			imageView.setY(getY);
			btngame = false;
		}
		if (toilet) {
			imageView.setX(getX);
			imageView.setY(getY);
			toilet = false;
		}
		if (bed) {
			imageView.setX(getX);
			imageView.setY(getY);
			bed = false;
		}
		if (new B1room.B1hallway2().prison) {
			imageView.setX(1060);
			imageView.setY(630);
			new B1room.B1hallway2().prison = false;
		}
	}

	static boolean btngame = false;
	static boolean toilet = false;
	static boolean bed = false;
	public static boolean B1hallway2 = false;
	
	public static boolean success = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		// 퍼즐 성공시
		if (success) {
			if ((x == 360) && (y >= 380) && (y <= 410)) {
				return "left";
			} else if ((x == 390) && (y >= 380) && (y <= 410)) {
				return "right";
			}

			if ((x == 520) && (y >= 420) && (y <= 450)) {
				if (y == 420) {
					return "leftup";
				}
				return "left";
			} else if ((x == 390) && (y >= 420) && (y <= 450)) {
				return "right";
			} else if ((y == 460) && (x >= 400) && (x <= 510)) {
				return "up";
			}
		}
//		침대
		if ((x == 290) && (y >= 60) && (y <= 200)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 210) && (x >= 300) && (x <= 390)) {
			if (x == 390) {
				return "rightup";
			}
			return "up";
		}

		if ((y == 420) && (x >= -10) && (x <= 1110)) {
			if (success) {
				if (x == -10) {
					return "leftup";
				} else if (x == 1110) {
					return "rightup";
				}
				if (x <= 350) {
					return "up";
				} else if (x >= 400) {
					return "up";
				}
			} else {
				if (x == -10) {
					return "leftup";
				} else if (x == 1110) {
					return "rightup";
				}
				return "up";
			}

		}
		if ((y == 380) && (x >= 230) && (x <= 390)) {
			if (success) {
				if ((x >= 230) && (x <= 350)) {
					if (x == 230) {
						return "leftdown";
					}
					return "down";
				}
			} else {
				if (x == 230) {
					return "leftdown";
				} else if (x == 390) {
					return "rightdown";
				}
				return "down";
			}
		}
		if ((x == 230) && (y >= 60) && (y <= 410)) {
			if ((y == 60)) {
				return "leftup";
			}
			return "left";
		} else if ((x == 390) && (y >= 60) && (y <= 410)) {
			if ((y == 60)) {
				return "rightup";
			}
			return "right";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 640) && (x >= 990) && (x <= 1110)) {
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

	}
}
