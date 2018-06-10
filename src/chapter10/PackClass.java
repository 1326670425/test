package chapter10;
import javax.swing.JOptionPane;
public class PackClass {
	public static void main(String[] args){
		String week[] = {"SAT","SUN","MON","TUE","WED","THU","FRI"};
		String temp = JOptionPane.showInputDialog("请输入十月份的某一天");
		try{
			int aInt = Integer.parseInt(temp);
			while(aInt>=1 && aInt<=31){
				int index = aInt%7;
				if(index == 0)
					index = 7;
				System.out.println("你输入的是第"+aInt+"天，这天是星期"+week[index-1]);
				temp = JOptionPane.showInputDialog("请输入十月份的某一天");
				aInt = Integer.parseInt(temp);
			}
		}catch(NumberFormatException e){
			System.out.println(temp+"不是合法数字字符串，请重新输入");
		}
	}
}
