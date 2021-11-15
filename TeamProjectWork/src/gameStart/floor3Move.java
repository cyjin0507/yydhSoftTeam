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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import puzzle.puzzleController;

public class floor3Move implements Initializable {

	@FXML
	private ImageView imageView;
	@FXML
	private Rectangle rectangle;
	@FXML
	private Rectangle obstacle;

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

//이벤트 발생
		if ((y == 100) && (x >= 270) && (x <= 320)) {
			
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/puzzle/puzzleLayout.fxml"));
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
		System.out.println("x는" + x);
		System.out.println("y는" + y);
//		책상 충돌 방지
		if ((y == 270) && (x >= 360) && (x <= 750)) {
			if ((x == 660) && (y <= 270) && (y >= 170)) {
				return "leftdown";
			}
			if ((x == 470) && (y <= 270) && (y >= 170)) {
				return "rightdown";
			}
			return "down";
		} else if ((y >= 270) && (y <= 520) && (x == 370)) {
			return "right";
		} else if ((y == 520) && (x >= 360) && (x <= 750)) {
			return "up";
		} else if ((y >= 270) && (y <= 520) && (x == 760)) {
			return "left";
		}
//		의자 충돌
		if ((x == 660) && (y <= 270) && (y >= 170)) {
			return "leftdown";
		} else if ((x == 470) && (y <= 270) && (y >= 170)) {
			return "rightdown";
		} else if ((y == 160) && (x <= 650) && (x >= 470)) {
			return "down";
		}
//식물
		if ((x == 120) && (y >= 460)) {
			if (y == 620) {
				return "leftdown";
			}
			return "left";
		} else if ((y == 460) && (x <= 120)) {
			if (x == 10) {
				return "leftdown";
			}
			return "down";
		}
//옷걸이
		if ((x == 970) && (y >= 440)) {
			if (y == 620) {
				return "rightdown";
			}
			return "right";
		} else if ((y == 440) && (x >= 970)) {
			if (x == 1090) {
				return "rightdown";
			}
			return "down";
		}
//책꽂이
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
		}

//		전체 배경 안빠져나가게
		if (y <= 100) {
			if (x <= 10) {
				return "leftup";
			}
			if (x >= 1090) {
				return "rightup";
			}
			return "up";
		} else if (y >= 620) {
			if (x <= 10) {
				return "leftdown";
			}
			if (x >= 1090) {
				return "rightdown";
			}
			return "down";
		} else if (x <= 10) {
			return "left";
		} else if (x >= 1090) {
			return "right";
		}
		return "";

	}
}
