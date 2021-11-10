package gameStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class server {

	static HashMap<String, Object> hash;

	public static void server() {

		try {
			// 소켓 번호는 임시로 1525
			ServerSocket server = new ServerSocket(122);
			hash = new HashMap<String, Object>();
			// hash맵 키값불러와서 각 방마다 몇명인지 구하기

			while (true) {
				System.out.println("=======================");
				System.out.println("현재 서버에   " + hash.size() + "명...");
				// hash맵 개수 구하기

				System.out.println("접속을 기다리는중...");
				Socket sck = server.accept();
				// 클라이언트가 새로들어올때마다 chatThr스레드 한개 실행 각각은 독립적으로 실행
				ChatThread chatThr = new ChatThread(sck, hash);
				chatThr.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ChatThread extends Thread {
	Socket sck;
	String[] split;
	String code;
	BufferedReader br;
	// 들어온 클라이언트의 Printwriter객체와 code를 저장하고 관리해주는 해쉬맵
	HashMap<String, Object> hash;
	boolean initFlag = false;

	public ChatThread(Socket sck, HashMap<String, Object> hash) {

		this.sck = sck;
		this.hash = hash;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sck.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
			// 123a는 123b랑만 채팅이 가능
			pw.println("Please press your code number(123a, 123p, 456a, 456p)");
			pw.flush();
			System.out.println("코드보내기");
			code = br.readLine();
			System.out.println("====" + code + "님과 성공적으로 연결====");
			// 직렬화 후 해쉬맵에 저장
			synchronized (hash) {
				hash.put(code, pw);
			}
			initFlag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String line = null;
		try {
			while ((line = br.readLine()) != null) {// 클라이언트로부터 quit을 받으면 종료
				if (line.split("/")[0].equals("quit")) {
					System.out.println(code + "님이 시스탬을 종료합니다...");
					break;

				} else {// 아닐 경우 계속 읽어온 데이터를 클라이언트들에게 전송
					sendMsg(line);
				}
			}
		} catch (IOException e) {
			System.out.println(code + "님이 시스탬을 강제적으로 종료합니다...");
		} finally {
			synchronized (hash) {
				hash.remove(code);
			}
			System.out.println("=======================");
			System.out.println("현재 서버에   " + hash.size() + "명...");
			System.out.println("=======================");

			try {
				sck.close();
			} catch (IOException e) {
				System.out.println("socket이 정상적으로 종료되지 않았습니다.");
			}
		}
	}

	// 1:1 전송 (코드가 123a이면 123p에게만 1:1로 전송해주는 방식)
	public void sendMsg(String msg) {
		synchronized (hash) {
			PrintWriter pw = null;
			// code가 a로 끝나면 안드로이드이므로 pc에게 메시지
			if (msg.split("/")[0].endsWith("a")) {// split함수와 replace함수를 이용해 간편하게 수신받을 클라이언트 printwriter객체를 설정
				pw = (PrintWriter) hash.get(msg.split("/")[0].replace("a", "p"));
				pw.println(msg.split("/")[1]);
				pw.flush();
			} else if (msg.split("/")[0].endsWith("p"))// 메시지 보낸 주체가 pc인 경우
			{
				pw = (PrintWriter) hash.get(msg.split("/")[0].replace("p", "a"));
				pw.println(msg.split("/")[1]);
				pw.flush();
			} else// 잘못된 코드
			{
				pw = (PrintWriter) hash.get(msg.split("/")[0]);
				pw.println("연결된 코드가 잘못된 코드입니다.");
				pw.flush();
			}
		}

	}

}
