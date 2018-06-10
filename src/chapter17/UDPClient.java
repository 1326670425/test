package chapter17;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDPClient {
	public static void clientInfo() throws Exception{
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		byte[] bt = new byte[1024];
		ds = new DatagramSocket(8500);
		dp = new DatagramPacket(bt,bt.length);
		System.out.println("准备从服务器端接收数据：");
		ds.receive(dp);
		String info = new String(dp.getData(),0,dp.getLength())+"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
		System.out.println("服务器发送的数据是："+info);
		ds.close();
		
	}
	public static void main(String[] args) throws Exception{
		clientInfo();
	}
}
