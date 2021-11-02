package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class controller {
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

	public void setOnDragDone(ImageView iv) {

		iv.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				Dragboard db = event.getDragboard();

				if (db.hasImage()) {
					num++;
					pot.setImage(new Image("/image/" + iv.getId() + "pot.png"));
					if (iv.equals(blue)) {
						b++;
					} else if (iv.equals(red)) {
						r++;
					} else if (iv.equals(yellow)) {
						y++;
					}
					if (num >= 4) {
						if (r == 2 && b == 1 && y == 1) {
							pot.setImage(new Image("/image/success2.png"));
							alert.setTitle("성공");
							alert.setContentText("성공");
							alert.show();
						} else {
							alert.setTitle("실패");
							alert.setContentText("실패");
							alert.show();
							reset();
						}
					}

				}
				event.consume();

			}
		});
	}


}
