package game_screen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cont implements Initializable {
	@FXML
	private ImageView imageView;
	@FXML
	private Rectangle rectangle;

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

		// 해당 좌표 갔을때 이벤트
		if (((x <= (int) rectangle.getX() + 10) && (x >= (int) rectangle.getX() - 10))
				&& ((y <= (int) rectangle.getY() + 10) && (y >= (int) rectangle.getY() - 10))) {
			System.out.println("이벤트 발생!");
		}
	}

	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if (y <= 15) {
			if (x <= 0) {
				return "leftup";
			}
			if (x >= 1100) {
				return "rightup";
			}
			return "up";
		} else if (y >= 635) {
			if (x <= 0) {
				return "leftdown";
			}
			if (x >= 1100) {
				return "rightdown";
			}
			return "down";
		} else if (x <= 0) {
			return "left";
		} else if (x >= 1100) {
			return "right";
		}
		return "";

	}
//혹시몰라서 남겨둔 키 땠을때 이벤트
//	public void Released(KeyEvent event) {
//		KeyCode keyCode = event.getCode();
//		if (keyCode.equals(KeyCode.RIGHT)) {
//		} else if (keyCode.equals(KeyCode.LEFT)) {
//		} else if (keyCode.equals(KeyCode.UP)) {
//		} else if (keyCode.equals(KeyCode.DOWN)) {
//		}
//	}
}
