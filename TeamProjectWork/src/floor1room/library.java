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

public class library implements Initializable {
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
			}
		});
		move.stop(imageView);
		if (mainhall) {
			imageView.setX(getX);
			imageView.setY(getY +10);
			mainhall = false;
		}
		if (B1hallway1) {
			imageView.setX(getX);
			imageView.setY(getY -10);
			B1hallway1 = false;
		}
		if (new B1room.B1hallway1().library) {
			imageView.setX(1090);
			imageView.setY(420);
			new B1room.B1hallway1().library = false;
		}
	}

	public static boolean mainhall = false;
	static boolean B1hallway1 = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();


		// 위 의자와 책장
		if ((y == 110) && (x >= -10) && (x <= 450)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		} else if ((x == 460) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		}
//		위 오른쪽 책장
		if ((x == 1030) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((x == 620) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 110) && (x >= 630) && (x <= 1020)) {
			return "up";
		}
//아래 왼쪽 책장
		if ((y == 470) && (x >= -10) && (x <= 330)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		} else if ((y == 360) && (x >= -10) && (x <= 330)) {
			if (x == -10) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 340) && (y >= 370) && (y <= 460)) {
			return "left";
		}
		// 아래 가운데 책장
		if ((x == 470) && (y >= 370) && (y <= 460)) {
			return "right";
		} else if ((x == 770) && (y >= 370) && (y <= 460)) {
			return "left";
		} else if ((y == 360) && (x >= 480) && (x <= 760)) {
			return "down";
		} else if ((y == 470) && (x >= 480) && (x <= 760)) {
			return "up";
		}
		// 아래 맨 끝쪽 바로 옆 책장
		if ((x == 870) && (y >= 370) && (y <= 460)) {
			return "right";
		} else if ((x == 1050) && (y >= 370) && (y <= 460)) {
			return "left";
		} else if((y == 360)&&(x>= 880)&&(x<= 1040)) {
			return "down";
		} else if((y == 470)&&(x >= 880)&&( x<= 1040)) {
			return "up";
		}
		//아래 맨 끝쪽 책장
		if((y ==540)&&(x>=1010)&&(x <= 1110)) {
			if(x == 1110) {
				return "rightup";
			}
			return "up";
		}else if((y ==420)&&(x>=1010)&&(x <= 1110)) {
			if(x == 1110) {
				return "rightdown";
			}
			return "down";
		}else if((x== 1000)&&(y >= 470)&&(y <= 530)) {
			return "right";
		}
		//책상과 의자
		if((y == 480)&&(x >=40)&&(x <=440)) {
			return "down";
		}else if((y == 620)&&(x >=40)&&(x <=440)) {
			return "up";
		}else if((x == 30)&&(y >= 490)&&(y <= 610)) {
			return "right";
		}else if((x == 450)&&(y >= 490)&&(y <= 610)) {
			return "left";
		}

		return move.nframe(x, y);

	}

	public void event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);

		if ((y == 60) && (x >= 530) && (x <= 570)) {
			getX = x;
			getY = y;
			mainhall = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 420) && (x >= 1050) && (x <= 1110)) {
			getX = x;
			getY = y;
			B1hallway1 = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/B1hallway1.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
