package floor2room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class f2item {
	@FXML
	private Button btn;
	@FXML
	private ImageView mirrorbath;
	@FXML
	private ImageView bear;
	@FXML
	private ImageView mirrordress;
	@FXML
	private ImageView table;
	@FXML
	private ImageView grass;

	public static boolean key = false;

	public void drawingroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/drawingroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void powderroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/powderroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dressroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/dressroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void study() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bathroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/bathroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bedroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room/bedroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bookcase1(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room_item/bookbefore.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void bookcase1_2(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room_item/bookbefore.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void bookcase1_1(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room_item/bookafter.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void grass(MouseEvent e) {
		key = true;
		grass.setImage(new Image("/floor2room_item/grassafter.png"));
	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("열쇠획득");
		alert.setHeaderText("");
		alert.setContentText("열쇠를 획득했다");
		alert.showAndWait();
	
	}

	public void oil(MouseEvent e) {
		
	}

	public void handkerchief(MouseEvent e) {

	}

	public void bathroomMirror(MouseEvent e) {
		mirrorbath.setImage(new Image("/floor2room_item/mirrorafterBathroom.png"));
	}

	public void bear(MouseEvent e) {
		bear.setImage(new Image("/floor2room_item/bearafter.png"));
	}

	public void hat1(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room_item/hatbefore.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void hat2(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor2room_item/hatafter.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void gun(MouseEvent e) {

	}

	public void mirrordress(MouseEvent e) {
		// 총을 가져오면 되게
		mirrordress.setImage(new Image("/floor2room_item/mirrorafterdress.png"));
	}

	public void table(MouseEvent e) {
		// 먼지 가져오면 되게
		table.setImage(new Image("/floor2room_item/tableafter.png"));
	}

	public void dust(MouseEvent e) {

	}
}
