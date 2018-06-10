package chapter09;

class Person{
	private String name;
	private String sex;
	public Person(String name,String sex){
		this.name = name;
		this.sex = sex;
	}
	public String toString(){
		return "姓名："+name+"，性别："+sex;
	}
}

class Student2 extends Person{
	private String Student2ID;
	private String className;
	public Student2(String name,String sex,String Student2ID,String className){
		super(name,sex);
		this.Student2ID = Student2ID;
		this.className = className;
	}
	public String toString(){
		return super.toString()+"学号："+Student2ID+"，班级："+className;
	}
}

class Employee extends Person{
	private String empID;
	private String department;
	public Employee(String name,String sex,String empID,String department){
		super(name,sex);
		this.empID = empID;
		this.department = department;
	}
	public String toString(){
		return super.toString()+"工号："+empID+"，部门："+department;
	}
}

class Information2<T extends Person>{
	private T info;
	public void setInfo(T t){
		this.info = t;
	}
	public T getInfo(){
		return info;
	}
	public String toString(){
		return this.info.toString();
	}
}

public class LimitedGenarics {
	public static void printInfo(Information2<? extends Person>temp){
		System.out.println(temp+"OK！");
	}
	public static void main(String[] args){
		Information2<Student2>info = new Information2<Student2>();
		Student2 aStd = new Student2("AA","男","001","软件工程");
		info.setInfo(aStd);
		printInfo(info);
		Information2<Employee>info2 = new Information2<Employee>();
		Employee emp = new Employee("BB","女","1111","管理部门");
		info2.setInfo(emp);
		printInfo(info2);
		
	}
}
