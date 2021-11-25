package floor3room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import floor2room.floor2hallway;
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

public class stair implements Initializable{
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
		if (stair1) {
			imageView.setX(getX -10);
			imageView.setY(getY);
			stair1 = false;
		}
		if (stair2) {
			imageView.setX(getX +10);
			imageView.setY(getY);
			stair2 = false;
		}
		if (floor3hallway) {
			imageView.setX(getX -10);
			imageView.setY(new floor3hallway().getY);
			floor3hallway = false;
		}
		if (guestroom) {
			imageView.setX(getX);
			imageView.setY(getY -10);
			guestroom = false;
		}
		if (musicroom) {
			imageView.setX(getX);
			imageView.setY(getY -10);
			musicroom = false;
		}
	}
	static boolean stair1 = false;
	static boolean stair2 = false;
	static boolean floor3hallway = false;
	static boolean guestroom = false;
	static boolean musicroom = false;
	
	public static int getX;
	public static int getY;
	
	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		return move.nframe(x, y);

	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		//아래 계단
		if ((x == 260) && (y >=60) && (y <= 90)) {
			getX = x;
			getY = y;
			stair1 = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((x ==840) && (y >= 60) && (y <= 90)) {
			getX = x;
			getY = y;
			stair2 = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor2room/stair.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//오른쪽 복도
		if ((x ==1110) && (y >= 60) && (y <= 640)) {
			getX = x;
			getY = y;
			floor3hallway = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/floor3hallway.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//방들
		if((y == 640) && (x >=120)&& (x <=290)) {
			getX = x;
			getY = y;
			guestroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/guestroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if((y == 640) && (x >=810)&& (x <=970)) {
			getX = x;
			getY = y;
			musicroom = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/floor3room/musicroom.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
