package chapter13;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

interface BasicInfo{
	public static final String TITLE = "ͣ����¼��֪��";
	public void tellInfo(String info);
}

class Ticket implements BasicInfo{
	private static long id = 0;
	private String autoType;
	private String licensePlateNumber;
	private String address;
	private String color;
	public Ticket(){
		id++;
	}
	private Ticket(String autoType){
		this.autoType = autoType;
		id++;
	}
	Ticket(String autoType,String address){
		this.autoType = autoType;
		this.address = address;
		id++;
	}
	protected Ticket(String autoType,String licensePlateNumber,String address){
		this.autoType = autoType;
		this.licensePlateNumber = licensePlateNumber;
		this.address = address;
		id++;
	}
	public Ticket(String autoType,String licensePlateNumber,String address,String color){
		this.autoType = autoType;
		this.licensePlateNumber = licensePlateNumber;
		this.address = address;
		this.color =color;
		id++;
	}
	public static long getId(){
		return id;
	}
	public static void setId(long id){
		Ticket.id = id;
	}
	public String getAutoType(){
		return autoType;
	}
	public void setAutoType(String autoType){
		this.autoType = autoType;
	}
	public String getLicensePlateNumber(){
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber){
		this.licensePlateNumber = licensePlateNumber;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String toString(){
		return "��ţ�"+id+",�������ͣ�"+autoType+",���ƺţ�"+licensePlateNumber+",ͣ���ص㣺"+address;
	}
	public void tellInfo(String info){
		System.out.println("Υ�����");
		System.out.println(info);
	}
	public void printDate(){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	private void aPrivateMothod(){
		System.out.println("һ��˽�з���");
	}
}

public class Reflect {
	public static void main(String[] args){
		Class<?>aClass = null;
		String thisClass = "chapter13.Ticket";
		try{
			aClass = Class.forName(thisClass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//ȡ�ø���
		Class<?>superInfo = aClass.getSuperclass();
		System.out.println("��"+thisClass+"�ĸ�����"+superInfo);
		//ȡ��ʵ�ֵĽӿ�
		Class<?>allInterface[] = aClass.getInterfaces();
		System.out.println("ʵ�ֵĽӿ���Ϊ"+allInterface.length);
		for(int i=0;i<allInterface.length;i++){
			System.out.println("��"+(i+1)+"���ӿ�Ϊ"+allInterface[i]);
		}
		//ȡ�����й��췽��
		Constructor cons[] = aClass.getConstructors();
		for(int i=0;i<cons.length;i++){
			int modifier = cons[i].getModifiers();//ȡ�����ʿ���Ȩ��
			String name = cons[i].getName();
			System.out.println("Ȩ�����ͣ�"+Modifier.toString(modifier)+"���������ƣ�"+name);
			Class<?>para[] = cons[i].getParameterTypes();//���췽���Ĳ�������
			System.out.println("�������ͣ�");
			for(int j=0;j<para.length;j++){
				System.out.println(para[j].getName()+",");
			}
			System.out.println();
		}
		//ȡ�����зǹ��췽��
		Method mth[] = null;
		int modifier = 1;
		String methodName = null;
		Class<?>returnType = null;
		Class<?>[]paraType = null;
		//mth = aClass.getMethods();//���ظ����public�����ͱ�������з���
		mth = aClass.getDeclaredMethods();
		for(int i=0;i<mth.length;i++){
			modifier = mth[i].getModifiers();//ȡ�÷����Ŀ��Ʒ�
			String thisModifier = Modifier.toString(modifier);//���ݿ��Ʒ����ȡ�ÿ��Ʒ�
			returnType = mth[i].getReturnType();
			paraType = mth[i].getParameterTypes();
			methodName = mth[i].getName();
			System.out.println("���ʿ��Ʒ���"+thisModifier+"������ֵ���ͣ�"+returnType+"����������"+methodName+"���������ͣ�");
			for(int j=0;j<paraType.length;j++){
				System.out.print(paraType[j]);
			}
			System.out.println();
		}
		//ȡ�����ݳ�Ա��Ϣ
		Field field[] = null;
		String modifierName;
		String fieldName=null;
		Class<?>typeName = null;
		field = aClass.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			modifier = field[i].getModifiers();
			modifierName = Modifier.toString(modifier);
			fieldName = field[i].getName();
			typeName = field[i].getType();
			System.out.println("��Ա���Ʒ���"+modifierName+"����Ա���ƣ�"+fieldName+"����Ա���ͣ�"+typeName.getName());
			
		}
		System.out.println("����������������ȡ������������Ϣ��ֻ�й������ԡ���������������");
		field = aClass.getFields();
		for(int i=0;i<field.length;i++){
			modifier = field[i].getModifiers();
			modifierName = Modifier.toString(modifier);
			fieldName = field[i].getName();
			typeName = field[i].getType();
			System.out.println("��Ա���Ʒ���"+modifierName+"����Ա���ƣ�"+fieldName+"����Ա���ͣ�"+typeName.getName());
		}
		//���÷�����ó�Ա����
		try{
			Method method1 = aClass.getMethod("printDate");//�޲�������
			method1.invoke(aClass.newInstance());
			Method method2 = aClass.getMethod("tellInfo", String.class);
			method2.invoke(aClass.newInstance(), "��һ����һ��");
		}catch(Exception e){
			e.printStackTrace();
		}
		//����setter��getter����
		Object obj = null;
		try{
			obj = aClass.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		setter(obj,"autoType","С�ͳ�",String.class);
		setter(obj,"address","������",String.class);
		getter(obj,"autoType");
		getter(obj,"address");
		//���÷���������ݳ�Ա
		Field autoTypeField = null;
		Field addressField = null;
		try{
			autoTypeField = aClass.getDeclaredField("autoType");
			addressField = aClass.getDeclaredField("address");
			autoTypeField.setAccessible(true);//���÷���Ȩ�ޣ��ⲿ�ɷ���
			addressField.setAccessible(true);
			autoTypeField.set(obj, "С�ͳ�");
			addressField.set(obj, "������");
			System.out.println("Υ�³������ͣ�"+autoTypeField.get(obj)+"��Υ�µص㣺"+addressField.get(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void setter(Object obj,String att,Object value,Class<?>type){
		try{
			Method method = obj.getClass().getMethod("set"+initStr(att), type);
			method.invoke(obj, value);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void getter(Object obj,String att){
		try{
			Method method = obj.getClass().getMethod("get"+initStr(att));
			System.out.println(method.invoke(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String initStr(String old){
		String str = old.substring(0, 1).toUpperCase()+old.substring(1);
		return str;
	}

}
