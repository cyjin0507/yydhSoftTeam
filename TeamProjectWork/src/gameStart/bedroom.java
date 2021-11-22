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

public class bedroom implements Initializable{
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CharacterMove move = new CharacterMove();
		move.sprite(imageView);
		imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move.pressed(event, floor2setStopPoint(), imageView);
				floor2event();
			}
		});

		move.stop(imageView);
	}
	// 2층 멈추는거
	public String floor2setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		CharacterMove move = new CharacterMove();

//		침대랑 전등이랑 전부다
		if ((x == 270) && (y <= 185) && (y >= 115)) {
			if (y == 115) {
				return "rightup";
			}
			return "right";
		} else if ((y == 195) && (x <= 350) && (x >= 270)) {
			if (x == 350) {
				return "rightup";
			}
			return "up";
		} else if ((x == 350) && (y <= 295) && (y >= 195)) {
			return "right";
		} else if ((y == 305) && (x >= 360) && (x <= 730)) {
			return "up";
		} else if ((x == 740) && (y <= 295) && (y >= 215)) {
			return "left";
		} else if ((y == 205) && (x >= 740) && (x <= 870)) {
			if (x == 740) {
				return "leftup";
			}
			return "up";
		} else if ((x == 880) && (y <= 195) && (y >= 115)) {
			if (y == 115) {
				return "leftup";
			}
			return "left";
		} else {
			return move.frame(x, y);
		}
	}

	// 2층 이벤트
	public void floor2event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 125) && (x <= 270) && (x >= 220)) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					KeyCode keyCode = event.getCode();
					if (keyCode.equals(KeyCode.SPACE)) {
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/findHiddenObject/play.fxml"));
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
