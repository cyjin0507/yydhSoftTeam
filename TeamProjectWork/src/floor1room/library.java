package floor1room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gameStart.CharacterMove;
import gameStart.MainHoll;
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

public class library implements Initializable {
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
				

				KeyCode keyCode = event.getCode();
				if (keyCode.equals(KeyCode.SPACE)) {
					int x = (int) imageView.getX();
					int y = (int) imageView.getY();
					if ((y == 110) && (x >= 100) && (x <= 180)) {
						getX = x;
						getY = y;
						bookcase1 = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/bookcase1.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 110) && (x >= 340) && (x <= 420)) {
						getX = x;
						getY = y;
						bookcase2 = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/bookcase2.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 110) && (x >= 790) && (x <= 870)) {
						getX = x;
						getY = y;
						bookcase3 = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/bookcase3.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 470) && (x >= 520) && (x <= 600)) {
						getX = x;
						getY = y;
						bookcase4 = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/bookcase5.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 60) && (x == 460)) {
						getX = x;
						getY = y;
						book1 = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/book1.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((x == 450) && (y >= 530) && (x <= 590)) {
						getX = x;
						getY = y;
						book2= true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/book2.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 620) && (x >= 200) && (x <= 230)) {
						getX = x;
						getY = y;
						book3= true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/book3.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		move.stop(imageView);
		//문이동
		if (mainhall) {
			imageView.setX(getX);
			imageView.setY(getY +10);
			mainhall = false;
		}
		if (B1hallway1) {
			imageView.setX(getX);
			imageView.setY(getY -10);
			B1hallway1 = false;
		}
		if (new B1room.B1hallway1().library) {
			imageView.setX(1090);
			imageView.setY(420);
			new B1room.B1hallway1().library = false;
		}

		//아이템 조사시
		if (bookcase1) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase1 = false;
		}else if (bookcase2) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase2 = false;
		}else if (bookcase3) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase3 = false;
		}else if (bookcase4) {
			imageView.setX(getX);
			imageView.setY(getY);
			bookcase4 = false;
		}else if (book1) {
			imageView.setX(getX);
			imageView.setY(getY);
			book1 = false;
		}else if (book2) {
			imageView.setX(getX);
			imageView.setY(getY);
			book2 = false;
		}else if (book3) {
			imageView.setX(getX);
			imageView.setY(getY);
			book3 = false;
		}
	}

	public static boolean mainhall = false;
	public static boolean B1hallway1 = false;
	
    static boolean bookcase1 = false;
	static boolean bookcase2 = false;
	static boolean bookcase3 = false;
	static boolean bookcase4 = false;
	static boolean bookcase5 = false;
	static boolean bookcase6 = false;
	static boolean book1 = false;
	static boolean book2 = false;
	static boolean book3 = false;
	

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		// 위 의자와 책장
		if ((y == 110) && (x >= -10) && (x <= 450)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		} else if ((x == 460) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		}
//		위 오른쪽 책장
		if ((x == 1030) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "leftup";
			}
			return "left";
		} else if ((x == 620) && (y <= 100) && (y >= 60)) {
			if (y == 60) {
				return "rightup";
			}
			return "right";
		} else if ((y == 110) && (x >= 630) && (x <= 1020)) {
			return "up";
		}
//아래 왼쪽 책장
		if ((y == 470) && (x >= -10) && (x <= 330)) {
			if (x == -10) {
				return "leftup";
			}
			return "up";
		} else if ((y == 360) && (x >= -10) && (x <= 330)) {
			if (x == -10) {
				return "leftdown";
			}
			return "down";
		} else if ((x == 340) && (y >= 370) && (y <= 460)) {
			return "left";
		}
		// 아래 가운데 책장
		if ((x == 470) && (y >= 370) && (y <= 460)) {
			return "right";
		} else if ((x == 770) && (y >= 370) && (y <= 460)) {
			return "left";
		} else if ((y == 360) && (x >= 480) && (x <= 760)) {
			return "down";
		} else if ((y == 470) && (x >= 480) && (x <= 760)) {
			return "up";
		}
		// 아래 맨 끝쪽 바로 옆 책장
		if ((x == 870) && (y >= 370) && (y <= 460)) {
			return "right";
		} else if ((x == 1050) && (y >= 370) && (y <= 460)) {
			return "left";
		} else if((y == 360)&&(x>= 880)&&(x<= 1040)) {
			return "down";
		} else if((y == 470)&&(x >= 880)&&( x<= 1040)) {
			if(x == 1000) {
				return"rightup";
			}
			return "up";
		}
		//아래 맨 끝쪽 책장
		if((y ==540)&&(x>=1010)&&(x <= 1110)) {
			if(x == 1110) {
				return "rightup";
			}
			return "up";
		}else if((y ==420)&&(x>=1010)&&(x <= 1110)) {
			if(x == 1110) {
				return "rightdown";
			}
			return "down";
		}else if((x== 1000)&&(y >= 460)&&(y <= 530)) {
			return "right";
		}
		//책상과 의자
		if((y == 480)&&(x >=40)&&(x <=440)) {
			return "down";
		}else if((y == 620)&&(x >=40)&&(x <=440)) {
			return "up";
		}else if((x == 30)&&(y >= 490)&&(y <= 610)) {
			return "right";
		}else if((x == 450)&&(y >= 490)&&(y <= 610)) {
			return "left";
		}

		return move.nframe(x, y);

	}

	public void event() {
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 530) && (x <= 570)) {
			getX = x;
			getY = y;
			mainhall = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/gameStart/mainhall.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((y == 420) && (x >= 1050) && (x <= 1110)) {
			getX = x;
			getY = y;
			B1hallway1 = true;
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/B1hallway1.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) imageView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
