package chapter17;

import java.net.URL;
import java.io.*;

public class Url {
	public static void main(String[] args){
		URL aURL = null;
		String strURL = "http://www.baidu.com/";
		String strFile = "file:///F:/printwriter.txt";
		String str;
		InputStream is = null;
		try{
			aURL = new URL(strURL);
			//aURL = new URL(strFile);
			System.out.println("Protocol:"+aURL.getProtocol());
			System.out.println("Host:"+aURL.getHost());
			System.out.println("Port:"+aURL.getPort());
			System.out.println("File:"+aURL.getFile());
			is = aURL.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
