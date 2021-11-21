package application;
	
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.JDBCUtil;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public boolean close = false;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(getClass().getResource("/user/Login.fxml"));
//			loader.setLocation(getClass().getResource("/gameStart/mainHoll.fxml"));
			loader.setLocation(getClass().getResource("/gameStart/3floor.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent evt) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("프로그램 종료");
					alert.setHeaderText("잠깐! 서버를 종료하시겠습니까?");
					alert.setContentText("OK 버튼 클릭 시 서버가 종료됩니다.");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						System.out.println("종료");
						close = true;
						try {
							transOffLine();
						} catch (UnknownHostException e) {
							e.printStackTrace();
						}
					} else if (result.get() == ButtonType.CANCEL) {
						System.out.println("종료 취소");
						evt.consume();
					}
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//오프라인으로 변경
	public void transOffLine() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE `users` SET `login`= 'offLine' WHERE login = '"+ip+"'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
