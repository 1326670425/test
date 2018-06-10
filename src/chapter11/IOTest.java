package chapter11;
import java.io.*;
import java.util.*;
import java.text.*;

class InputData{
	private BufferedReader buf = null;		//�����ַ���������������
	public InputData(){						//���췽��������װ��ģʽ��ʼ�������ַ���,InputStreamReader���ֽ���תΪ�ַ���
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString(){				//�õ��ַ�����Ϣ
		String temp = null;					//����һ���ַ���
		try{
			temp = this.buf.readLine();		//���ַ������������н�������
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
			//�����ַ�����������ʽ�ж�����������Ƿ���������ɣ�����$Ϊ�н�β��
			if(str.matches("^\\d+$")){
				temp = Integer.parseInt(str);
				flag = false;
			}
			else{
				System.out.println("������������������Ϸ�������"+str);
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
				System.out.println("������������������Ϸ�����"+str);
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
		System.out.println("������������");
		name = id.getString();
		System.out.println("���������䣺");
		age = id.getInt();
		System.out.println("������������ڣ���ʽyyyy-MM-dd����");
		birthday = id.getDate();
		System.out.println("������"+name);
		System.out.println("���䣺"+age);
		System.out.println("�������ڣ�"+new SimpleDateFormat("yyyy��MM��dd��").format(birthday));
	}
}
