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

		// 채팅창 띄우기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gameStart/chat.fxml"));
		Parent root = null;
		try {
			root = (Parent) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.setTitle("상대와 채팅");
		stage.setScene(new Scene(root));
		stage.show();
		
		//소켓 서버 입장하기
		try {
			enterSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("socket");
		}
		System.out.println(getPort());

	}
	
	//소켓 서버 입장하기
	public void enterSocket() throws UnknownHostException {
		System.out.println(userInfo());
		if(userInfo().equals("host")) {
			new Thread(new Runnable() {
				public void run() {
					server();
				}
			}).start();
			
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("ddddd");
					}
					client();
				}
			}).start();
		} else if(userInfo().equals("client")) {
			new Thread(new Runnable() {
				public void run() {
					client();
				}
			}).start();
		}
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
	

	/////// 소켓 클라이언트 부분
	public static void client() {
		Socket sck = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endFlag = false;
		String id = null;
		String code = null;
		try {
			// 서버의 소캣번호 입력
			sck = new Socket(getIp(), getPort());
			pw = new PrintWriter(new OutputStreamWriter(sck.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// code목록 읽어오기-서버에서 (123a,123b,456a,456p)의 보기를 준다. 클라이언트는 여기서 선택
			// 123, 456이 실질적 방번호
			System.out.println("코드읽어오기");
			String str = br.readLine();
			System.out.println(str);
			// 방번호 입력받기
			code = keyboard.readLine();
			pw.println(code);// code 스트링에 담아보내기
			pw.flush();
			System.out.println("===========" + code + "님의 대화창=========");
			// 서버로 부터 계속 읽어오는 스레드 실행
			InputThread it = new InputThread(sck, br);
			it.start();
			String line = null;
			while ((line = keyboard.readLine()) != null) {
				pw.println(code + "/" + line);
				pw.flush();
				if (line.equals("quit")) {
					System.out.println("시스템을 종료합니다.");
					endFlag = true;
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (sck != null)
					sck.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

class InputThread extends Thread {
	Socket sck = null;
	BufferedReader br = null;

	public InputThread(Socket sck, BufferedReader br) {
		this.sck = sck;
		this.br = br;
	}

	public void run()// 스레드로 서버로부터 계속 읽어오기
	{
		try {
			String line = null;
			// null값이 아니면 계속 읽어다 출력해주기
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("시스템을 종료합니다.");
		} finally {
			try {
				if (sck != null)
					sck.close();
				if (br != null)
					br.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
