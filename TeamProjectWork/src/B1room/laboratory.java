package B1room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gameStart.CharacterMove;
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

public class laboratory implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, setStopPoint(), imageView);
				event();
			}
		});
		move.stop(imageView);

	}

		public String setStopPoint() {
			CharacterMove move = new CharacterMove();
			int x = (int) imageView.getX();
			int y = (int) imageView.getY();
			System.out.println(x +" , "+ y);

			if ((y == 210) && (x >= 330) && (x <= 800)) {
				return "down";
			} else if ((x == 810) && (y >= 220) && (y <= 480)) {
				return "left";
			} else if ((x == 310) && (y >= 220) && (y <= 480)) {
				return "right";
			} else if ((y == 490) && (x >= 330) && (x <= 800)) {
				return "up";
			} else {
				return move.frame(x, y);
			}
		}

		public void event() {

			int x = (int) imageView.getX();
			int y = (int) imageView.getY();
			if((y == 110)&&(x >= 910)&&( x <=990)) {
				try {
					Parent root;
					root = FXMLLoader.load(getClass().getResource("/B1room/B1hallway1.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage) imageView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if ((y == 490) && (x >= 330) && (x <= 800)) {
				imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						KeyCode keyCode = event.getCode();
						if (keyCode.equals(KeyCode.SPACE)) {
							try {
								Parent root;
								root = FXMLLoader.load(getClass().getResource("/potgame/layout.fxml"));
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
