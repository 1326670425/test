package chapter11;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Input {
	public static void main(String[] args){
		String fileName = "D:"+File.separator+"record.txt";
		File file = new File(fileName);
		InputStream is = null;
		try{
			is = new FileInputStream(file);
			byte b[] = new byte[(int)file.length()];
			
			for(int i=0;i<b.length;i++)//逐个字节读取
				b[i] = (byte)is.read();
			
			//is.read(b);//一次读取所有数据
			
			is.close();
			System.out.println(new String(b));
/*			//逐个输出字节，如果有汉字将出现异常
			 for(int i=0;i<b.length;i++)
			 	System.out.println(b[i]);
			 */
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
