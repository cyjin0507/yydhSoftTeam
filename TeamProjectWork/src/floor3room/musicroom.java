package floor3room;

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

public class musicroom implements Initializable {
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

		System.out.println(x + "," + y);
		if ((y == 320) && (x >= 460) && (x <= 1000)) {
			return "down";
		} else if ((x == 1010) && (y >= 330) && (y <= 570)) {
			return "left";
		} else if ((x == 450) && (y >= 330) && (y <= 570)) {
			return "right";
		} else if ((y == 580) && (x >= 460) && (x <= 1000)) {
			return "up";
		}

		if ((y == 460) && (x >= -10) && (x <= 140)) {
			if (x == -10) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 150) && (y >= 470) && (y <= 590)) {
			return "left";
		} else if ((y == 600) && (x >= -10) && (x <= 140)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		}
		if ((x == 120) && (y >= 90) && (y <= 130)) {
			return "left";
		}else if ((y == 140) && (x >= -10) && (x <= 110)) {
			if(x == -10) {
				return "leftup";
			}
			return "up";
		}

		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 530) && (x <= 570)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
