package gameStart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import mainGame.chat;

public class MainHoll extends chat implements Initializable {
	@FXML
	private ImageView user1; 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sprite();
		user1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				pressed(event);
				System.out.println("testdfg");
			}
		});
		user1.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				animation.stop();
			}
		});
	}
	SpriteAnimation animation;
	
	public void pressed(KeyEvent event) {
		System.out.println("ters");
		int x = (int) user1.getX();
		int y = (int) user1.getY();
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			animation.play();
			animation.setOffsetY(300);
			user1.setX(x + 10);
		} else if (keyCode.equals(KeyCode.LEFT)) {
			animation.play();
			animation.setOffsetY(150);
			user1.setX(x - 10);
		} else if (keyCode.equals(KeyCode.UP)) {
			animation.play();
			animation.setOffsetY(450);
			user1.setY(y - 10);
		} else if (keyCode.equals(KeyCode.DOWN)) {
			animation.play();
			animation.setOffsetY(0);
			user1.setY(y + 10);
		}
	}
	
	public void sprite() {
		user1.setImage(new Image("/roomImage/all.png"));
		animation = new SpriteAnimation(user1, Duration.millis(500), 3, 4, 0, 0, 100, 150);
	}
}
