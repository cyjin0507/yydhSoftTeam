package server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPClient{

    public static void main(String[] args) throws IOException {
        TCPClient cm = new TCPClient();
        cm.run();
    }

    void run() throws IOException {
        //소켓 생성
        Socket socket = new Socket();
        //서버쪽 주소 생성. ip는 localhost, 포트는 18501. 필요에 맞게 바꾸기 
        SocketAddress address = new InetSocketAddress("127.0.0.1", 18501);
        //주소에 해당하는 서버랑 연결
        socket.connect(address);
        
        try {
            //보내기
            send(socket);
            
            //받기
            receive(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void send(Socket socket) throws IOException {
        //Person 객체 생성. 인자로 3 넣어줌.
        Person person = new Person(3);

        //생성한 person 객체를 byte array로 변환
        byte[] data = toByteArray(person);
        //서버로 내보내기 위한 출력 스트림 뚫음
        OutputStream os = socket.getOutputStream();
        //출력 스트림에 데이터 씀
        os.write(data);
        //보냄
        os.flush();
    }
    
    public static void receive(Socket socket) throws IOException {
        //수신 버퍼의 최대 사이즈 지정
        int maxBufferSize = 1024;
        //버퍼 생성
        byte[] recvBuffer = new byte[maxBufferSize];
        //서버로부터 받기 위한 입력 스트림 뚫음
        InputStream is = socket.getInputStream();
        //버퍼(recvBuffer) 인자로 넣어서 받음. 반환 값은 받아온 size
        int nReadSize = is.read(recvBuffer);

        //받아온 값이 0보다 클때
        if (nReadSize > 0) {
            //받아온 byte를 Object로 변환 
            Person receivePerson = toObject(recvBuffer, Person.class);
            //확인을 위해 출력
            System.out.println(receivePerson.age);
        }
    }

    public static byte[] toByteArray (Object obj)
    {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            bos.close();
            bytes = bos.toByteArray();
        }
        catch (IOException ex) {
            //TODO: Handle the exception
        }
        return bytes;
    }

    public static <T> T toObject (byte[] bytes, Class<T> type)
    {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
        }
        catch (IOException ex) {
            //TODO: Handle the exception
        }
        catch (ClassNotFoundException ex) {
            //TODO: Handle the exception
        }
        return type.cast(obj);
    }
}

class Person implements Serializable {
    int age;

    Person(int age) {
        this.age= age;
    }
}