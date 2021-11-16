package gameStart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class floor3small1 implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				pressed(event, setStopPoint());
			}
		});
		imageView.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
//				Released(event);
			}
		});

	}

	public void pressed(KeyEvent event, String moveStop) {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		KeyCode keyCode = event.getCode();
		if (moveStop.equals("up")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		} else if (moveStop.equals("down")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			}
		} else if (moveStop.equals("left")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		} else if (moveStop.equals("right")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		} else if (moveStop.equals("leftup")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		} else if (moveStop.equals("rightup")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		} else if (moveStop.equals("leftdown")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			}
		} else if (moveStop.equals("rightdown")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			}
		} else {
			if (keyCode.equals(KeyCode.RIGHT)) {
				imageView.setX(x + 10);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				imageView.setX(x - 10);
			} else if (keyCode.equals(KeyCode.UP)) {
				imageView.setY(y - 10);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				imageView.setY(y + 10);
			}
		}

//이벤트 발생/ 나중에 그림에 퍼즐 추가시 재 설정
		if ((y == 100) && (x <= 100) && (x >= 40)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/pipegame/layout.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

//세면대
		if ((x == 220) && (y >= 100) && (y <= 120)) {
			if (y >= 100) {
				return "rightup";
			}
			return "right";
		} else if ((y == 130) && (x >= 230) && (x <= 330)) {
			return "up";
		} else if((x == 340) && (y >= 100) && (y <= 120)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		}
//
		if((x ==600) &&(y >= 100)&&(y <= 160)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		} else if ((x <= 590)&&(y ==170)&&( x >= 440)) {
			return "up";
		} else if ((x ==430)&&(y >= 100)&&(y <= 160)) {
			if (y == 100) {
				return "rightup";
			}
			return "right";
		}
//		전체 배경 안빠져나가게
		if (y <= 100) {
			if (x <= 10) {
				return "leftup";
			}
			if (x >= 600) {
				return "rightup";
			}
			return "up";
		} else if (y >= 620) {
			if (x <= 10) {
				return "leftdown";
			}
			if (x >= 600) {
				return "rightdown";
			}
			return "down";
		} else if (x <= 10) {
			return "left";
		} else if (x >= 600) {
			return "right";
		}
		return "";

	}
}
