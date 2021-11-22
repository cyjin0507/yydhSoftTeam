package gameStart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CharacterMove implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

// 모션 스땁
	public void stop(ImageView imageView) {
		imageView.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				animation.stop();
			}
		});
	}

//눌렀을때 움직이는거
	public void pressed(KeyEvent event, String moveStop , ImageView imageView) {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		KeyCode keyCode = event.getCode();
		if (moveStop.equals("up")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x ,imageView);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("down")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x,imageView);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("left")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("right")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("leftup")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("rightup")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("leftdown")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("rightdown")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else {
				animation.stop();
			}
		} else {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x,imageView);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x,imageView);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y,imageView);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y,imageView);
			}
		}
	}

	public SpriteAnimation animation;

//위 아래 왼쪽 오른쪽
	public void up(int y ,ImageView imageView) {

		animation.play();
		animation.setOffsetY(450);
		imageView.setY(y - 10);
	}

	public void down(int y ,ImageView imageView) {
		animation.play();
		animation.setOffsetY(0);
		imageView.setY(y + 10);
	}

	public void left(int x ,ImageView imageView) {
		animation.play();
		animation.setOffsetY(150);
		imageView.setX(x - 10);
	}

	public void right(int x ,ImageView imageView) {
		animation.play();
		animation.setOffsetY(300);
		imageView.setX(x + 10);
	}

	// 키보드 땠을때
	public void Released(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.LEFT)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.UP)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.DOWN)) {
			animation.stop();
			animation.setOffsetX(100);
		}
	}

//캐릭터 모션
	public void sprite(ImageView imageView) {
		imageView.setImage(new Image("/roomImage/all.png"));
		animation = new SpriteAnimation(imageView, Duration.millis(250), 3, 4, 0, 0, 100, 150);
	}

//기본 틀
	public String frame(int x, int y) {
		if (y <= 110) {
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

	// 쪽방 틀
	public String smallframe(int x, int y) {
//		전체 배경 안빠져나가게
		if (y <= 120) {
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