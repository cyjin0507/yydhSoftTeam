package mainGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class gameReady implements Initializable{
	@FXML
	private Button player1Btn;
	@FXML
	private Button player2Btn;
	@FXML
	private ChoiceBox<String> user1;
	@FXML
	private ChoiceBox<String> user2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gameRequest rq = new gameRequest();
		System.out.println(rq.player);
		if (rq.player) {
			player1Btn.setVisible(true);

		} else {
			player2Btn.setVisible(true);
		}
		
		user1.setItems(FXCollections.observableArrayList("탈출자1", "탈출자2"));
		user2.setItems(FXCollections.observableArrayList("탈출자1", "탈출자2"));
		
	}
	
	//초이스박스 설정
	
	
}
