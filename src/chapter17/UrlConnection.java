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
			System.out.println("内容大小："+urlCon.getContentLength());
			System.out.println("内容类型："+urlCon.getContentType());
			Map<String,List<String>>map = urlCon.getHeaderFields();//获得资源文件的头部信息
			Set<String>keys = map.keySet();
			Iterator<String>iter = keys.iterator();
			while(iter.hasNext()){
				System.out.println("关键字："+iter.next());
				System.out.println("对应的值："+map.get(iter.next()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
