package chapter13;

import java.lang.reflect.Constructor;

class Student{
	private String name;
	private int age;
	public Student(){
		System.out.println("无参构造方法");
	}
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("有参数构造方法");
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String toString(){
		return "姓名："+name+",年龄："+age;
	}
}

public class _Class {
	public static void main(String[] args){
		Class<?>stdClass = null;
		Student std1 = null;
		Student std2 = null;
		try{
			stdClass = Class.forName("chapter13.Student");
		}catch(Exception e){
			e.printStackTrace();
		}
		Constructor<?>cons[] = stdClass.getConstructors();
		System.out.println("输出所有的构造方法");
		for(int i=0;i<cons.length;i++){
			System.out.println("第"+(i+1)+"个构造方法\t"+cons[i]);
		}
		try{
			std1 = (Student)cons[0].newInstance();
			std2 = (Student)cons[1].newInstance("老子",55);
		}catch(Exception e){
			e.printStackTrace();
		}
		std1.setName("孔子");
		std1.setAge(66);
		System.out.println("无参数构造方法"+std1);
		System.out.println("带参数构造方法"+std2);
	}
}
