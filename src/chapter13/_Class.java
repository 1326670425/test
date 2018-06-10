package chapter13;

import java.lang.reflect.Constructor;

class Student{
	private String name;
	private int age;
	public Student(){
		System.out.println("�޲ι��췽��");
	}
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("�в������췽��");
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String toString(){
		return "������"+name+",���䣺"+age;
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
		System.out.println("������еĹ��췽��");
		for(int i=0;i<cons.length;i++){
			System.out.println("��"+(i+1)+"�����췽��\t"+cons[i]);
		}
		try{
			std1 = (Student)cons[0].newInstance();
			std2 = (Student)cons[1].newInstance("����",55);
		}catch(Exception e){
			e.printStackTrace();
		}
		std1.setName("����");
		std1.setAge(66);
		System.out.println("�޲������췽��"+std1);
		System.out.println("���������췽��"+std2);
	}
}
