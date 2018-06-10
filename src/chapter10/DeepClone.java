package chapter10;
class Book implements Cloneable{
	private String name;
	private double price;
	public Book(String name,double price){
		this.name = name;
		this.price = price;
	}
	public void setName(String name){
		this.name = name;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String toString(){
		return "书名："+name+"，单价："+price;
	}
}

class Student2 implements Cloneable{
	private String name;
	private String sex;
	private Book book;
	public Student2(String name,String sex,Book book){
		this.name = name;
		this.sex = sex;
		this.book = book;
	}
	public Object clone() throws CloneNotSupportedException{
		Student2 std = null;
		std = (Student2)super.clone();
		std.book = (Book)book.clone();
		return std;
		//return super.clone();
	}
	public void setName(String name){
		this.name = name;
	}
	public void setBook(Book book){
		this.book = book;
	}
	public String toString(){
		return "姓名："+name+",性别："+sex+"\n借的书："+this.book.toString();
	}
}

public class DeepClone {
	public static void main(String[] args) throws Exception{
		Book book = new Book("网络爬虫",35);
		Student2 stdA = new Student2("贝克汉姆","男",book);
		Student2 stdB = stdA;
		stdA.setName("乔丹");
		System.out.println("stdA："+stdA+"\nstdB："+stdB);
		
		stdB = (Student2)stdA.clone();
		stdA.setName("贝克汉姆");
		book.setName("Python基础");
		System.out.println("stdA："+stdA+"\nstdB："+stdB);
	}
}
