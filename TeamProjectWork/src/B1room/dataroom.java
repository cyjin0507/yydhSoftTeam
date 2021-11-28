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

public class dataroom implements Initializable {
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
					if ((y == 290) && (x >= 405) && (x <= 705)) {
						getX = x;
						getY = y;
						bookcase1 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/bookcase1.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 290) && (x >= 35) && (x <= 345)) {
						getX = x;
						getY = y;
						bookcase2 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/bookcase2.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 600) && (x >= 155) && (x <= 465)) {
						getX = x;
						getY = y;
						bookcase3 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/bookcase3.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 600) && (x >= 535) && (x <= 835)) {
						getX = x;
						getY = y;
						bookcase4 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/bookcase4.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y >= 480)&&(y <= 550) && (x >= 845) && (x <= 905)) {
						getX = x;
						getY = y;
						book = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/book.fxml"));
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
		if (bookcase1) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase1 = false;
		}
		if (bookcase2) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase2 = false;
		}
		if (bookcase3) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase3 = false;
		}
		if (bookcase4) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase4 = false;
		}
		if (book) {
			imageView.setX(getX);
			imageView.setY(getY);
			book = false;
		}
	}

	static boolean bookcase1 = false;
	static boolean bookcase2 = false;
	static boolean bookcase3 = false;
	static boolean bookcase4 = false;
	static boolean book = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 470) && (x >= 5) && (x <= 145)) {
			if (x == 5) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 195) && (y >= 480) && (y <= 620)) {
			if (y == 620) {
				return "leftdown";
			} else if (y == 600) {
				return "leftup";
			}
			return "left";
		}
		if ((x == 715) && (y >= 110) && (y <= 280)) {
			if (y == 110) {
				return "leftup";
			}
			return "left";
		} else if ((x == 395) && (y >= 110) && (y <= 280)) {
			if (y == 110) {
				return "rightup";
			}
			return "right";
		} else if ((y == 290) && (x >= 405) && (x <= 705)) {
			return "up";
		}

		if ((x == 335) && (y >= 110) && (y <= 280)) {
			if (y == 110) {
				return "leftup";
			}
			return "left";
		} else if ((x == 25) && (y >= 110) && (y <= 280)) {
			if (y == 110) {
				return "rightup";
			}
			return "right";
		} else if ((y == 290) && (x >= 35) && (x <= 345)) {
			return "up";
		}
		if ((x == 525) && (y >= 480) && (y <= 590)) {
			return "right";
		} else if ((x == 845) && (y >= 480) && (y <= 590)) {
			return "left";
		} else if ((y == 600) && (x >= 535) && (x <= 835)) {
			return "up";
		} else if ((y == 470) && (x >= 535) && (x <= 835)) {
			return "down";
		}

		if ((x == 145) && (y >= 480) && (y <= 590)) {
			return "right";
		} else if ((x == 475) && (y >= 480) && (y <= 590)) {
			return "left";
		} else if ((y == 600) && (x >= 155) && (x <= 465)) {
			return "up";
		} else if ((y == 470) && (x >= 155) && (x <= 465)) {
			return "down";
		}

		return move.frame(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 110) && (x >= 915) && (x <= 1015)) {
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
