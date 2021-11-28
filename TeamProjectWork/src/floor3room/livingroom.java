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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class livingroom implements Initializable {
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

				// 스페이스바 이벤트
				KeyCode keyCode = event.getCode();
				int x = (int) imageView.getX();
				int y = (int) imageView.getY();

				if (keyCode.equals(KeyCode.SPACE)) {
					if ((y == 100)&&(x >= 70)&&( x<= 160)) {
						getX = x;
						getY = y;
						stove = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/stove.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if ((y ==90) && (x >= 910) && (x <= 1050)) {
						getX = x;
						getY = y;
						drawer = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor3room_item/drawer.fxml"));
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

		if (stove) {
			imageView.setX(getX);
			imageView.setY(getY);
			stove = false;
		}
		if (table) {
			imageView.setX(getX);
			imageView.setY(getY);
			table = false;
		}
		if (drawer) {
			imageView.setX(getX);
			imageView.setY(getY);
			drawer = false;
		}
	}

	static boolean stove = false;
	static boolean table = false;
	static boolean drawer = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);
//		난로

		if((x ==-10)&&(y >= 60)&&(y <= 90)) {
			if(y ==60) {
				return "rightup";
			}else if(x == -10) {
				return "leftup";
			}
			return "right";
		}else if((y == 100)&&(x >= -10)&&( x<= 240)) {
			if(x == -10) {
				return "leftup";
			}
			return "up";
		}
		if((x ==250)&&(y >= 60)&&(y <= 90)) {
			if(y ==60) {
				return "leftup";
			}
			return "left";
		}
		//서랍
		if((x == 850)&&(y >= 60)&&( y <=80)) {
			if(y == 60) {
				return "rightup";
			}
			return "right";
		}else if((y == 90)&&(x >= 860)&&(x <= 1110)) {
			if(x== 1110) {
				return "rightup";
			}
			return "up";
		}
		//밑 소파
		if((y ==630)&&(x >= 280)&&( x<= 760)) {
			return "up";
		}else if((x == 270)&&( y <= 620)&&( y >= 530)) {
			return "right";
		}else if((x == 770)&&( y <= 620)&&( y >= 530)) {
			return "left";
		}else if((y ==520)&&(x >= 280)&&( x<= 760)) {
			return "down";
		}
		//테이블 
		if((y == 490)&&(x >= 250)&&( x<= 790)) {
			return "up";
		}else if((x == 800)&&(y <=490)&&(y >= 360)) {
			return "left";
		}else if((x == 240)&&(y <=490)&&(y >= 360)) {
			return "right";
		}else if((y == 350)&&(x >= 250)&&( x<= 790)) {
			return "down";
		}
		//위 소파
		if((y == 310)&&(x <= 770)&&(x >= 280)) {
			return "up";
		}else if((y == 210)&&(x <= 770)&&(x >= 280)) {
			return "down";
		} else if((x == 270)&&(y >= 220)&&(y <= 300)) {
			return "right";
		}else if((x == 780)&&(y >= 220)&&(y <= 300)) {
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
				root = FXMLLoader.load(getClass().getResource("/floor3room/floor3hallway.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
