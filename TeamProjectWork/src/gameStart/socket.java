package gameStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import gameStart.ChatThread;
import gameStart.InputThread;

public class socket {

	/////////////////////////////////////////////////////////// ������

	static HashMap<String, Object> hash;

	public static void server() {

		try {
			// ���� ��ȣ�� �ӽ÷� 1525
			ServerSocket server = new ServerSocket(122);
			hash = new HashMap<String, Object>();
			// hash�� Ű���ҷ��ͼ� �� �渶�� ������� ���ϱ�

			while (true) {
				System.out.println("=======================");
				System.out.println("���� ������   " + hash.size() + "��...");
				// hash�� ���� ���ϱ�

				System.out.println("������ ��ٸ�����...");
				Socket sck = server.accept();
				// Ŭ���̾�Ʈ�� ���ε��ö����� chatThr������ �Ѱ� ���� ������ ���������� ����
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
	// ���� Ŭ���̾�Ʈ�� Printwriter��ü�� code�� �����ϰ� �������ִ� �ؽ���
	HashMap<String, Object> hash;
	boolean initFlag = false;

	public ChatThread(Socket sck, HashMap<String, Object> hash) {

		this.sck = sck;
		this.hash = hash;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sck.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
			// 123a�� 123b���� ä���� ����
			pw.println("Please press your code number(123a, 123p, 456a, 456p)");
			pw.flush();
			System.out.println("�ڵ庸����");
			code = br.readLine();
			System.out.println("====" + code + "�԰� ���������� ����====");
			// ����ȭ �� �ؽ��ʿ� ����
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
			while ((line = br.readLine()) != null) {// Ŭ���̾�Ʈ�κ��� quit�� ������ ����
				if (line.split("/")[0].equals("quit")) {
					System.out.println(code + "���� �ý����� �����մϴ�...");
					break;

				} else {// �ƴ� ��� ��� �о�� �����͸� Ŭ���̾�Ʈ�鿡�� ����
					sendMsg(line);
				}
			}
		} catch (IOException e) {
			System.out.println(code + "���� �ý����� ���������� �����մϴ�...");
		} finally {
			synchronized (hash) {
				hash.remove(code);
			}
			System.out.println("=======================");
			System.out.println("���� ������   " + hash.size() + "��...");
			System.out.println("=======================");

			try {
				sck.close();
			} catch (IOException e) {
				System.out.println("socket�� ���������� ������� �ʾҽ��ϴ�.");
			}
		}
	}

	// 1:1 ���� (�ڵ尡 123a�̸� 123p���Ը� 1:1�� �������ִ� ���)
	public void sendMsg(String msg) {
		synchronized (hash) {
			PrintWriter pw = null;
			// code�� a�� ������ �ȵ���̵��̹Ƿ� pc���� �޽���
			if (msg.split("/")[0].endsWith("a")) {// split�Լ��� replace�Լ��� �̿��� �����ϰ� ���Ź��� Ŭ���̾�Ʈ printwriter��ü�� ����
				pw = (PrintWriter) hash.get(msg.split("/")[0].replace("a", "p"));
				pw.println(msg.split("/")[1]);
				pw.flush();
			} else if (msg.split("/")[0].endsWith("p"))// �޽��� ���� ��ü�� pc�� ���
			{
				pw = (PrintWriter) hash.get(msg.split("/")[0].replace("p", "a"));
				pw.println(msg.split("/")[1]);
				pw.flush();
			} else// �߸��� �ڵ�
			{
				pw = (PrintWriter) hash.get(msg.split("/")[0]);
				pw.println("����� �ڵ尡 �߸��� �ڵ��Դϴ�.");
				pw.flush();
			}
		}

	}
	
	///////////////////////Ŭ���̾�Ʈ �κ�
	public static void client() {
		Socket sck = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endFlag = false;
		String id = null;
		String code = null;
		try {
			// ������ ��Ĺ��ȣ �Է�
			sck = new Socket("localhost", 122);
			pw = new PrintWriter(new OutputStreamWriter(sck.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// code��� �о����-�������� (123a,123b,456a,456p)�� ���⸦ �ش�. Ŭ���̾�Ʈ�� ���⼭ ����
			// 123, 456�� ������ ���ȣ
			System.out.println("�ڵ��о����");
			String str = br.readLine();
			System.out.println(str);
			// ���ȣ �Է¹ޱ�
			code = keyboard.readLine();
			pw.println(code);// code ��Ʈ���� ��ƺ�����
			pw.flush();
			System.out.println("===========" + code + "���� ��ȭâ=========");
			// ������ ���� ��� �о���� ������ ����
			InputThread it = new InputThread(sck, br);
			it.start();
			String line = null;
			while ((line = keyboard.readLine()) != null) {
				pw.println(code + "/" + line);
				pw.flush();
				if (line.equals("quit")) {
					System.out.println("�ý����� �����մϴ�.");
					endFlag = true;
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (sck != null)
					sck.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

class InputThread extends Thread {
	Socket sck = null;
	BufferedReader br = null;

	public InputThread(Socket sck, BufferedReader br) {
		this.sck = sck;
		this.br = br;
	}

	public void run()// ������� �����κ��� ��� �о����
	{
		try {
			String line = null;
			// null���� �ƴϸ� ��� �о�� ������ֱ�
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("�ý����� �����մϴ�.");
		} finally {
			try {
				if (sck != null)
					sck.close();
				if (br != null)
					br.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
}
