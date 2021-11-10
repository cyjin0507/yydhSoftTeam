package gameStart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class gameMain extends socket implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		new Thread(new Runnable() {
			public void run() {
				server();
			}
		}).start();
		
	}

	
	
}