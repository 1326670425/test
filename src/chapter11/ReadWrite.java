package chapter11;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.*;

public class ReadWrite {
	public static void main(String[] args){
/*		char[] buff = new char[] {'g','o','o','d','你','好'};
		CharArrayReader cr = new CharArrayReader(buff);
		CharArrayWriter cw = new CharArrayWriter();
		int temp;
		try{
			while((temp = cr.read()) != -1)
				cw.write(Character.toUpperCase(temp));
			
			cr.close();
			cw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(cw.toCharArray());*/
		String fileName = "F:\\printwriter.txt";
		File file = new File(fileName);
		try{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			String temp = null;
			System.out.println("开始输入数据，输入stop停止");
			while(flag){
				temp = br.readLine();
				if("stop".equals(temp))
					flag = false;
				else
					pw.println(temp);
			}
			pw.flush();
			pw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
