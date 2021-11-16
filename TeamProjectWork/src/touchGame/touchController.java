package touchGame;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class touchController {

	@FXML
	private ImageView btn1;
	@FXML
	private ImageView btn2;
	@FXML
	private ImageView btn3;
	@FXML
	private ImageView btn4;
	@FXML
	private ImageView btn5;
	@FXML
	private ImageView btn6;
	@FXML
	private ImageView btn7;
	@FXML
	private ImageView btn8;
	@FXML
	private ImageView btn9;

	@FXML
	private Button gameStart;

	// 게임시작
	public void gameStart() {

		new Thread(new Runnable() {
			public void run() {
				randomBtn();
			}
		}).start();
		if (success == true) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/gameStart/B1.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) gameStart.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	boolean success = false;
	public static int btnNumber = 2;
	public static boolean touchWhether = false;

	public void randomBtn() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int btnNum = (int) (Math.random() * 9 + 1);
			btnNumber = btnNum;
			if (btnNumber == 1) {
				light1();
				touchWhether = true;
			}
			if (btnNumber == 2) {
				light2();
				touchWhether = true;
			}
			if (btnNumber == 3) {
				light3();
				touchWhether = true;
			}
			if (btnNumber == 4) {
				light4();
				touchWhether = true;
			}
			if (btnNumber == 5) {
				light5();
				touchWhether = true;
			}
			if (btnNumber == 6) {
				light6();
				touchWhether = true;
			}
			if (btnNumber == 7) {
				light7();
				touchWhether = true;
			}
			if (btnNumber == 8) {
				light8();
				touchWhether = true;
			}
			if (btnNumber == 9) {
				light9();
				touchWhether = true;
			}

		}
		success = true;
	}

	@FXML
	private Label scoreLook;
	public static int score = 0;

	public void touch1() {
		if (btnNumber == 1 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch2() {
		if (btnNumber == 2 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch3() {
		if (btnNumber == 3 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch4() {
		if (btnNumber == 4 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch5() {
		if (btnNumber == 5 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch6() {
		if (btnNumber == 6 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch7() {
		if (btnNumber == 7 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch8() {
		if (btnNumber == 8 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void touch9() {
		if (btnNumber == 9 && touchWhether == true) {
			score++;
			scoreLook.setText(score + "점");
			touchWhether = false;
		}
	}

	public void light1() {
		btn1.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn1.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light2() {
		btn2.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn2.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light3() {
		btn3.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn3.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light4() {
		btn4.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn4.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light5() {
		btn5.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn5.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light6() {
		btn6.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn6.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light7() {
		btn7.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn7.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light8() {
		btn8.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn8.setImage(new Image("/touchGame/빈버튼.png"));
	}

	public void light9() {
		btn9.setImage(new Image("/touchGame/터치버튼.png"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btn9.setImage(new Image("/touchGame/빈버튼.png"));
	}

	@FXML
	private Label time;
	public static int sec = 0;

//	public void time() {
//
//		while (sec <= 20) {
//			new Thread(new Runnable() {
//				public void run() {
//					try {
//						Thread.sleep(1000);
//						time.setText(String.valueOf(sec));
//						sec++;
//
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}).start();
//		}
//
//	}

}
