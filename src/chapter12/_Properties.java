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
		myPro.setProperty("ԥ", "����");
		myPro.setProperty("��", "����");
		myPro.setProperty("��", "����");
	}
	public static void printInfo(){
		Set<Object>keys = myPro.keySet();
		Iterator<Object>iter = keys.iterator();
		Object obj = null;
		while(iter.hasNext()){
			obj = iter.next();
			System.out.println("��ƣ�"+obj+",ȫ���ǣ�"+myPro.getProperty((String)obj));
			
		}
	}
	public static void storeFile(String fileName){
		System.out.println("\n��ʼ���������ļ�");
		File file = new File(fileName);
		try{
			myPro.store(new FileOutputStream(file),"���");
			//myPro.store(new FileWriter(file), "���");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void readFile(String fileName){
		System.out.println("\n��ʼ��ȡ�����ļ�");
		File file = new File(fileName);
		try{
			myPro.load(new FileInputStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
