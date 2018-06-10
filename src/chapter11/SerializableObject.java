package chapter11;
import java.io.*;

class Ozone implements Serializable{
	private String city;
	private String date;
	transient private double hourAverage;//不被序列化的数据成员
	private double max;
	public Ozone(String city,String date,double hourAverage,double max){
		this.city = city;
		this.date = date;
		this.hourAverage = hourAverage;
		this.max = max;
	}
	public String toString(){
		return "地区："+city+"时间："+date+"小时平均值："+hourAverage+"最大值："+max;
	}
}

class Person implements Serializable{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "姓名："+name+"年龄："+age;
	}
}

public class SerializableObject {
	public static void main(String[] args){
		String fileName = "F:\\myobject.obj";
		
		File file = new File(fileName);
/*		//序列化
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(file));
			Ozone ozG = new Ozone("广州","1996.04",111.1,333.3);
			Ozone ozB = new Ozone("北京","1995.12",234.2,345.4);
			oos.writeObject(ozG);
			oos.writeObject(ozB);
			oos.writeObject(new Person("张无忌",21));
			oos.writeObject(new Person("令狐冲",22));
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		
/*		//反序列化
		ObjectInputStream ois = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			Ozone ozG = (Ozone)ois.readObject();
			Ozone ozB = (Ozone)ois.readObject();
			Person p1 = (Person)ois.readObject();
			Person p2 = (Person)ois.readObject();
			System.out.println(ozG);
			System.out.println(ozB);
			System.out.println(p1);
			System.out.println(p2);
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(new Person("张无忌",21));
			String str = bos.toString("iso-8859-1");
			
			System.out.println(str);
			ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("iso-8859-1"));
			ObjectInputStream ois = new ObjectInputStream(bis);
			try {
				Person p = (Person)ois.readObject();
				System.out.println(p.toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
