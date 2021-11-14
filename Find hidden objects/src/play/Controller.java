package play;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Controller {

	MediaPlayer mp;
	Media m = null;
	@FXML
	private Button CatTree;
	@FXML
	private Button CatSum;
	@FXML
	private Button duck;
	@FXML
	private Button mouse;
	@FXML
	private ImageView Cattree;
	@FXML
	private ImageView Catsum;
	@FXML
	private ImageView Duck;
	@FXML
	private ImageView Mouse;
	@FXML
	private Label label;

	int num = 4;

	@FXML
	void showImage(MouseEvent event) {
		mp = new MediaPlayer(new Media(getClass().getResource("/image/clickBtn.mp3").toString()));
		mp.play();
		Cattree.setVisible(true);
		num--;
		label.setText(Integer.toString(num));
		if (num == 0) {
			mp = new MediaPlayer(new Media(getClass().getResource("/image/success1.mp3").toString()));
			mp.play();
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("성공");
			al.setContentText("성공");
			al.show();
		}
	}

	@FXML
	void showImage2(MouseEvent event) {
		mp = new MediaPlayer(new Media(getClass().getResource("/image/clickBtn.mp3").toString()));
		mp.play();
		Catsum.setVisible(true);
		num--;
		label.setText(Integer.toString(num));
		if (num == 0) {
			mp = new MediaPlayer(new Media(getClass().getResource("/image/success1.mp3").toString()));
			mp.play();
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("성공");
			al.setContentText("성공");
			al.show();
		}
	}

	@FXML
	void showImage3(MouseEvent event) {
		mp = new MediaPlayer(new Media(getClass().getResource("/image/clickBtn.mp3").toString()));
		mp.play();
		Duck.setVisible(true);
		num--;
		label.setText(Integer.toString(num));
		if (num == 0) {
			mp = new MediaPlayer(new Media(getClass().getResource("/image/success1.mp3").toString()));
			mp.play();
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("성공");
			al.setContentText("성공");
			al.show();
		}
	}

	@FXML
	void showImage4(MouseEvent event) {
		mp = new MediaPlayer(new Media(getClass().getResource("/image/clickBtn.mp3").toString()));
		mp.play();
		Mouse.setVisible(true);
		num--;
		label.setText(Integer.toString(num));
		if (num == 0) {
			mp = new MediaPlayer(new Media(getClass().getResource("/image/success1.mp3").toString()));
			mp.play();
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("성공");
			al.setContentText("성공");
			al.show();
		}
	}
}
