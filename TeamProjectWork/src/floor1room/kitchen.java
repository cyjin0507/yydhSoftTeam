package floor1room;

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

public class kitchen implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event,setStopPoint(), imageView);
				event();
				
				KeyCode keyCode = event.getCode();
				if (keyCode.equals(KeyCode.SPACE)) {
					int x = (int) imageView.getX();
					int y = (int) imageView.getY();
					if ((x == 155) && (y >= 440) && (y <= 490)) {
						getX = x;
						getY = y;
						choppingBoard = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/choppingBoard.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((x == 665) && (y >= 430) && (y <= 480)) {
						getX = x;
						getY = y;
						table = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/table.fxml"));
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
		
		if (choppingBoard) {
			imageView.setX(getX);
			imageView.setY(getY);
			choppingBoard = false;
		}
		if (table) {
			imageView.setX(getX);
			imageView.setY(getY);
			table = false;
		}
	}
	
	static boolean choppingBoard = false;
	static boolean table = false;

	public static int getX;
	public static int getY;

	// 1층 멈추는거
	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		CharacterMove move = new CharacterMove();
		// 싱크대
		if ((y == 220) && (x <= 155) && (x >= 5)) {
			if (x == 5) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 155) && (y <= 620) && (y >= 230)) {
			if (y == 620) {
				return "leftdown";
			}
			return "left";
		}
//				테이블
		if ((y == 300) && (x >= 685) && (x <= 735)) {
			if (x == 735) {
				return "rightdown";
			}
			return "down";
		} else if ((x == 735) && (y <= 300) && (y >= 230)) {
			return "right";
		} else if ((y == 230) && (x >= 745) && (x <= 935)) {
			return "down";
		} else if ((x == 945) && (y >= 240) && (y <= 290)) {
			return "left";
		} else if ((y == 300) && (x >= 945) && (x <= 1015)) {
			if (x == 945) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 1025) && (y >= 310) && (y <= 570)) {
			return "left";
		} else if ((y == 580) && (x <= 1015) && (x >= 675)) {
			return "up";
		} else if ((x == 665) && (y >= 310) && (y <= 570)) {
			return "right";
		} else {
			return move.frame(x, y);
		}
	}

	// 1층 이벤트
	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		
		if((y ==110) &&( x >= 685)&& (x <= 765)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor1room/dinnerhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
