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

public class floor2Move implements Initializable {
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

//이벤트 발생/ 나중에 액자 그림 추가시 재 설정

		

	}

	public String setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();


	}
}
