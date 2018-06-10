package chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient1 {
	public static void clientInfo(){
		Socket client = null;
		try{
			client = new Socket("localhost",8000);
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String info = buf.readLine();
			System.out.println("服务器发送的信息："+info);
			client.close();
			buf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		clientInfo();
	}
}
