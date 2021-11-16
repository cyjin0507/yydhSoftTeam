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

public class floor3small2 implements Initializable {
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
		if ((y == 130) && (x >= 260) && (x <= 370)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/btngame/MainLayout.fxml"));
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
//책장
		if ((y == 180) && (x >= 10) && (x <= 130)) {
			if (x == 10) {
				return "leftup";
			}
			return "up";
		} else if ((x == 140) && (y <= 170) && (y >= 130)) {
			if (y == 130) {
				return "leftup";
			}
			return "left";
		}
//빗자루
		if ((x == 530) && (y >= 130) && (y <= 150)) {
			if (y == 130) {
				return "rightup";
			}
			return "right";
		} else if ((y == 160) && (x >= 540) && (x <= 600)) {
			if (x == 600) {
				return "rightup";
			}
			return "up";
		}

//전체 배경 안빠져나가게
		if (y <= 130) {
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
