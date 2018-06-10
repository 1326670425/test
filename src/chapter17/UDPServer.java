package chapter17;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void serverInfo() throws Exception{
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		ds = new DatagramSocket(3000);
		String info = "UDP通信测试";
		System.out.println(info.length());
		dp = new DatagramPacket(info.getBytes(),info.length(),InetAddress.getByName("localhost"),8500);
		System.out.println(dp);
		System.out.println("服务器端发送信息");
		ds.send(dp);
		ds.close();
	}
	public static void main(String[] args) throws Exception{
		serverInfo();
	}
}
