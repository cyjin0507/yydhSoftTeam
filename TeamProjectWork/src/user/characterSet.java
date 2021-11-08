package user;

import java.awt.Button;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.JDBCUtil;

public class characterSet implements Initializable{
	ArrayList<String> characterList = new ArrayList<String>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	int pass = 0;
	
	public void choice() {		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE `users` SET `user_character`= '" + Integer.toString(pass)  +"' WHERE id = '"+ who()+"'";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public String who() throws UnknownHostException {

		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();

		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String login = rs.getString("login");
				String id = rs.getString("id");
				if (login.equals(ip)) {
					return id;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
	public void before() {
		
		pass--;
		if(pass < 0) {
			pass = 10;//마지막 사진 으로
		}
		character.setImage(new Image(characterList.get(pass)));
	}

	public void next() {
		pass++;
		if(pass >10) { //최대값으로 변경
			pass = 0;
		}
		character.setImage(new Image(characterList.get(pass)));
	}

	

}
