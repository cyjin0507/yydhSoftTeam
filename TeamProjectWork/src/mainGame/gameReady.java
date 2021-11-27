package mainGame;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.JDBCUtil;

public class gameReady extends gameRequest implements Initializable {
	@FXML
	private Button player1Btn;
	@FXML
	private Button player2Btn;

	@FXML
	private Label user1_name;
	@FXML
	private Label user2_name;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gameRequest rq = new gameRequest();
		System.out.println(rq.player);
		if (rq.player) {
			player1Btn.setVisible(true);

			try {
				user1_name.setText(who());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("유저이름 오류");
			}
			makeTable();
		} else {
			player2Btn.setVisible(true);

			try {
				user1_name.setText(who());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("유저이름 오류");
			}
		}

		// 채팅창 띄우기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainGame/chat.fxml"));
		Parent root = null;
		try {
			root = (Parent) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("채팅 오류");
		}
		Stage stage = new Stage();
		stage.setTitle("상대와 채팅");
		stage.setScene(new Scene(root));
		stage.show();

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent evt) {
				if (new Main().close) {
					stage.close();
				} else {
					evt.consume();
				}

			}
		});

	}

	// 게임요청 번호 받아오기
	public void invitationCode() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_ready";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String gameCode = rs.getString("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 기본 데이터베이스 생성 (유저1)
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

		String sql = "insert into game_info values(?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, serialNum());
			pstmt.setString(2, who());
			pstmt.setString(3, whastuser());
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			pstmt.setString(6, ip);
			pstmt.setInt(7, randPort());
			pstmt.setString(8, "waitting");
			pstmt.setString(9, "waitting");
			pstmt.setString(10, code());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 누구에게 보냈는지 확인
	public String whastuser() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game_ready";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sendUser = rs.getString("sendUser");
				String receiveUser = rs.getString("receiveUser");
				if (sendUser.equals(who())) {
					return receiveUser;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	// 유저1 준비버튼
	public void ready1() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE `game_info` SET `ready1` = 'accept' WHERE `user1` = '" + who() + "'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 유저2 준비버튼
	public void ready2() throws UnknownHostException {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE `game_info` SET `ready2` = 'accept' WHERE `user2` = '" + who() + "'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	private Button startBtn;

	// 시작 버튼 눌렀을때
	public void gameStart() throws UnknownHostException {

		System.out.println("함수는 돈다");
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
				String ready1 = rs.getString("ready1");
				String ready2 = rs.getString("ready2");

				// 모두가 준비가 된 상태
				if (ready1.equals("accept") && ready2.equals("accept")) {

					Parent par = FXMLLoader.load(getClass().getResource("/floor2room/study.fxml"));
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) startBtn.getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

				} else if (user1.equals(who()) && ready1.equals("accept") && ready2.equals("waitting")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("게임 시작 불가");
					alert.setHeaderText("상대방 준비 X");
					alert.setContentText("상대방이 준비할때 까지 기다리세요.");
					alert.showAndWait();
				} else if (user1.equals(who()) && ready1.equals("waitting")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("게임 시작 불가");
					alert.setHeaderText("준비버튼을 클릭하세요");
					alert.setContentText("준비버튼을 눌러야 게임을 시작할 수 있습니다.");
					alert.showAndWait();
				} else if (user2.equals(who()) && ready2.equals("accept") && ready1.equals("waitting")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("게임 시작 불가");
					alert.setHeaderText("상대방 준비 X");
					alert.setContentText("상대방이 준비할때 까지 기다리세요.");
					alert.showAndWait();
				} else if (user2.equals(who()) && ready2.equals("waitting")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("게임 시작 불가");
					alert.setHeaderText("준비버튼을 클릭하세요");
					alert.setContentText("준비버튼을 눌러야 게임을 시작할 수 있습니다.");
					alert.showAndWait();
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
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

	// 랜덤 포트 번호 생성
	public int randPort() {

		int port = (int) (Math.random() * 9999 + 1000);

		return port;
	}

	public void reset() {

	}

}
