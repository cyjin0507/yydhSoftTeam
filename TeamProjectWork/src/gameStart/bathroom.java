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

public class bathroom implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, floor3_small1setStopPoint(), imageView);
				floor3_small1event();
			}
		});
		move.stop(imageView);

	}
	// 3층 쪽방 1 멈추는거
		public String floor3_small1setStopPoint() {
			CharacterMove move = new CharacterMove();
			int x = (int) imageView.getX();
			int y = (int) imageView.getY();
			System.out.println(x + "," + y);

			// 세면대
			if ((x == 220) && (y >= 100) && (y <= 120)) {
				if (y >= 100) {
					return "rightup";
				}
				return "right";
			} else if ((y == 130) && (x >= 230) && (x <= 330)) {
				return "up";
			} else if ((x == 340) && (y >= 100) && (y <= 120)) {
				if (y == 100) {
					return "leftup";
				}
				return "left";
			}
			// 변기
			if ((x == 600) && (y >= 100) && (y <= 160)) {
				if (y == 100) {
					return "leftup";
				}
				return "left";
			} else if ((x <= 590) && (y == 170) && (x >= 440)) {
				return "up";
			} else if ((x == 430) && (y >= 100) && (y <= 160)) {
				if (y == 100) {
					return "rightup";
				}
				return "right";
			} else {
				return move.smallframe(x, y);
			}
		}

		// 3층 쪽방 1이벤트
		public void floor3_small1event() {

			int x = (int) imageView.getX();
			int y = (int) imageView.getY();

			if ((y == 120) && (x <= 100) && (x >= 40)) {
				imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						KeyCode keyCode = event.getCode();
						if (keyCode.equals(KeyCode.SPACE)) {
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
				});
			}

		}

}
