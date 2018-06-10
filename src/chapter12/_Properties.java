package chapter12;
import java.io.*;
import java.util.*;

public class _Properties {
	private static Properties myPro = new Properties();
	public static void main(String[] args){
		mySetProperty();
		storeFile("F://property.txt");
		readFile("F://property.txt");
		printInfo();
	}
	public static void mySetProperty(){
		myPro.setProperty("豫", "河南");
		myPro.setProperty("京", "北京");
		myPro.setProperty("渝", "重庆");
	}
	public static void printInfo(){
		Set<Object>keys = myPro.keySet();
		Iterator<Object>iter = keys.iterator();
		Object obj = null;
		while(iter.hasNext()){
			obj = iter.next();
			System.out.println("简称："+obj+",全称是："+myPro.getProperty((String)obj));
			
		}
	}
	public static void storeFile(String fileName){
		System.out.println("\n开始保存属性文件");
		File file = new File(fileName);
		try{
			myPro.store(new FileOutputStream(file),"简称");
			//myPro.store(new FileWriter(file), "简称");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void readFile(String fileName){
		System.out.println("\n开始读取属性文件");
		File file = new File(fileName);
		try{
			myPro.load(new FileInputStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
