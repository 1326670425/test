package chapter17;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class TCPServer1 {
	public static void serverInfo(){
		ServerSocket server = null;
		Socket client = null;
		PrintStream out = null;
		try{
			server = new ServerSocket(8000);
			System.out.println("���������ڵȴ��ͻ�������");
			client = server.accept();
			String info = "��TCPͨ�Ų���";
			out = new PrintStream(client.getOutputStream());
			out.print(info);
			out.close();
			client.close();
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		serverInfo();
	}
}
