package chapter12;
import java.util.*;

class Student implements Comparable{
	private String id;
	private Information info;
	public Student(){};
	public Student(String id,Information info){
		this.id = id;
		this.info = info;
	}
	public String toString(){
		return "基本信息："+this.info;
	}
	public int compareTo(Object obj){
		Student per = (Student)obj;
		return this.id.compareTo(per.id);
	}
	
	class Information{
		private String name;
		private int age;
		public Information(String name,int age){
			this.name = name;
			this.age = age;
		}
		public String toString(){
			return "姓名："+name+"年龄："+age;
		}
	}
}

public class _Map {
	private static Map<String,Student>myMap = new HashMap<String,Student>();
	public static void main(String[] args){
		addData();
		printAll();
		printValue();
		System.out.println(isKey("002"));
	}
	public static void addData(){
		String id = null;
		Student std = new Student();
		Student.Information info = null;
		id = "001";
		info = std.new Information("小明",22);
		std = new Student(id,info);
		myMap.put(id, std);
		id = "002";
		info = std.new Information("小红",21);
		std = new Student(id,info);
		myMap.put(id, std);
		id = "003";
		info = std.new Information("李华",23);
		std = new Student(id,info);
		myMap.put(id, std);
	}
	public static void printAll(){
		Set<String>keys = myMap.keySet();
		Student std = null;
		Iterator<String>iter = keys.iterator();
		System.out.println("根据key值，输出value：");
		while(iter.hasNext()){
			String aKey = iter.next();
			System.out.println(aKey+"="+myMap.get(aKey));
		}
		
	}
	public static void printValue(){
		Collection<Student>values = myMap.values();
		Iterator<Student>iter = values.iterator();
		System.out.println("\n输出values：");
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	public static boolean isKey(String key){
		if(myMap.containsKey(key))
			return true;
		return false;
	}
}
