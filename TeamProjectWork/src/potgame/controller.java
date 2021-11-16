package potgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class controller {
	MediaPlayer mp;
	Media m = null;

	@FXML
	private ImageView green;
	@FXML
	private ImageView red;
	@FXML
	private ImageView blue;
	@FXML
	private ImageView yellow;
	@FXML
	private ImageView pink;
	@FXML
	private ImageView pot;

	int r = 0;
	int b = 0;
	int y = 0;
	int num = 0;

	public void resetMouse(MouseEvent e) {
		r = 0;
		b = 0;
		y = 0;
		num = 0;
		pot.setImage(null);
	}
	
	int clickCount = 0;
	public void hintMouse(MouseEvent e) {
		if (clickCount == 0) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/potgame/hint.fxml"));
				Parent root;
				root = (Parent) loader.load();
				Stage stage = new Stage();
				stage.setTitle("힌트");
				stage.setScene(new Scene(root));
				stage.show();
				clickCount++;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			Alert al = new Alert(AlertType.INFORMATION);
			al.setTitle("힌트 사용 불가");
			al.setContentText("힌트를 이미 사용해서 쓸수 없습니다");
			al.show();
		}
	}

	public void reset() {
		r = 0;
		b = 0;
		y = 0;
		num = 0;
		pot.setImage(null);
	}

//초록 기능
	public void greensetOnDragDetected(MouseEvent event) {

		Dragboard db = green.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(green.getImage());
		db.setContent(content);
		event.consume();

	}

	public void greensetOnDragDone() {
		setOnDragDone(green);
	}

	public void greensetOnDragOver() {
		setOnDragOver(green);
	}

	// 빨강 기능
	public void redsetOnDragDetected(MouseEvent event) {

		Dragboard db = red.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(red.getImage());
		db.setContent(content);
		event.consume();

	}

	public void redsetOnDragDone() {
		setOnDragDone(red);
	}

	public void redsetOnDragOver() {
		setOnDragOver(red);
	}

//파랑기능
	public void bluesetOnDragDetected(MouseEvent event) {

		Dragboard db = blue.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(blue.getImage());
		db.setContent(content);
		event.consume();

	}

	public void bluesetOnDragDone() {
		setOnDragDone(blue);
	}

	public void bluesetOnDragOver() {
		setOnDragOver(blue);
	}
//노랑 기능
	public void yellowsetOnDragDetected(MouseEvent event) {

		Dragboard db = yellow.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(yellow.getImage());
		db.setContent(content);
		event.consume();

	}

	public void yellowsetOnDragDone() {
		setOnDragDone(yellow);
	}

	public void yellowsetOnDragOver() {
		setOnDragOver(yellow);
	}

//핑크 기능
	public void pinksetOnDragDetected(MouseEvent event) {

		Dragboard db = pink.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(pink.getImage());
		db.setContent(content);
		event.consume();

	}

	public void pinksetOnDragDone() {
		setOnDragDone(pink);
	}

	public void pinksetOnDragOver() {
		setOnDragOver(pink);
	}
//움직이는
	public void setOnDragOver(ImageView iv) {

		iv.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != iv && event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();

			}
		});

	}
//색깔 변형
	public void setOnDragDone(ImageView iv) {

		iv.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				Dragboard db = event.getDragboard();

				if (db.hasImage()) {
					num++;
					pot.setImage(new Image("/potgame/" + iv.getId() + "pot.png"));
					if (iv.equals(blue)) {
						b++;
					} else if (iv.equals(red)) {
						r++;
					} else if (iv.equals(yellow)) {
						y++;
					}
					if (num >= 4) {
						if (r == 2 && b == 1 && y == 1) {
							pot.setImage(new Image("/potgame/success2.png"));
							alert.setTitle("성공");
							alert.setContentText("성공");
							alert.show();
							mp = new MediaPlayer(new Media(getClass().getResource("/music/success1.mp3").toString()));
							mp.play();
						} else {
							alert.setTitle("실패");
							alert.setContentText("실패");
							alert.show();
							mp = new MediaPlayer(new Media(getClass().getResource("/music/BeepPing.mp3").toString()));
							mp.play();
							reset();
						}
					}

				}
				event.consume();

			}
		});
	}

}
