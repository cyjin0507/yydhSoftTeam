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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class study implements Initializable {
	MediaPlayer mp;
	Media m = null;
	public ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, setStopPoint(), imageView);

				// 스페이스바 이벤트
				KeyCode keyCode = event.getCode();
				int x = (int) imageView.getX();
				int y = (int) imageView.getY();
				
				if ((y == 110) && (x >= 920) && (x <= 980)) {
					if (success) {
						getX = x;
						getY = y;
						stair = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room/stair.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("잠김");
						alert.setHeaderText("");
						alert.setContentText("문이 잠겨있다");
						alert.showAndWait();
					}

				}

				if (keyCode.equals(KeyCode.SPACE)) {
					if ((y == 110) && (x >= 270) && (x <= 320)) {
						getX = x;
						getY = y;
						puzzle = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/puzzle/puzzleLayout.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y == 140) && (x >= 430) && (x <= 680)) {
						getX = x;
						getY = y;
						bookcase = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/bookcase.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y == 520) && (x >= 530) && (x <= 600)) {
						getX = x;
						getY = y;
						desk = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/studymail.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (((x == 110) && (y >= 590) && (y <= 620)) || ((x == 10) && (y >= 590) && (y <= 620))
							|| ((y == 580) && (x >= 40) && (x <= 100))) {
						getX = x;
						getY = y;
						grass = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor2room_item/grass.fxml"));
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
			stair = false;
		}
		if (desk ) {
			imageView.setX(getX);
			imageView.setY(getY);
			desk  = false;
		}
		if (grass) {
			imageView.setX(getX);
			imageView.setY(getY);
			grass = false;
		}
		if (puzzle) {
			imageView.setX(getX);
			imageView.setY(getY);
			puzzle = false;
		}
		if (stair) {
			imageView.setX(getX);
			imageView.setY(getY);
			stair = false;
		}
	}
	
	static boolean bookcase = false;
	static boolean desk = false;
	static boolean grass = false;
	static boolean puzzle = false;
	static boolean stair = false;

	public static int getX;
	public static int getY;


	public static boolean success = false;

	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		CharacterMove move = new CharacterMove();

//			책상 충돌 방지
		if ((y == 270) && (x >= 360) && (x <= 750)) {
			return "down";
		} else if ((y >= 270) && (y <= 520) && (x == 370)) {
			return "right";
		} else if ((y == 520) && (x >= 360) && (x <= 750)) {
			return "up";
		} else if ((y >= 270) && (y <= 520) && (x == 760)) {
			return "left";
		}
		// 화분
		if ((x == 110) && (y >= 590) && (y <= 620)) {
			if (y == 620) {
				return "leftdown";
			}
			return "left";
		} else if ((x == 10) && (y >= 590) && (y <= 620)) {
			if (y == 620) {
				return "rightdown";
			}
			return "right";
		} else if ((y == 580) && (x >= 40) && (x <= 100)) {
			return "down";
		}

		// 책꽂이
		if ((x == 370) && (y <= 130) && (y >= 100)) {
			if (y == 100) {
				return "rightup";
			}
			return "right";
		} else if ((x == 740) && (y <= 130) && (y >= 100)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		} else if ((x >= 380) && (x <= 720) && (y == 140)) {
			return "up";
		} else {
			return move.frame(x, y);
		}
	}

}
