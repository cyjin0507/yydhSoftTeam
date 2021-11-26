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

public class dressroom implements Initializable {
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
					if ((y == 110) && (x <= 250) && (x >= 50)) {
						getX = x;
						getY = y;
						closet1 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/test.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 110) && (x <= 510) && (x >= 350)) {
						getX = x;
						getY = y;
						closet2 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/test.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 110) && (x <= 810) && (x >= 600)) {
						getX = x;
						getY = y;
						closet3 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/test.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((y == 110) && (x <= 940) && (x >= 880)) {
						getX = x;
						getY = y;
						closet4 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/test.fxml"));
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
		if (closet1) {
			imageView.setX(getX);
			imageView.setY(getY);
			closet1 = false;
		}
		if (closet2) {
			imageView.setX(getX);
			imageView.setY(getY);
			closet2 = false;
		}
		if (closet3) {
			imageView.setX(getX);
			imageView.setY(getY);
			closet3 = false;
		}
		if (closet4) {
			imageView.setX(getX);
			imageView.setY(getY);
			closet4 = false;
		}

	}

	static boolean closet1 = false;
	static boolean closet2 = false;
	static boolean closet3 = false;
	static boolean closet4 = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);

//		위랑 아래 막기
		if ((y == 110) && (x >= -10) && (x <= 1110)) {
			if (x == -10) {
				return "leftup";
			} else if (x == 1110) {
				return "rightup";
			}
			return "up";
		} else if ((y == 450) && (x >= -10) && (x <= 1110)) {
			if (x == -10) {
				return "leftdown";
			} else if (x == 1110) {
				return "rightdown";
			}
			return "down";
		}
		// 거울
		if ((x == 30) && (y >= 280) && (y <= 330)) {
			return "left";
		} else if ((y == 340) && (x >= -10) && (x <= 20)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		} else if ((y == 270) && (x >= -10) && (x <= 20)) {
			if (x == -10) {
				return "leftdown";
			}
			return "down";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 460) && (x >= 930) && (x <= 1060)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/powderroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
