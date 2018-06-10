package chapter11;
import java.io.*;
public class FileCopy {
	public static void main(String[] args){
		String srcFile = "D:"+File.separator+"record.txt";
		String desFile = "F:"+File.separator+"record-copy.txt";
		if(copyFile(srcFile,desFile))
			System.out.println("���Ƴɹ�");
		else
			System.out.println("����ʧ��");
	}
	public static boolean copyFile(String src,String des){
		File srcF = new File(src);
		File desF = new File(des);
		if(!srcF.exists()){
			System.out.println("Դ�ļ�������");
			return false;
		}
		InputStream is = null;
		OutputStream os = null;
		try{
			is = new FileInputStream(srcF);
			os = new FileOutputStream(desF);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		if(is != null && os != null){
			int temp = 0;
			try{
				while((temp=is.read()) != -1)
					os.write(temp);
				
				is.close();
				os.close();
				return true;
			}catch(IOException e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
