package chapter02;

abstract class Person {
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	abstract public void workOn();
}

class Student extends Person{
	private String course;
	public String getCourse(){
		return course;
	}
	public void setCourse(String course){
		this.course = course;
	}
	public void workOn(){
		System.out.println(this.getName()+"ѧ����ѧϰ"+this.course);
	}
}

class Teacher extends Person{
	private String course;
	public String getCourse(){
		return course;
	}
	public void setCourse(String course){
		this.course = course;
	}
	public void workOn(){
		System.out.println(this.getName()+"��ʦ����"+this.course);
	}
}


