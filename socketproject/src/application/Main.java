package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Main extends Application {
	Socket socket;

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

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/layout.fxml"));
			AnchorPane root1;

			root1 = (AnchorPane) loader.load();

			Scene scene = new Scene(root1, 400, 400);
			primaryStage.setTitle("채팅 클라이언트");
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(event -> stopClient());
			primaryStage.show();

//			connectionButton.requestFocus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
			int port = 9876;
			try {
				port = Integer.parseInt(portText.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
			startClient(IPText.getText(), port);
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

//프로그램의 진입점
	public static void main(String[] args) {
		launch(args);
	}
}
