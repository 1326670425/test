package chapter02;
import javax.swing.JOptionPane;

class Grade{
	public static String getGrade(String score) throws NumberFormatException{
		String grade = "";
		double tempScore = Double.parseDouble(score);
		if(tempScore >= 60)
			grade = "����";
		else if(tempScore >= 0)
			grade = "������";
		else
			grade = "����ɼ�����Ϊ����";
		return grade;
	}
}
public class Exception {
	public static void main(String[] args){
		String score = JOptionPane.showInputDialog("������ɼ���");
		try{
			System.out.println(Grade.getGrade(score));
		}catch(NumberFormatException e){
			System.out.println("����������");
		}
	}
}
