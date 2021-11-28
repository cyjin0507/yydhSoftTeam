package user;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import javax.sound.sampled.DataLine;

import com.sun.glass.events.WindowEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.JDBCUtil;

public class FrirendPlusController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		listAction();
		listAction2();
		try {
			userName.setText(who());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset() {
		listAction();
		listAction2();
	}
	
	

	// 친구 추가/////////////////////////////////////////////

	@FXML
	private Button findBtn;
	@FXML
	private TextField findName;

	public void findUser() {
		listAction();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("친구찾기");
		alert.setHeaderText(findName.getText() + "님에게 친구요청을 하시겠습니까?");
		alert.setContentText("OK 버튼 클릭 시 친구요청이 보내집니다.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			if (userCheck(findName.getText())) {
				if (past()) {
					request();

					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("요청성공");
					alert2.setHeaderText("친구요청이 성공적으로 완료되었습니다.");
					alert2.setContentText("친구가 요청을 받을 때까지 기다리세요.");
					alert2.showAndWait();

					listAction();
				} else {
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("요청실패");
					alert2.setHeaderText("이미 친구이거나 친구요청을 한 상태입니다.");
					alert2.setContentText("친구리스트를 확인해주세요.");
					alert2.showAndWait();
				}

			} else {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("요청실패");
				alert2.setHeaderText("입력한 친구가 없습니다");
				alert2.setContentText("정확한 친구의 닉네임을 입력해주세요.");
				alert2.showAndWait();
			}
		} else if (result.get() == ButtonType.CANCEL) {
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("취소");
			alert2.setHeaderText("친구요청이 취소되었습니다.");
			alert2.setContentText("친구요청을 원할시 다시 요청해주세요.");
			alert2.showAndWait();
		}

	}

	// 그 유저가 있는지 확인
	public boolean userCheck(String nickname) {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String nick = rs.getString("nickname");
				if (nickname.equals(nick) && !findName.getText().equals(who())) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	// 과거에 요청을 보냈거나 친구사이인지 확인
	public boolean past() {
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
				if ((sendUser.equals(who()) && receiveUser.equals(findName.getText()))
						|| (sendUser.equals(findName.getText()) && receiveUser.equals(who()))) {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	// 요청을 데베에 집어넣기
	public void request() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;

		String sql = "insert into request values(?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, serialNum());
			pstmt.setString(2, who());
			pstmt.setString(3, findName.getText());
			pstmt.setInt(4, 0);
			pstmt.setString(5, "waiting");
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 요청된 것 리스트업
	@FXML
	private ListView<String> askList;

	private ObservableList<String> detailList1;

	public void listAction() {
		detailList1 = FXCollections.observableArrayList();
		askList.setItems(detailList1);
		askList();
	}

	public void askList() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM `request`";

		try {

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String dataid = rs.getString("id");
				String dataSendUserId = rs.getString("sendUserId");
				String dataReceiveUserId = rs.getString("receiveUserId");
				String dataState = rs.getString("state");

				if (dataSendUserId.equals(who())) {
					detailList1.add(
							" 보낸 이 : " + dataSendUserId + " | 받는 이 : " + dataReceiveUserId + " | 수락상태 : " + dataState);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 요청 온 것 리스트업
	@FXML
	private ListView<String> getList;

	private ObservableList<String> detailList2;

	public void listAction2() {
		detailList2 = FXCollections.observableArrayList();
		getList.setItems(detailList2);
		getList();
	}

	public void getList() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM `request`";

		try {

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String dataid = rs.getString("id");
				String dataSendUserId = rs.getString("sendUserId");
				String dataReceiveUserId = rs.getString("receiveUserId");
				String dataState = rs.getString("state");

				if (dataReceiveUserId.equals(who()) && dataState.equals("waiting")) {
					detailList2.add(" 보낸이 : " + dataSendUserId + "  수락상태 : " + dataState + "   친구요청번호(" + dataid + ")");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 수락하기
	public void showAccept() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("친구추가");
		alert.setHeaderText("친구요청을 수락하시겠습니까?");
		alert.setContentText("OK버튼 클릭시 요청을 수락합니다.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			int idx = getList.getSelectionModel().getSelectedIndex();
			if (idx >= 0) {
				String askId = detailList2.get(idx).substring(detailList2.get(idx).length() - 7,
						detailList2.get(idx).length() - 1);
				JDBCUtil db = new JDBCUtil();
				Connection con = db.getConnection();
				PreparedStatement pstmt = null;

				String sql = "UPDATE `request` SET `state`=  'accept' WHERE `id` = '" + askId + "'";

				try {
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				}
				listAction2();
			}

			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("수락성공");
			alert2.setHeaderText("친구수락 성공");
			alert2.setContentText("친구 수락이 성공적으로 완료되었습니다.");
			alert2.showAndWait();

		} else if (result.get() == ButtonType.CANCEL) {
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("수락거절");
			alert2.setHeaderText("친구수락 취소");
			alert2.setContentText("친구 수락을 취소했습니다.");
			alert2.showAndWait();
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

	// 화면이동////////////////////////////////////////////////////////
	@FXML
	private Label userName;

	public void goInfo() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/myInfo.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) userName.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private Button goMain;

	public void goMain() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) goMain.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
