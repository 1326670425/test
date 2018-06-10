package chapter11;
import java.io.*;
import java.util.*;
import java.text.*;

class InputData{
	private BufferedReader buf = null;		//定义字符缓冲输入流对象
	public InputData(){						//构造方法，利用装饰模式初始化缓冲字符流,InputStreamReader将字节流转为字符流
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString(){				//得到字符串信息
		String temp = null;					//声明一个字符串
		try{
			temp = this.buf.readLine();		//从字符缓冲输入流中接受数据
		}catch(IOException e){
			e.printStackTrace();
		}
		return temp;
	}
	public int getInt(){
		int temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString();
			//利用字符串的正则表达式判断输入的数据是否由数字组成，其中$为行结尾符
			if(str.matches("^\\d+$")){
				temp = Integer.parseInt(str);
				flag = false;
			}
			else{
				System.out.println("输入数据有误，请输入合法的年龄"+str);
			}
		}
		return temp;
	}
	public Date getDate(){
		Date temp = null;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString();
			if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try{
					temp = sdf.parse(str);
					flag = false;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				System.out.println("输入日期有误，请输入合法日期"+str);
			}
		}
		return temp;
	}
}

public class IOTest {
	public static void main(String[] args){
		String name;
		int age;
		Date birthday;
		InputData id = new InputData();
		System.out.println("请输入姓名：");
		name = id.getString();
		System.out.println("请输入年龄：");
		age = id.getInt();
		System.out.println("请输入出生日期（格式yyyy-MM-dd）：");
		birthday = id.getDate();
		System.out.println("姓名："+name);
		System.out.println("年龄："+age);
		System.out.println("出生日期："+new SimpleDateFormat("yyyy年MM月dd日").format(birthday));
	}
}
