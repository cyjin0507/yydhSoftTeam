package mainGame;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import util.JDBCUtil;

public class gameReady implements Initializable {
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
//			makeTable();
		} else {
			player2Btn.setVisible(true);
		}

		user1.setItems(FXCollections.observableArrayList("탈출자1", "탈출자2"));
		user2.setItems(FXCollections.observableArrayList("탈출자1", "탈출자2"));

	}

	// 기본 데이터베이스 생성
	public void makeTable() {

		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ip = local.getHostAddress();

		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;

		String sql = "insert into game_info values(?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, serialNum());
			pstmt.setString(2, who());
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			pstmt.setString(6, ip);
			pstmt.setInt(7, 1234);
			pstmt.setString(8, "waitting");
			pstmt.setString(9, "waitting");

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void ready1() throws UnknownHostException {
		String role = user1.getSelectionModel().getSelectedItem();
		if (user1.getSelectionModel().getSelectedItem().equals("탈출자1")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;

			String sql = "UPDATE `game_info` SET `escape1`=  '" + who() + "' WHERE `user1` = '" + who() + "'";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (user1.getSelectionModel().getSelectedItem().equals("탈출자2")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;

			String sql = "UPDATE `game_info` SET `escape2`=  '" + who() + "' WHERE `user1` = '" + who() + "'";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void ready2() throws UnknownHostException {
		String role = user1.getSelectionModel().getSelectedItem();
		if (user1.getSelectionModel().getSelectedItem().equals("탈출자1")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;

			String sql = "UPDATE `game_info` SET `escape1`=  '" + who() + "' WHERE `user2` = '" + who() + "'";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (user1.getSelectionModel().getSelectedItem().equals("탈출자2")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();
			PreparedStatement pstmt = null;

			String sql = "UPDATE `game_info` SET `escape2`=  '" + who() + "' WHERE `user2` = '" + who() + "'";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	// 일련번호 생성
	public String serialNum() {
		Random random = new Random();
		String strRand[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n" };
		String serialStr = strRand[random.nextInt(12) + 0] + strRand[random.nextInt(12) + 0];
		int serialNum = random.nextInt(100) + 999;
		String serial = serialStr + String.valueOf(serialNum);
		return serial;
	}

	// 누가 로그인 중인지 확인
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
				String nickname = rs.getString("nickname");
				if (login.equals(ip)) {
					return nickname;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
