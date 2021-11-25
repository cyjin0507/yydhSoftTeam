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

public class storage implements Initializable {
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
					if ((y == 170) && (x >= 0) && (x <= 120)) {
						getX = x;
						getY = y;
						bookcase = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/test.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if (((x == 530) && (y >= 130) && (y <= 150))||((y == 160) && (x >= 540) && (x <= 600))) {
						getX = x;
						getY = y;
						broom = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/test.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 120) && (x >= 250) && (x <= 370)) {
						getX = x;
						getY = y;
						frame = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/B1room_item/test.fxml"));
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
		if (bookcase) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase = false;
		}
		if (broom) {
			imageView.setX(getX);
			imageView.setY(getY);
			broom = false;
		}
		if (frame) {
			imageView.setX(getX);
			imageView.setY(getY);
			frame = false;
		}
	}
	
	static boolean bookcase = false;
	static boolean broom = false;
	static boolean frame = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		// 책장
		if ((y == 170) && (x >= 0) && (x <= 120)) {
			if (x == 0) {
				return "leftup";
			}
			return "up";
		} else if ((x == 140) && (y <= 170) && (y >= 120)) {
			if (y == 120) {
				return "leftup";
			}
			return "left";
		}
		// 빗자루
		if ((x == 530) && (y >= 120) && (y <= 150)) {
			if (y == 120) {
				return "rightup";
			}
			return "right";
		} else if ((y == 160) && (x >= 540) && (x <= 600)) {
			if (x == 600) {
				return "rightup";
			}
			return "up";
		} else {
			return move.smallframe(x, y);
		}

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 620) && (x >= 270) && (x <= 360)) {
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
