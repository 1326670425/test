package chapter17;

import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UrlConnection {
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.baidu.com");
			URLConnection urlCon = url.openConnection();
			System.out.println("���ݴ�С��"+urlCon.getContentLength());
			System.out.println("�������ͣ�"+urlCon.getContentType());
			Map<String,List<String>>map = urlCon.getHeaderFields();//�����Դ�ļ���ͷ����Ϣ
			Set<String>keys = map.keySet();
			Iterator<String>iter = keys.iterator();
			while(iter.hasNext()){
				System.out.println("�ؼ��֣�"+iter.next());
				System.out.println("��Ӧ��ֵ��"+map.get(iter.next()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
