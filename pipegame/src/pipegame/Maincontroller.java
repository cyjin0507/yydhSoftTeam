package pipegame;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Maincontroller {
	
	MediaPlayer mp;
	Media m = null;

	@FXML
	private ImageView iv1;
	@FXML
	private ImageView iv2;
	@FXML
	private ImageView iv3;
	@FXML
	private ImageView iv4;
	@FXML
	private ImageView iv5;
	@FXML
	private ImageView iv6;
	@FXML
	private ImageView iv7;
	@FXML
	private ImageView iv8;
	@FXML
	private ImageView iv9;
	@FXML
	private ImageView iv10;
	@FXML
	private ImageView iv11;
	@FXML
	private ImageView iv12;
	@FXML
	private ImageView iv13;
	@FXML
	private ImageView iv14;
	@FXML
	private ImageView iv15;
	int i = 90;

	public void getRotate() {
		if ((int) iv2.getRotate() == 0 && (int) iv7.getRotate() == 0 && (int) iv8.getRotate() == 0
				&& (int) iv4.getRotate() == 0 && (int) iv9.getRotate() == 0 && (int) iv14.getRotate() == 0
				&& (int) iv15.getRotate() == 0 && (int) iv3.getRotate() == 0) {
			mp = new MediaPlayer(new Media(getClass().getResource("/image/success1.mp3").toString()));
			mp.play();
			Alert al = new Alert(AlertType.CONFIRMATION);
			al.setTitle("성공");
			al.setContentText("성공");
			al.show();
		}
	}

	public void iv1Action(MouseEvent e) {
		if (i > 270)
			i = 0;
		i += 90;
		iv1.setRotate(i);

		getRotate();
	}

	public void iv2Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv2.setRotate(i);

		getRotate();
	}

	public void iv3Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv3.setRotate(i);

		getRotate();
	}

	public void iv4Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv4.setRotate(i);

		getRotate();
	}

	public void iv5Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv5.setRotate(i);

		getRotate();
	}

	public void iv6Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv6.setRotate(i);

		getRotate();
	}

	public void iv7Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv7.setRotate(i);

		getRotate();
	}

	public void iv8Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv8.setRotate(i);

		getRotate();
	}

	public void iv9Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv9.setRotate(i);

		getRotate();
	}

	public void iv10Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv10.setRotate(i);

		getRotate();
	}

	public void iv11Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv11.setRotate(i);

		getRotate();
	}

	public void iv12Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv12.setRotate(i);

		getRotate();
	}

	public void iv13Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv13.setRotate(i);

		getRotate();
	}

	public void iv14Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv14.setRotate(i);

		getRotate();
	}

	public void iv15Action(MouseEvent e) {
		i += 90;
		if (i > 270)
			i = 0;
		iv15.setRotate(i);

		getRotate();
	}

}
