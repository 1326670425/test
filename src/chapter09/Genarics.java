package chapter09;

class Student{
	private String studentID;
	private String name;
	public Student(String studentID,String name){
		this.studentID = studentID;
		this.name = name;
	}
	public String toString(){
		return "学号："+studentID+"\t姓名："+name;
	}
}

class Teacher{
	private String staffID;
	private String name;
	private double salary;
	public Teacher(String staffID,String name,double salary){
		this.staffID = staffID;
		this.name = name;
		this.salary = salary;
	}
	public String toString(){
		return "职工号："+staffID+"\t姓名："+name+"\t薪水："+salary;
	}
}

class General<T>{
	private T var;
	public T getVar(){
		return var;
	}
	public void setVar(T var){
		this.var = var;
	}
	public void printInfo(){
		System.out.println(var);
	}
}

public class Genarics {
	public static void main(String[] args){
		Student aStd = new Student("01","令狐冲");
		General<Student>std = new General<Student>();
		std.setVar(aStd);
		std.printInfo();
		Teacher aTch = new Teacher("0022","清扬",4500);
		General<Teacher>tch = new General<Teacher>();
		tch.setVar(aTch);
		tch.printInfo();
		General<Double>aDouble = new General<Double>();
		aDouble.setVar(100d);
		System.out.println(aDouble.getVar()*100);

	}
}
