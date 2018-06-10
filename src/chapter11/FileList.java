package chapter11;
import java.io.File;
public class FileList {
	public static void main(String[] args){
		String dirName = "D:"+File.separator+"myjava";
		listAllDir(dirName);
	}
	public static void listAllDir(String dirName){
		File file = new File(dirName);
		if(file.isDirectory()){
			File f[] = file.listFiles();
			if(f != null){
				for(int i=0;i<f.length;i++)
					listAllDir(f[i].toString());
			}
		}
		else
			System.out.println(file);
	}
}
