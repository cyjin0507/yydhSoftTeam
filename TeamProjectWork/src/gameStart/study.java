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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class study implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, floor3setStopPoint() ,imageView);
				floor3event();
			}
		});
		move.stop(imageView);
	}


	// 3층 멈추는거
	public String floor3setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		CharacterMove move = new CharacterMove();

//			책상 충돌 방지
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
//			의자 충돌
		if ((x == 660) && (y <= 270) && (y >= 170)) {
			return "leftdown";
		} else if ((x == 470) && (y <= 270) && (y >= 170)) {
			return "rightdown";
		} else if ((y == 160) && (x <= 650) && (x >= 470)) {
			return "down";
		}
		// 식물
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
		// 옷걸이
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
		// 책꽂이
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
		} else {
			return move.frame(x, y);
		}
	}

	// 3층 이벤트
	public void floor3event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 110) && (x >= 270) && (x <= 320)) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					KeyCode keyCode = event.getCode();
					if (keyCode.equals(KeyCode.SPACE)) {
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
			});

		}
	}

}
