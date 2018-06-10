package chapter10;
import java.io.File;
import java.io.PrintStream;
public class _System {
	public static void main(String[] args){
		System.getProperties().list(System.out);
		File file = new File("attribute.txt");
		try{
			file.createNewFile();
			System.setOut(new PrintStream(file));
			System.getProperties().list(System.out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
