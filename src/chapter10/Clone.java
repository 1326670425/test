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
		return "������"+name+"���Ա�"+sex;
	}
}

public class Clone {
	public static void main(String[] args) throws Exception{
		Student stdA = new Student("���˺�ķ","��");
		Student stdB = stdA;
		stdA.setName("����");
		System.out.println("stdA��"+stdA+"\nstdB��"+stdB);
		stdB = (Student)stdA.clone();
		stdA.setName("���˺�ķ");
		System.out.println("\n��¡֮����޸Ľ����");
		System.out.println("stdA��"+stdA+"\nstdB��"+stdB);
	}
}
