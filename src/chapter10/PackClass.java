package chapter10;
import javax.swing.JOptionPane;
public class PackClass {
	public static void main(String[] args){
		String week[] = {"SAT","SUN","MON","TUE","WED","THU","FRI"};
		String temp = JOptionPane.showInputDialog("������ʮ�·ݵ�ĳһ��");
		try{
			int aInt = Integer.parseInt(temp);
			while(aInt>=1 && aInt<=31){
				int index = aInt%7;
				if(index == 0)
					index = 7;
				System.out.println("��������ǵ�"+aInt+"�죬����������"+week[index-1]);
				temp = JOptionPane.showInputDialog("������ʮ�·ݵ�ĳһ��");
				aInt = Integer.parseInt(temp);
			}
		}catch(NumberFormatException e){
			System.out.println(temp+"���ǺϷ������ַ���������������");
		}
	}
}
