package floor3room_item;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class f3item {
	@FXML
	private Button btn;

	@FXML
	private ImageView paper;
	@FXML
	private ImageView stove;

	public static boolean paperbool = false;

	public void dressroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/dressroom.fxml"));
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
			root = FXMLLoader.load(getClass().getResource("/floor3room/powderroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void livingroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/livingroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void musicroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/musicroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guestroom() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room/guestroom.fxml"));
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
			root = FXMLLoader.load(getClass().getResource("/floor3room/bathroom.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bedbottom(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room_item/bedbottomafter.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void drawer(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room_item/drawerafter.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void drawerafter(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room_item/paper.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void paper(MouseEvent e) {
		paperbool = true;
		paper.setImage(new Image("/floor3room_item/paperafter.png"));
	}

	public void stove(MouseEvent e) {
		if (paperbool) {
			stove.setImage(new Image("/floor3room_item/stoveafter.png"));
		}

	}
	public void closet(MouseEvent e) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/floor3room_item/closet1after.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
