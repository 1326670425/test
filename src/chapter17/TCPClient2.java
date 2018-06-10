package chapter17;

import java.io.*;
import java.net.*;

public class TCPClient2 {
	public static void clientInfo() throws Exception{
		Socket client = null;
		client = new Socket("localhost",8000);
		BufferedReader buf = null;
		PrintStream out = null;
		BufferedReader input = null;
		input = new BufferedReader(new InputStreamReader(System.in));//ʵ�����Ӽ��̽��յ�������
		buf = new BufferedReader(new InputStreamReader(client.getInputStream()));//ʵ�����Ӷ˿ڽ��յ�������
		out = new PrintStream(client.getOutputStream());
		boolean flag = true;
		while(flag){
			System.out.print("�ͻ���������Ϣ��");
			String info = input.readLine();
			out.println(info);
			if("bye".equalsIgnoreCase(info))
				flag = false;
			else{
				String echo = buf.readLine();
				System.out.println(echo);
			}
		}
		client.close();
		input.close();
		out.close();
		buf.close();
	}
	public static void main(String[] args) throws Exception{
		clientInfo();
	}
}
