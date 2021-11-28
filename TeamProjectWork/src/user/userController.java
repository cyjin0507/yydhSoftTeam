package user;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import util.JDBCUtil;

public class userController {
	public static MediaPlayer mp;
	Media m = null;

	// 사용자 일련번호 생성
	public String serialNum() {
		Random random = new Random();
		String strRand[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n" };
		String serialStr = strRand[random.nextInt(12) + 0] + strRand[random.nextInt(12) + 0]
				+ strRand[random.nextInt(12) + 0] + strRand[random.nextInt(12) + 0];
		int serialNum = random.nextInt(100000000) + 999999999;
		String serial = serialStr + String.valueOf(serialNum);
		return serial;
	}

	// 아이디 중복체크
	@FXML
	private Button idCheck;
	public static boolean whether = true;
	public static boolean whether2 = false;

	public void idCheck() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();

		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				if (id.equals(joinId.getText())) {
					whether = false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삽입 실패!");
		}

		if (whether == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("성공");
			alert.setHeaderText("아이디 사용 가능");
			alert.setContentText("이 아이디는 사용가능합니다.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("실패");
			alert.setHeaderText("아이디 사용 불가능");
			alert.setContentText("이 아이디는 사용 불가능합니다.");
			alert.showAndWait();
		}

		whether2 = true;

	}

	// 회원가입 칸이 비어있는지 확인
	public boolean blank() {
		if (joinId.equals("") || joinName.equals("") || joinNick.equals("") || joinPw.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public void test() {
		System.out.println("test");
	}

	@FXML
	private TextField joinName;
	@FXML
	private TextField joinId;
	@FXML
	private TextField joinPw;
	@FXML
	private TextField joinNick;
	@FXML
	private Button jojnOk;

	// 회원가입
	public void join() {

		if (whether2 == true || blank() == false) {

			JDBCUtil db = new JDBCUtil();
			java.sql.Connection con = db.getConnection();

			java.sql.PreparedStatement pstmt = null;

			String sql = "insert into users values(?,?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, joinId.getText());
				pstmt.setString(2, joinPw.getText());
				pstmt.setString(3, joinName.getText());
				pstmt.setString(4, joinNick.getText());
				pstmt.setString(5, "basic");
				pstmt.setString(6, serialNum());
				pstmt.setString(7, "offLine");
				pstmt.executeUpdate();

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("성공");
				alert.setHeaderText("회원가입 성공");
				alert.setContentText("회원가입이 성공적으로 완료되었습니다.");

				alert.showAndWait();

				try {
					Parent par = FXMLLoader.load(getClass().getResource("/user/Login.fxml"));
					Scene scene = new Scene(par);
					Stage primaryStage = (Stage) Login.getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("삽입 실패!");
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("주의");
			alert.setHeaderText("아이디 중복체크 미실행 및 비어있는칸");
			alert.setContentText("아이디 중복체크를 진행해주세요.");

			alert.showAndWait();
		}

	}

	/////////////////////// 로그인 부분
	@FXML
	private TextField dataId;
	@FXML
	private TextField dataPw;

	public void loginOk() {
		JDBCUtil db = new JDBCUtil();
		java.sql.Connection con = db.getConnection();
						
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("pw");

				if(id.equals(dataId.getText()) && password.equals(dataPw.getText())) {
					if(access()) {
						transOnline(dataId.getText());
						
						//로그인 성공시 화면 전환
						try {
							Parent par = FXMLLoader.load(getClass().getResource("/user/mainPage.fxml"));
							Scene scene = new Scene(par);
							Stage primaryStage = (Stage) Sing.getScene().getWindow();
							scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
							primaryStage.setScene(scene);
							mp = new MediaPlayer(new Media(getClass().getResource("/music/메인화면.mp3").toString()));
							Runnable onEnd = new Runnable() {
								@Override
								public void run() {
									mp.dispose();
									mp = new MediaPlayer(m);
									mp.play();
									mp.setOnEndOfMedia(this);
								}
							};
							mp.setOnEndOfMedia(onEnd);
							mp.play();
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("오류");
						alert.setHeaderText("동시접속자 발생!!!");
						alert.setContentText("한 기기에 두 게임을 실행할 수 업습니다.");
						alert.showAndWait();
					}
					
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	// 온라인 상태로 전환
	public void transOnline(String id) throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();

		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println(id);

		String sql = "UPDATE `users` SET `login`= '" + ip + "' WHERE id = '" + id + "'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 게임 두개 접속 못하게
	public Boolean access() {
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
		ResultSet rs = null;
		String sql = "select * from users";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String login = rs.getString("login");
				if (login.equals(ip)) {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	// 화면전환
	@FXML
	private Button Sing;
	@FXML
	private Button Login;

	public void change() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/Sing.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) Sing.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene2() {
		try {
			Parent par = FXMLLoader.load(getClass().getResource("/user/Login.fxml"));
			Scene scene = new Scene(par);
			Stage primaryStage = (Stage) Login.getScene().getWindow();
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
