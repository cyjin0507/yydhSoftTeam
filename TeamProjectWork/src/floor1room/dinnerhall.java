package floor1room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import floor1room_item.f1item;
import gameStart.CharacterMove;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class dinnerhall implements Initializable {
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView table;

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
					if ((y == 200) && (x >= 580) && (x <= 700)) {
						getX = x;
						getY = y;
						food = true;

						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/food.fxml"));
							Scene scene = new Scene(root);
							Stage primaryStage = (Stage) imageView.getScene().getWindow();
							primaryStage.setScene(scene);
							} catch (IOException e) {
							e.printStackTrace();
						}
					}else if ((y == 60) && (x >= 370) && (x <= 730)) {
						getX = x;
						getY = y;
						picture = true;
						try {
							Parent root;
							root = FXMLLoader.load(getClass().getResource("/floor1room_item/picture.fxml"));
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
		if (mainhall) {
			imageView.setX(getX);
			imageView.setY(getY + 10);
			mainhall = false;
		}
		if (kitchen) {
			imageView.setX(getX);
			imageView.setY(getY +10);
			kitchen = false;
		}
		
		//?????????
		if (food) {
			imageView.setX(getX);
			imageView.setY(getY);
			food = false;
		}
		if (picture) {
			imageView.setX(getX);
			imageView.setY(getY);
			picture = false;
		}
		if(new f1item().foodbool) {
			table.setVisible(true);
		}
	}

	public static boolean mainhall = false;
	static boolean kitchen = false;
	
	static boolean food = false;
	static boolean picture = false;

	public static int getX;
	public static int getY;

	public String setStopPoint() {
		CharacterMove move = new CharacterMove();
		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

//??? ????????? ??? ??????
		if ((y == 180) && (x >= 880) && (x <= 1010)) {
			return "down";
		} else if ((x == 870) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "rightdown";
			}
			return "right";
		} else if ((x == 1020) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "leftdown";
			}
			return "left";
		}
//????????? ?????? ??????
		if ((y == 490) && (x >= 880) && (x <= 1010)) {
			return "up";
		} else if ((y == 410) && (x >= 880) && (x <= 1010)) {
			return "down";
		} else if ((x == 870) && (y >= 420) && (y <= 480)) {
			return "right";
		} else if ((x == 1020) && (y >= 420) && (y <= 480)) {
			return "left";
		}
//????????? ?????? ?????????
		if ((x == 810) && (y >= 410) && (y <= 450)) {
			if (y == 410) {
				return "leftup";
			}
			return "left";
		} else if ((x == 670) && (y >= 410) && (y <= 450)) {
			if (y == 410) {
				return "rightup";
			}
			return "right";
		} else if ((y == 460) && (x >= 680) && (x <= 800)) {
			return "up";
		}
//??????????????? ?????????
		if ((x == 610) && (y >= 410) && (y <= 450)) {
			if (y == 410) {
				return "leftup";
			}
			return "left";
		} else if ((x == 460) && (y >= 410) && (y <= 450)) {
			if (y == 410) {
				return "rightup";
			}
			return "right";
		} else if ((y == 460) && (x >= 470) && (x <= 600)) {
			return "up";
		}
//??????????????? ?????????
		if ((y == 490) && (x >= 280) && (x <= 410)) {
			return "up";
		} else if ((y == 410) && (x >= 280) && (x <= 410)) {
			return "down";
		} else if ((x == 270) && (y >= 420) && (y <= 480)) {
			return "right";
		} else if ((x == 420) && (y >= 420) && (y <= 480)) {
			return "left";
		}
//??????????????? ????????????
		if ((y == 430) && (x >= 90) && (x <= 220)) {
			return "up";
		} else if ((x == 100) && (y >= 410) && (y <= 420)) {
			if (y == 410) {
				return "rightup";
			}
			return "right";
		} else if ((x == 230) && (y >= 410) && (y <= 420)) {
			if (y == 410) {
				return "leftup";
			}
			return "left";
		}
//????????? ???????????? ?????????
		if ((y == 180) && (x >= 120) && (x <= 230)) {
			return "down";
		} else if ((x == 110) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "rightdown";
			}
			return "right";
		} else if ((x == 240) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "leftdown";
			}
			return "left";
		}
//?????????
		if ((x == 270) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "rightdown";
			}
			return "right";
		} else if ((x == 420) && (y >= 180) && (y <= 200)) {
			if (y == 200) {
				return "leftdown";
			}
			return "left";
		} else if ((y == 170) && (x <= 410) && (x >= 280)) {
			return "down";
		}

		// ?????????
		if ((y == 200) && (x >= 10) && (x <= 1080)) {
			return "down";
		} else if ((y == 410) && (x >= 10) && (x <= 1080)) {
			return "up";
		} else if ((x == 0) && (y >= 210) && (y <= 400)) {
			return "right";
		} else if ((x == 1090) && (y >= 210) && (y <= 400)) {
			return "left";
		}

		return move.nframe(x, y);
	}

	public void event() {

		int x = (int) imageView.getX();
		int y = (int) imageView.getY();

		if ((y == 60) && (x >= 20) && (x <= 60)) {
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
		if ((y == 60) && (x >= 1040) && (x <= 1080)) {
			if(new f1item().picturebool) {
				getX = x;
				getY = y;
				kitchen = true;
				try {
					Parent root;
					root = FXMLLoader.load(getClass().getResource("/floor1room/kitchen.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage) imageView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("??????");
				alert.setHeaderText("");
				alert.setContentText("?????? ????????????");
				alert.showAndWait();
			}
			
		}

	}
}
