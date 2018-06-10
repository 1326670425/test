package chapter02;

public class Main {
	public static void main(String[] args){
		Student std = new Student();
		std.setName("张无忌");
		std.setCourse("高数");
		std.workOn();
		Teacher tc = new Teacher();
		tc.setName("周芷若");
		tc.setCourse("英语");
		tc.workOn();
	}
}
