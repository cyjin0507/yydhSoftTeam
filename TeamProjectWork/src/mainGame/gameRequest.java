package mainGame;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import user.mainPage;
import util.JDBCUtil;

public class gameRequest implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		listUp();
		listUp2();

	}

	// 친구 리스트 띄우기////////////////////////////////////

	@FXML
	private ListView<String> mainList;

	private ObservableList<String> detailList;

	public void listUp() {
		detailList = FXCollections.observableArrayList();
		mainList.setItems(detailList);
		friendCheck();
	}

	public void friendCheck() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from request";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sendUser = rs.getString("sendUserId");
				String receiveUser = rs.getString("receiveUserId");
				String state = rs.getString("state");
				int friendship = rs.getInt("friendship");
				if ((sendUser.equals(who()) || receiveUser.equals(who())) && state.equals("accept")) {
					if (sendUser.equals(who())) {
						if (!userNum(receiveUser).equals(null)) {
							detailList.add("친구이름 : " + receiveUser + "  친목도 : " + friendship + "점     ("
									+ userNum(receiveUser) + ")");
						}
					} else if (receiveUser.equals(who())) {
						if (!userNum(sendUser).equals(null)) {
							detailList.add("친구이름 : " + sendUser + "  친목도 : " + friendship + "점     ("
									+ userNum(sendUser) + ")");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 그 유저가 온라인인지, 일련번호 출력 (오프라인 아닐때로 변경해야 됨 !, login.equals("offLine") && 이거 집어너 102번째 줄에다가)
	public String userNum(String userName) {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("nickname");
				String serial = rs.getString("serial_number");
				String login = rs.getString("login");
				if (name.equals(userName)) {
					return serial;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public static boolean player = false;

	// 게임요청 보내기
	public void send() {
		player = true;
		gameReady rd = new gameReady();
		int idx = mainList.getSelectionModel().getSelectedIndex();
		String friendNum = null;
		if (idx >= 0) {
			friendNum = detailList.get(idx).substring(detailList.get(idx).length() - 15,
					detailList.get(idx).length() - 1);

			insertRequest(friendNum);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림");
			alert.setHeaderText("선택한 친구에게 게임 요청을 보냈습니다.");
			alert.setContentText("게임 대기장으로 이동합니다.");
			alert.showAndWait();


			try {
				Parent par = FXMLLoader.load(getClass().getResource("/mainGame/ready.fxml"));
				Scene scene = new Scene(par);
				Stage primaryStage = (Stage) mainList.getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("알림");
			alert.setHeaderText("친구 미선택");
			alert.setContentText("게임을 같이 할 친구를 선택해주세요.");
			alert.showAndWait();
		}

	}

	// 게임요청 데베에 집어넣기
	public void insertRequest(String serial) {

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

		String sql = "insert into game_ready values(?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, serialNum());
			pstmt.setString(2, who());
			pstmt.setString(3, whatUser(serial));
			pstmt.setString(4, time());
			pstmt.setString(5, "waitting");

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 시리얼 번호를 주면 그 유저가 어떤 유저인지 출력
	public String whatUser(String serial) {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("nickname");
				String num = rs.getString("serial_number");
				if (num.equals(serial)) {
					return name;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	// 시간 출력 함수
	public String time() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();

		String date = format1.format(time);

		return date;
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

	//////////////////////////////////////

	@FXML
	private ListView<String> subList;

	private ObservableList<String> detailList2;

	public void listUp2() {
		detailList2 = FXCollections.observableArrayList();
		subList.setItems(detailList2);
		getAsk();
	}

	public void getAsk() {
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
				String time = rs.getString("time");
				String state = rs.getString("state");
				String id = rs.getString("id");
				if (receiveUser.equals(who()) && state.equals("waitting")) {
					detailList2.add("보낸사람 : " + sendUser + "   보낸일시 : " + time + "      (" + id + ")");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 거절
	public void refusal() {

		int idx = subList.getSelectionModel().getSelectedIndex();
		String id = null;
		if (idx >= 0) {
			id = detailList2.get(idx).substring(detailList2.get(idx).length() - 7, detailList2.get(idx).length() - 1);
		}


		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		PreparedStatement pstmt = null;

		String sql = "DELETE FROM game_ready WHERE id = '" + id + "'";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알림");
		alert.setHeaderText("요청 거절 성공");
		alert.setContentText("성공적으로 요청이 거절되었습니다.");
		alert.showAndWait();

		listUp2();

	}
	
	
	//게임요청 수락
	@FXML
	private Button acceptBtn;
	
	public void accept() {
		
		int idx = subList.getSelectionModel().getSelectedIndex();
		String id = null;
		if (idx >= 0) {
			id = detailList2.get(idx).substring(detailList2.get(idx).length() - 7, detailList2.get(idx).length() - 1);
		}
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM game_ready WHERE id = '" + id + "'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/mainGame/ready.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) acceptBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			user2Info();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	

	///////////////////////////
	// 새로고침
	private Button resetBtn;

	public void reset() {
		listUp();
		listUp2();
	}

	// 전화면으로
	@FXML
	private Button backBtn;

	public void back() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) backBtn.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 요청 일련번호 생성
	public String serialNum() {
		Random random = new Random();
		String strRand[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n" };
		String serialStr = strRand[random.nextInt(12) + 0] + strRand[random.nextInt(12) + 0];
		int serialNum = random.nextInt(100) + 999;
		String serial = serialStr + String.valueOf(serialNum);
		return serial;
	}
	
	
	
	// 게임 준비 화면에 초대코드 보내주기
	public String code() {
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
				String code = rs.getString("id");
				if(sendUser.equals(who())) {
					return code;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	//수락버튼 눌렀을때 데베 집어넣기
	public void user2Info() throws UnknownHostException {
		
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		int idx = subList.getSelectionModel().getSelectedIndex();

		if (idx >= 0) {
			String id = detailList2.get(idx).substring(detailList2.get(idx).length() - 7, detailList2.get(idx).length() - 1);

			String sql = "UPDATE `game_info` SET `user2`=  '" + who() + "' WHERE `game_room` = '" + id + "'";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
	
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

	}
	
	

}
