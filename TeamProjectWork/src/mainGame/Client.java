package mainGame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.stream.FileImageInputStream;

public class Client {

	Socket socket;
	
	

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
//클라이언트로부터 메시지를 전달받는 메소드
	public void receive() {
		Runnable thread = new Runnable() {
			//내부적으로 반드시 run 가지고 있음 하나의 쓰레드가 어떤한 
			//모듈로써 정의를 할껀지 런에서 정함
			

			
			@Override
			public void run() {
				try {
					while (true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						while (length == -1)
							throw new IOException();
						System.out.println(
								"메시지 수신 성공" + socket.getRemoteSocketAddress() //ip주소 와 같은 주소 출력
								+ ":" + Thread.currentThread().getName()); //쓰레드의 고유의 정보(이름) 값 출력
						
						String message = new String(buffer, 0, length, "UTF-8"); //버퍼에서 받은값을 한글(UTF-8)로 저장
						for (Client client : server.clients) {
							//클라이언트가 쓴글을 다른 클라이언트도 받을 수있게
							client.send(message);
						}

					}
				} catch (Exception e) {
					try {
						System.out.println(
								"메세지 수신오류" + socket.getRemoteSocketAddress() + ":" + Thread.currentThread().getName());

					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
			}
		};//쓰레드 풀에 쓰레드 장착
		server.threadPool.submit(thread);

	}
//클라이언크로부터 메세지 전송하는 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();

				} catch (Exception e) {
					try {
						System.out.println(
								"메세지 수신오류" + socket.getRemoteSocketAddress() + ":" + Thread.currentThread().getName());
						server.clients.remove(Client.this);
						// 연결이 끊겼을때 서버에서도 연결을 끊는것
						socket.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					

				}
			}
		};
		server.threadPool.submit(thread);
	}
}
