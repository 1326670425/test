package chapter10;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Regex {
	public static void main(String[] args){
		
/*		String id = JOptionPane.showInputDialog("身份证号码");
		String pat = "[0-9]{6}[1|2][0-9]{3}[0-1][0-9][0-3][0-9][0-9]{3}([0-9]|X|x)";
		Pattern  pattern = Pattern.compile(pat);
		Matcher m = pattern.matcher(id);
		boolean flag = m.matches();
		if(flag)
			System.out.println(id+"是一个合法的身份证号码");
		else
			System.out.println(id+"不是一个合法的身份证号码");*/
		
		String str = "字213符34324串123替423换";
		String pat = "\\d+";
		Pattern pattern = Pattern.compile(pat);
		Matcher m = pattern.matcher(str);
		String newStr = m.replaceAll("-");
		System.out.println("原字符串\t"+str);
		System.out.println("替换后的字符串\t"+newStr);
		
	}
}
