package floor1room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class f1item {
	@FXML
	private Button btn;
	@FXML
	private ImageView picture;
	@FXML
	private ImageView bookcase1;
	@FXML
	private ImageView bookcase2;
	@FXML
	private ImageView bookcase3;
	@FXML
	private ImageView bookcase4;
	@FXML
	private ImageView book1;
	@FXML
	private ImageView book2;
	@FXML
	private ImageView book3;
	@FXML
	private ImageView food;
	public static boolean foodbool = false;
	public static boolean picturebool = false;

	public void library() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room/library.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void kitchen() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room/kitchen.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dinnerhall() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room/dinnerhall.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void picture(MouseEvent e) {
		if(foodbool) {
			picture.setImage(new Image("/floor1room_item/pictureafter.png"));
			picturebool = true;
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("문이 열렸다");
			alert.setHeaderText("");
			alert.setContentText("문이 열리는 소리가 났다");
			alert.showAndWait();
		}	
	}
	
	public void food(MouseEvent e) {
		foodbool= true;
		food.setImage(new Image("/floor1room_item/foodafter.png"));		
	}

	public void bookcase1(MouseEvent e) {
		bookcase1.setImage(new Image("/floor1room_item/bookcase1.png"));
	}

	public void bookcase2(MouseEvent e) {
		bookcase2.setImage(new Image("/floor1room_item/bookcase2.png"));
	}

	public void bookcase3(MouseEvent e) {
		bookcase3.setImage(new Image("/floor1room_item/bookcase3.png"));
	}

	public void bookcase4(MouseEvent e) {
		bookcase4.setImage(new Image("/floor1room_item/bookcase4.png"));
	}

	public void book2(MouseEvent e) {
		book2.setImage(new Image("/floor1room_item/tablebookafter.png"));
	}

	public void book3(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room_item/book3-1.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void book3_1(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room_item/book3-2.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void book3_2(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor1room_item/book3-1.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
