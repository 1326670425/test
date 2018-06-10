package chapter17;

import java.net.*;
import java.io.*;

public class TCPServer2 {
	public static void serverInfo() throws Exception{
		ServerSocket server = null;
		Socket client = null;
		BufferedReader buf = null;
		PrintStream out = null;
		server = new ServerSocket(8000);
		boolean flag = true;
		while(flag){
			System.out.println("服务器正在运行，等待客户端连接");
			client = server.accept();
			out = new PrintStream(client.getOutputStream());//实例化输出流
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flagInfo = true;
			while(flagInfo){
				String info = buf.readLine();
				if(info == null || "".equals(info))
					flag = false;
				else{
					if("bye".equalsIgnoreCase(info)){
						flag = false;
					}
					else{
						out.println("服务器发送的信息(ECHO)："+info);
					}
				}
			}
			client.close();
		}
		server.close();
	}
	public static void main(String[] args) throws Exception{
		serverInfo();
	}
}
