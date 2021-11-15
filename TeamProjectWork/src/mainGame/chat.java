package mainGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.server;
import util.JDBCUtil;

public class chat extends server implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}
	
	

	// 내가 누구인지 가져오기 (user1, user2)
	public String userInfo() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_info WHERE `user1` = '" + who() + "' OR `user2` = '" + who() + "'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String user1 = rs.getString("user1");
				String user2 = rs.getString("user2");
				
				if(user1.equals(who())) {
					return "host";
				} else if(user1.equals(who())) {
					return "client";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;

	}

	// 누가 로그인 중인지 확인
	public static String who() throws UnknownHostException {

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

	//게임 포트 번호 가져오기
	public static int getPort() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = "select * from game_info WHERE `user1` = '" + who() + "' OR `user2` = '" + who() + "'";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int port = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				port = rs.getInt("port");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return port;
	}
	
	//게임 아이피 번호 가져오기
	public static String getIp() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = "select * from game_info WHERE `user1` = '" + who() + "' OR `user2` = '" + who() + "'";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ip = "";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ip = rs.getString("ip");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ip;
	}


}
