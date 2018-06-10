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
			System.out.println("服务器正在等待客户端连接");
			client = server.accept();
			String info = "简单TCP通信测试";
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
