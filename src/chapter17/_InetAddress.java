package chapter17;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _InetAddress {
	public static void main(String[] args){
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		String locIP;
		String remIP;
		String locName;
		String remName;
		try{
			locAdd = InetAddress.getLocalHost();
			remAdd = InetAddress.getByName("www.baidu.com");
			locIP = locAdd.getHostAddress();
			locName = locAdd.getHostName();
			remIP = remAdd.getHostAddress();
			remName = remAdd.getHostName();
			System.out.println("本地计算机名称："+locName+"，本地计算机IP地址："+locIP);
			System.out.println("远程计算机名称："+remName+"，远程计算机IP地址："+remIP);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
