package chapter10;
class Student implements Cloneable{
	private String name;
	private String sex;
	public Student(String name,String sex){
		this.name = name;
		this.sex = sex;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public void setName(String name){
		this.name = name;
	}
	public String toString(){
		return "姓名："+name+"，性别："+sex;
	}
}

public class Clone {
	public static void main(String[] args) throws Exception{
		Student stdA = new Student("贝克汉姆","男");
		Student stdB = stdA;
		stdA.setName("李娜");
		System.out.println("stdA："+stdA+"\nstdB："+stdB);
		stdB = (Student)stdA.clone();
		stdA.setName("贝克汉姆");
		System.out.println("\n克隆之后的修改结果：");
		System.out.println("stdA："+stdA+"\nstdB："+stdB);
	}
}
