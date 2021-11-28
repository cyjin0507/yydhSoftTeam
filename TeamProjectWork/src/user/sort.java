package user;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class sort {

	public String sort() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_info";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String user1 = rs.getString("user1");
				String user2 = rs.getString("user2");
				if(user1.equals(who())) {
					return "user1";
				} else if(user1.equals(who())) {
					return "user2";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
	
	//나랑 같이 게임한 친구 확인 확인
	public String me() throws UnknownHostException {
		if(sort().equals("user1")) {
			JDBCUtil db = new JDBCUtil();
			java.sql.Connection con = db.getConnection();

			java.sql.PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from game_info WHERE user1 = '"+ who() +"'";

			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String user2 = rs.getString("user2");
					return user2;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return null;
	}
	
	//기존 친목도
	public int figure() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from request WHERE sendUserId = '"+ who() +"' AND receiveUserId = '" + me() + "'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int friendship = rs.getInt("friendship");
				return friendship;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
	public void friendShipUp() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE `request` SET `friendship`=  '" + figure() + 10 + "' WHERE sendUserId = '"+ who() +"' AND receiveUserId = '" + me() + "'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//game_info 데베 삭제
	public void gameDelete() throws UnknownHostException {
		if(sort().equals("user1")) {
			JDBCUtil db = new JDBCUtil();
			Connection con = db.getConnection();

			PreparedStatement pstmt = null;

			String sql = "DELETE FROM game_ready WHERE user1 = '" + who() + "'";

			try {
				pstmt = con.prepareStatement(sql);

				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	//게임 둘다 성공했는지 확인
	public boolean check() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_info WHERE user1 = '"+ who() +"' OR user2 = '" + who() + "'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String escape1 = rs.getString("escape1");
				String escape2 = rs.getString("escape2");
				if(escape1.equals("") || escape2.equals("")) {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
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
