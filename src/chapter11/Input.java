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
			
			for(int i=0;i<b.length;i++)//����ֽڶ�ȡ
				b[i] = (byte)is.read();
			
			//is.read(b);//һ�ζ�ȡ��������
			
			is.close();
			System.out.println(new String(b));
/*			//�������ֽڣ�����к��ֽ������쳣
			 for(int i=0;i<b.length;i++)
			 	System.out.println(b[i]);
			 */
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
