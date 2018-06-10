package chapter09;
import java.util.Date;

interface Information<T>{
	public T getInfo();
}

class MyInfo<T> implements Information<T>{
	private T info;
	public MyInfo(T info){
		this.info = info;
	}
	public void setInfo(T info){
		this.info = info;
	}
	public T getInfo(){
		return info;
	}
}

public class InterfaceGenarics {
	public static void main(String[] args){
		Information<String>info = new MyInfo<String>("泛型接口的实现方式");
		System.out.println(info.getInfo());
		Information<Date>aDate = null;
		aDate = new MyInfo<Date>(new Date());
		System.out.println(aDate.getInfo());
	}
}
