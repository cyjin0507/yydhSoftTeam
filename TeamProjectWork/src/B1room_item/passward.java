package B1room_item;

import java.awt.SecondaryLoop;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class passward {

	
	@FXML
	private Label first; //1000
	@FXML
	private Label second; //0100
	@FXML
	private Label third; // 0010
	@FXML
	private Label fourth; //0001
	
	private static int current = 1;
	private static int ans = 8247;
	
	public void zero() {
		countUp(0);
	}
	public void one() {
		countUp(1);
	}
	public void two() {
		countUp(2);
	}
	public void three() {
		countUp(3);
	}
	public void four() {
		countUp(4);
	}
	public void five() {
		countUp(5);
	}
	public void six() {
		countUp(6);
	}
	public void seven() {
		countUp(7);
	}
	public void eight() {
		countUp(8);
	}
	public void nine() {
		countUp(9);
	}
	public void ten() {
		countUp(10);
	}

	public void countUp(int num) {
		if(current == 1) {
			fourth.setText(Integer.toString(num));
			current++;
		} else if(current == 2) {
			third.setText(fourth.getText());
			fourth.setText(Integer.toString(num));
			current++;
		} else if(current == 3) {
			second.setText(third.getText());
			third.setText(fourth.getText());
			fourth.setText(Integer.toString(num));
			current++;
		} else if(current == 4) {
			first.setText(second.getText());
			second.setText(third.getText());
			third.setText(fourth.getText());
			fourth.setText(Integer.toString(num));
			current++;
		}
	}
	
	public void countDown() {	
		if(current == 2) {
			fourth.setText("0");
			current--;
		} else if(current == 3) {
			fourth.setText(third.getText());
			third.setText("0");
			current--;
		} else if(current == 4) {
			fourth.setText(third.getText());
			third.setText(second.getText());
			second.setText("0");
			current--;
		} else if(current == 5) {
			fourth.setText(third.getText());
			third.setText(second.getText());
			second.setText(first.getText());
			first.setText("0");
			current--;
		}

	}
	
	public void enter() {
		int number = Integer.parseInt(first.getText()) * 1000 +Integer.parseInt(second.getText()) * 100 + Integer.parseInt(third.getText()) * 10 + Integer.parseInt(fourth.getText());

		if(ans == number) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("성공");
			alert.setHeaderText("성공");
			alert.setContentText("성공");
			alert.showAndWait();
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("/B1room/storage.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage) first.getScene().getWindow();
				primaryStage.setScene(scene);
				} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("test");
		
		}

		
		
	}
	
	
}
