package chapter10;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Regex {
	public static void main(String[] args){
		
/*		String id = JOptionPane.showInputDialog("���֤����");
		String pat = "[0-9]{6}[1|2][0-9]{3}[0-1][0-9][0-3][0-9][0-9]{3}([0-9]|X|x)";
		Pattern  pattern = Pattern.compile(pat);
		Matcher m = pattern.matcher(id);
		boolean flag = m.matches();
		if(flag)
			System.out.println(id+"��һ���Ϸ������֤����");
		else
			System.out.println(id+"����һ���Ϸ������֤����");*/
		
		String str = "��213��34324��123��423��";
		String pat = "\\d+";
		Pattern pattern = Pattern.compile(pat);
		Matcher m = pattern.matcher(str);
		String newStr = m.replaceAll("-");
		System.out.println("ԭ�ַ���\t"+str);
		System.out.println("�滻����ַ���\t"+newStr);
		
	}
}
