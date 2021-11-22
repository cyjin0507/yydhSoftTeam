package gameStart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CharacterMove implements Initializable {
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String image = imageView.getId();
		sprite();
		if (image.equals("floor1")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, floor1setStopPoint());
					floor1event();
				}
			});
			stop();
		} else if (image.equals("floor2")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, floor2setStopPoint());
					floor2event();
				}
			});
			stop();
		} else if (image.equals("floor3")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, floor3setStopPoint());
					floor3event();
				}
			});
			stop();
		} else if (image.equals("floor3_1")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, floor3_small1setStopPoint());
					floor3_small1event();
				}
			});
			stop();
		} else if (image.equals("floor3_2")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, floor3_small2setStopPoint());
					floor3_small2event();
				}
			});
			stop();
		} else if (image.equals("B1")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, B1setStopPoint());
					B1event();
				}
			});
			stop();
		} else if (image.equals("library")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, librarysetStopPoint());
					B1event();
				}
			});
			stop();
		} else if (image.equals("dinnerhall")) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					pressed(event, dinnerhallsetStopPoint());
					B1event();
				}
			});
			stop();
		}

	}

// 모션 스땁
	public void stop() {
		imageView.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				animation.stop();
			}
		});
	}

//눌렀을때 움직이는거
	public void pressed(KeyEvent event, String moveStop) {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		KeyCode keyCode = event.getCode();
		if (moveStop.equals("up")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("down")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("left")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("right")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("leftup")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("rightup")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("leftdown")) {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else {
				animation.stop();
			}
		} else if (moveStop.equals("rightdown")) {
			if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else {
				animation.stop();
			}
		} else {
			if (keyCode.equals(KeyCode.RIGHT)) {
				right(x);
			} else if (keyCode.equals(KeyCode.LEFT)) {
				left(x);
			} else if (keyCode.equals(KeyCode.UP)) {
				up(y);
			} else if (keyCode.equals(KeyCode.DOWN)) {
				down(y);
			}
		}
	}

	public SpriteAnimation animation;

//위 아래 왼쪽 오른쪽
	public void up(int y) {

		animation.play();
		animation.setOffsetY(450);
		imageView.setY(y - 10);
	}

	public void down(int y) {
		animation.play();
		animation.setOffsetY(0);
		imageView.setY(y + 10);
	}

	public void left(int x) {
		animation.play();
		animation.setOffsetY(150);
		imageView.setX(x - 10);
	}

	public void right(int x) {
		animation.play();
		animation.setOffsetY(300);
		imageView.setX(x + 10);
	}

	// 키보드 땠을때
	public void Released(KeyEvent event) {
		KeyCode keyCode = event.getCode();
		if (keyCode.equals(KeyCode.RIGHT)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.LEFT)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.UP)) {
			animation.stop();
			animation.setOffsetX(100);
		} else if (keyCode.equals(KeyCode.DOWN)) {
			animation.stop();
			animation.setOffsetX(100);
		}
	}

//캐릭터 모션
	public void sprite() {
		imageView.setImage(new Image("/roomImage/all.png"));
		animation = new SpriteAnimation(imageView, Duration.millis(250), 3, 4, 0, 0, 100, 150);
	}

//기본 틀
	public String frame(int x, int y) {
		if (y <= 110) {
			if (x <= 10) {
				return "leftup";
			}
			if (x >= 1090) {
				return "rightup";
			}
			return "up";
		} else if (y >= 620) {
			if (x <= 10) {
				return "leftdown";
			}
			if (x >= 1090) {
				return "rightdown";
			}
			return "down";
		} else if (x <= 10) {
			return "left";
		} else if (x >= 1090) {
			return "right";
		}
		return "";
	}

	// 쪽방 틀
	public String smallframe(int x, int y) {
//		전체 배경 안빠져나가게
		if (y <= 120) {
			if (x <= 10) {
				return "leftup";
			}
			if (x >= 600) {
				return "rightup";
			}
			return "up";
		} else if (y >= 620) {
			if (x <= 10) {
				return "leftdown";
			}
			if (x >= 600) {
				return "rightdown";
			}
			return "down";
		} else if (x <= 10) {
			return "left";
		} else if (x >= 600) {
			return "right";
		}
		return "";

	}

//====================================================
	// 3층 쪽방 2 멈추는거
	public String dinnerhallsetStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);
		return frame(x, y);

	}

	public String librarysetStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);
		return frame(x, y);

	}

	// 3층 쪽방 2 멈추는거
	public String floor3_small2setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		// 책장
		if ((y == 180) && (x >= 10) && (x <= 130)) {
			if (x == 10) {
				return "leftup";
			}
			return "up";
		} else if ((x == 140) && (y <= 170) && (y >= 130)) {
			if (y == 130) {
				return "leftup";
			}
			return "left";
		}
		// 빗자루
		if ((x == 530) && (y >= 130) && (y <= 150)) {
			if (y == 130) {
				return "rightup";
			}
			return "right";
		} else if ((y == 160) && (x >= 540) && (x <= 600)) {
			if (x == 600) {
				return "rightup";
			}
			return "up";
		} else {
			return smallframe(x, y);
		}

	}

	// 3층 쪽방 2이벤트
	public void floor3_small2event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 130) && (x >= 260) && (x <= 370)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/btngame/MainLayout.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// 3층 쪽방 1 멈추는거
	public String floor3_small1setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		// 세면대
		if ((x == 220) && (y >= 100) && (y <= 120)) {
			if (y >= 100) {
				return "rightup";
			}
			return "right";
		} else if ((y == 130) && (x >= 230) && (x <= 330)) {
			return "up";
		} else if ((x == 340) && (y >= 100) && (y <= 120)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		}
		// 변기
		if ((x == 600) && (y >= 100) && (y <= 160)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		} else if ((x <= 590) && (y == 170) && (x >= 440)) {
			return "up";
		} else if ((x == 430) && (y >= 100) && (y <= 160)) {
			if (y == 100) {
				return "rightup";
			}
			return "right";
		} else {
			return smallframe(x, y);
		}
	}

	// 3층 쪽방 1이벤트
	public void floor3_small1event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 100) && (x <= 100) && (x >= 40)) {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/pipegame/layout.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// 3층 멈추는거
	public String floor3setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		System.out.println(x + "," + y);
//		책상 충돌 방지
		if ((y == 270) && (x >= 360) && (x <= 750)) {
			if ((x == 660) && (y <= 270) && (y >= 170)) {
				return "leftdown";
			}
			if ((x == 470) && (y <= 270) && (y >= 170)) {
				return "rightdown";
			}
			return "down";
		} else if ((y >= 270) && (y <= 520) && (x == 370)) {
			return "right";
		} else if ((y == 520) && (x >= 360) && (x <= 750)) {
			return "up";
		} else if ((y >= 270) && (y <= 520) && (x == 760)) {
			return "left";
		}
//		의자 충돌
		if ((x == 660) && (y <= 270) && (y >= 170)) {
			return "leftdown";
		} else if ((x == 470) && (y <= 270) && (y >= 170)) {
			return "rightdown";
		} else if ((y == 160) && (x <= 650) && (x >= 470)) {
			return "down";
		}
//식물
		if ((x == 120) && (y >= 460)) {
			if (y == 620) {
				return "leftdown";
			}
			return "left";
		} else if ((y == 460) && (x <= 120)) {
			if (x == 10) {
				return "leftdown";
			}
			return "down";
		}
//옷걸이
		if ((x == 970) && (y >= 440)) {
			if (y == 620) {
				return "rightdown";
			}
			return "right";
		} else if ((y == 440) && (x >= 970)) {
			if (x == 1090) {
				return "rightdown";
			}
			return "down";
		}
//책꽂이
		if ((x == 370) && (y <= 130) && (y >= 100)) {
			if (y == 100) {
				return "rightup";
			}
			return "right";
		} else if ((x == 740) && (y <= 130) && (y >= 100)) {
			if (y == 100) {
				return "leftup";
			}
			return "left";
		} else if ((x >= 380) && (x <= 720) && (y == 140)) {
			return "up";
		} else {
			return frame(x, y);
		}
	}

	// 3층 이벤트
	public void floor3event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		
		
		if ((y == 110) && (x >= 270) && (x <= 320)) {
			imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					KeyCode keyCode = event.getCode();
					if (keyCode.equals(KeyCode.SPACE)) {
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/puzzle/puzzleLayout.fxml"));
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

	// 2층 멈추는거
	public String floor2setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
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
			return frame(x, y);
		}
	}

	// 2층 이벤트
	public void floor2event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 115) && (x <= 270) && (x >= 220)) {

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

	// 1층 멈추는거
	public String floor1setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		// 싱크대
		if ((y == 220) && (x <= 155) && (x >= 5)) {
			if (x == 5) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 155) && (y <= 620) && (y >= 230)) {
			if (y == 620) {
				return "leftdown";
			}
			return "left";
		}
//				테이블
		if ((y == 300) && (x >= 685) && (x <= 735)) {
			if (x == 735) {
				return "rightdown";
			}
			return "down";
		} else if ((x == 735) && (y <= 300) && (y >= 230)) {
			return "right";
		} else if ((y == 230) && (x >= 745) && (x <= 935)) {
			return "down";
		} else if ((x == 945) && (y >= 240) && (y <= 290)) {
			return "left";
		} else if ((y == 300) && (x >= 945) && (x <= 1015)) {
			if (x == 945) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 1025) && (y >= 310) && (y <= 570)) {
			return "left";
		} else if ((y == 580) && (x <= 1015) && (x >= 675)) {
			return "up";
		} else if ((x == 665) && (y >= 310) && (y <= 570)) {
			return "right";
		} else {
			return frame(x, y);
		}
	}

	// 1층 이벤트
	public void floor1event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((x == 155) && (y >= 420) && (x <= 520)) {

			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/touchGame/touchGameLayout.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

//B1 멈추는거
	public String B1setStopPoint() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 210) && (x >= 330) && (x <= 800)) {
			return "down";
		} else if ((x == 810) && (y >= 220) && (y <= 480)) {
			return "left";
		} else if ((x == 310) && (y >= 220) && (y <= 480)) {
			return "right";
		} else if ((y == 490) && (x >= 330) && (x <= 800)) {
			return "up";
		} else {
			return frame(x, y);
		}
	}

//B1 이벤트
	public void B1event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();
		if ((y == 490) && (x >= 330) && (x <= 800)) {
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

}
