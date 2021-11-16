package mainGame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import util.JDBCUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class chat extends server implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			enterSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("enterSocket 오류");
		}
	}

	Socket socket;

	// 소켓 서버 입장하기
	public void enterSocket() throws UnknownHostException {
		System.out.println(userInfo());
		if(userInfo().equals("host")) {
			System.out.println("host");
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
						e.printStackTrace();
					}
					startClient(getIp(), getPort());
				}
			}).start();
		} else if(userInfo().equals("client")) {
			System.out.println("client");
			new Thread(new Runnable() {
				public void run() {
					startClient(getIp(), getPort());
				}
			}).start();
		}
	}
	



//클라이언트 프로그램 동작 메소드
	public void startClient(String IP, int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket(IP, port);
					receive();
				} catch (Exception e) {
					if (!socket.isClosed()) {
						stopClient();
						System.out.println("서버 접속 실패");
						Platform.exit();

					}
				}
			}
		};
		thread.start();
	}

//클라이언트 프로그램 종료 메소드
	public void stopClient() {
		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//서버로 부터 메세지를 전달받는 메소드
	public void receive() {
		while (true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if (length == -1)
					throw new IOException();
				String message = new String(buffer, 0, length, "UTF-8");
				Platform.runLater(() -> {
					textArea.appendText(message);
				});
			} catch (Exception e) {
				stopClient();
				break;
			}
		}
	}

//서버로부터 메시지를 전송하는 메소드
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}

//실제로 프로그램을 동작시키는 메소드
	@FXML
	private TextField userName;
	@FXML
	private TextField IPText;
	@FXML
	private TextField portText;

	@FXML
	private TextArea textArea;
	@FXML
	private TextField input;
	@FXML
	private Button sendButton;
	@FXML
	private Button connectionButton;

	public void sendButtonAction() {
		send(userName.getText() + ":" + input.getText() + "\n");
		input.setText("");
		input.requestFocus();
	}

	public void inputAction() {
		send(userName.getText() + ":" + input.getText() + "\n");
		input.setText("");
		input.requestFocus();
	}

	public void connectionButtonAction() {
		if (connectionButton.getText().equals("접속하기")) {

			startClient(getIp(), getPort());
			Platform.runLater(() -> {
				textArea.appendText("채팅방 접속 \n");

			});
			connectionButton.setText("종료하기");
			input.setDisable(false);
			sendButton.setDisable(false);
			input.requestFocus();
		} else {
			stopClient();
			Platform.runLater(() -> {
				textArea.appendText("채팅방 퇴장 \n");

			});
			connectionButton.setText("접속하기");
			input.setDisable(true);
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

				if (user1.equals(who())) {
					return "host";
				} else if (user2.equals(who())) {
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

	// 게임 포트 번호 가져오기
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
		} catch (Exception e) {
			// TODO: handle exception
		}

		return port;
	}

	// 게임 아이피 번호 가져오기
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
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ip;
	}





	
	

}
