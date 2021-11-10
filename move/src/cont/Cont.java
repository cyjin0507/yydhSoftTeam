package cont;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Cont implements Initializable {
	@FXML
	private ImageView mario;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* 키보드 입력에 따라 이미지 위치 변경 */
		mario.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				handleImage(event);
			}
		});

	}

	/* 이미지 위치변경 메소드 */
	public void handleImage(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			mario.setX(mario.getX() + 10);
		} else if (keyCode.equals(KeyCode.LEFT)) {
			mario.setX(mario.getX() - 10);
		} else if (keyCode.equals(KeyCode.UP)) {
			mario.setY(mario.getY() - 10);
		} else if (keyCode.equals(KeyCode.DOWN)) {
			mario.setY(mario.getY() + 10); 
		}
	}
}



















