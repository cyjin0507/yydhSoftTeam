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

public class bathroom implements Initializable {
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
					if((y == 160) && (x >= 480) && (x <= 580)) {
						getX = x;
						getY = y;
						mirror = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/mirrorbeforebath.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((x <= 830) && (y == 210) && (x >= 690)) {
						getX = x;
						getY = y;
						toilet = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/toilet.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if  ((x <= 340) && (y == 120) && (x >= 300)) {
						getX = x;
						getY = y;
						shower = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/shower.fxml"));
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
		if (mirror) {
			imageView.setX(getX);
			imageView.setY(getY);
			mirror = false;
		}
		if (toilet) {
			imageView.setX(getX);
			imageView.setY(getY);
			toilet = false;
		}
		if (shower) {
			imageView.setX(getX);
			imageView.setY(getY);
			shower = false;
		}
	}
	static boolean mirror = false;
	static boolean toilet = false;
	static boolean shower = false;

	public static int getX;
	public static int getY;
	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();


//		 세면대
		if ((x == 470) && (y >= 100) && (y <= 150)) {
			if (y >= 100) {
				return "rightup";
			}
			return "right";
		} else if ((y == 160) && (x >= 480) && (x <= 580)) {
			return "up";
		} else if ((x == 590) && (y >= 100) && (y <= 120)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		}
		// 변기
		if ((x == 840) && (y >= 120) && (y <= 200)) {
			if (y == 120) {
				return "leftup";
			}
			return "left";
		} else if ((x <= 830) && (y == 210) && (x >= 690)) {
			return "up";
		} else if ((x == 680) && (y >= 100) && (y <= 200)) {
			if (y == 120) {
				return "rightup";
			}
			return "right";
		}
			return move.smallframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 620) && (x >= 470) && (x <= 620)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/powderroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
