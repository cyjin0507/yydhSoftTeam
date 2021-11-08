package user;

import java.awt.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.JDBCUtil;

public class characterSet implements Initializable{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<String> characterList = new ArrayList<String>();
		characterList.add("/userImage/사진 넣기");
		characterList.add("/userImage/사진 넣기");
		characterList.add("/userImage/사진 넣기");

	}
	@FXML
	private ImageView character;
	@FXML
	private Button choice;
	@FXML
	private Button before;
	@FXML
	private Button next;

	String characterValue = null;
	public void choice() {		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;


		
		String sql = "UPDATE `users` SET `user_character`= '" + characterValue  +"' WHERE id = '"+id+"'";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void before() {
		character.setImage(new Image());
	}

	public void next() {
		character.setImage(new Image());
	}

	

}
