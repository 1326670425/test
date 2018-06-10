package chapter02;
import javax.swing.JOptionPane;

class Grade{
	public static String getGrade(String score) throws NumberFormatException{
		String grade = "";
		double tempScore = Double.parseDouble(score);
		if(tempScore >= 60)
			grade = "及格";
		else if(tempScore >= 0)
			grade = "不及格";
		else
			grade = "输入成绩不能为负数";
		return grade;
	}
}
public class Exception {
	public static void main(String[] args){
		String score = JOptionPane.showInputDialog("请输入成绩：");
		try{
			System.out.println(Grade.getGrade(score));
		}catch(NumberFormatException e){
			System.out.println("请重新输入");
		}
	}
}
