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
			System.out.println("���ؼ�������ƣ�"+locName+"�����ؼ����IP��ַ��"+locIP);
			System.out.println("Զ�̼�������ƣ�"+remName+"��Զ�̼����IP��ַ��"+remIP);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
