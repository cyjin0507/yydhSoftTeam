package server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends TCPClient {
	
	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				try {
					server();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					client();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	}

    public static void server() throws IOException{
        TCPServer socketServer = new TCPServer();
        socketServer.run();
    }

    public void run() throws IOException{
        try {
            int port = 18501;
            ServerSocket server = new ServerSocket(port);

            while(true){
                System.out.println("-------접속 대기중------");
                Socket socket = server.accept();         // 계속 기다리고 있다가 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
                while(true) {
                	InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[1024];

                    int readByteCount = is.read(bytes);

                    if (readByteCount > 0) {
                        System.out.println("클라이언트로 부터 데이터 수신");
                        sendData(bytes, socket);
                    }
                    System.out.println("****** 재전송 완료 ****");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(byte[] bytes, Socket socket){
        try {
            OutputStream os = socket.getOutputStream();
            os.write(bytes);
            os.flush();
        } catch(Exception e1){
            e1.printStackTrace();
        }
    }
}