package gameStart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mainGame.chat;

public class MainHoll extends chat implements Initializable {
	@FXML
	private ImageView user1; 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		user1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				pressed(event);
				System.out.println("testdfg");
			}
		});
	}
	
	
	public void pressed(KeyEvent event) {
		System.out.println("ters");
		int x = (int) user1.getX();
		int y = (int) user1.getY();
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			user1.setX(x + 10);
		} else if (keyCode.equals(KeyCode.LEFT)) {
			user1.setX(x - 10);
		} else if (keyCode.equals(KeyCode.UP)) {
			user1.setY(y - 10);
		} else if (keyCode.equals(KeyCode.DOWN)) {
			user1.setY(y + 10);
		}
	}
	

}
