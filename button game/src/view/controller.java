package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class controller implements Initializable {
	MediaPlayer mp;
	Media m = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	String num;
	String sum = "0";

	public void btnAction1() {
		num = "1";
		sum();
	}

	public void btnAction2() {
		num = "2";
		sum();

	}

	public void btnAction3() {
		num = "3";
		sum();

	}

	public void btnAction4() {
		num = "4";
		sum();
	}

	public void btnAction5() {
		num = "5";
		sum();

	}

	public void btnAction6() {
		num = "6";
		sum();

	}

	public void btnAction7() {
		num = "7";
		sum();

	}

	public void btnAction8() {
		num = "8";
		sum();

	}

	public void btnAction9() {
		num = "9";
		sum();

	}

	public void btnAction10() {
		num = "10";
		sum();

	}

	public void btnAction11() {
		num = "11";
		sum();

	}

	public void btnAction12() {
		num = "12";
		sum();

	}

	public void btnAction13() {
		num = "13";
		sum();

	}

	public void btnAction14() {
		num = "14";
		sum();

	}

	public void btnAction15() {
		num = "15";
		sum();

	}

	public void btnAction16() {
		num = "16";
		sum();

	}

	public void btnAction17() {
		num = "17";
		sum();

	}

	public void reset() {
		num = "0";
		sum = "0";
		i = 0;
	}

	int i = 0;

	public void sum() {

		mp = new MediaPlayer(new Media(getClass().getResource("/resourses/clickBtn.mp3").toString()));
		mp.play();
		i++;

		sum += num;
		System.out.println(sum);
		if (sum.equals("03462891016")) {
//			mp = new MediaPlayer(new Media(getClass().getResource("/resourses/success1.mp3").toString()));
			mp = new MediaPlayer(new Media(getClass().getResource("/resourses/success2.mp3").toString()));

			mp.play();
			// 여기에 방넘어가는거 넣기
			reset();
//미안......내가 생각해도 날먹이다...
		} else if (i >= 8 && !sum.equals("03462891016")) {
			mp = new MediaPlayer(new Media(getClass().getResource("/resourses/BeepPing.mp3").toString()));

			mp.play();
			reset();
			

		}

	}

}
