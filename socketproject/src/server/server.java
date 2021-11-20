package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import server.Client;

public class server extends Application {

	public static ExecutorService threadPool;
	// 여러가지 쓰레드를 효율적으로 관리하는 라이브러리 (갑작스런 클라이언트가
	// 들어와도 쓰레드는 한정적이기에 안정적으로 서버 운영)
	public static Vector<Client> clients = new Vector<Client>();
	// 쉽게 사용할 수 있는 배열의 일종
	ServerSocket serverSocket;

//서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
			// 서버컴퓨터가 기다리게 만듬

		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer();

			}
			return;
		}
		// 클라이언트가 접속할떄까지 기다리는 쓰레드
		Runnable thread = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Socket socket = serverSocket.accept();
						clients.add(new Client(socket));
						// 클라이언트 배열에 새로운 접속자 추가
						System.out.println(
								"클라이언트 접속" + socket.getRemoteSocketAddress() + ":" + Thread.currentThread().getName());

					} catch (Exception e) {
						if (!serverSocket.isClosed()) {
							stopServer();

						}
						break;
					}
				}

			}
		};
		threadPool = Executors.newCachedThreadPool();// 쓰레드풀 초기화
		threadPool.submit(thread);// 담기
	}

//서버의 작동을 중지시키는 메소드
	public void stopServer() {
		try {
			// 현재 작동 중인 모든 소켓 중지
			Iterator<Client> iterator = clients.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// 서버소켓 닫기
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			if (threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//UI를 생성하고 실질적으로 프로그램을 동작시키는 메소드
	@Override
	public void start(Stage primaryStage) {
		String IP = "127.0.0.1";
		int port = 9876;
		System.out.println("실행");
		startServer(IP, port);
		//종료 메소드
		//stopServer();
	}


//프로그램의 진입점
	public static void main(String[] args) {
		launch(args);
	}
}
