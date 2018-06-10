package chapter13;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

interface BasicInfo{
	public static final String TITLE = "停车记录告知单";
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
		return "编号："+id+",车辆类型："+autoType+",车牌号："+licensePlateNumber+",停车地点："+address;
	}
	public void tellInfo(String info){
		System.out.println("违章条款：");
		System.out.println(info);
	}
	public void printDate(){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	private void aPrivateMothod(){
		System.out.println("一个私有方法");
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
		//取得父类
		Class<?>superInfo = aClass.getSuperclass();
		System.out.println("类"+thisClass+"的父类是"+superInfo);
		//取得实现的接口
		Class<?>allInterface[] = aClass.getInterfaces();
		System.out.println("实现的接口数为"+allInterface.length);
		for(int i=0;i<allInterface.length;i++){
			System.out.println("第"+(i+1)+"个接口为"+allInterface[i]);
		}
		//取得所有构造方法
		Constructor cons[] = aClass.getConstructors();
		for(int i=0;i<cons.length;i++){
			int modifier = cons[i].getModifiers();//取出访问控制权限
			String name = cons[i].getName();
			System.out.println("权限类型："+Modifier.toString(modifier)+"，方法名称："+name);
			Class<?>para[] = cons[i].getParameterTypes();//构造方法的参数类型
			System.out.println("参数类型：");
			for(int j=0;j<para.length;j++){
				System.out.println(para[j].getName()+",");
			}
			System.out.println();
		}
		//取得所有非构造方法
		Method mth[] = null;
		int modifier = 1;
		String methodName = null;
		Class<?>returnType = null;
		Class<?>[]paraType = null;
		//mth = aClass.getMethods();//返回父类的public方法和本类的所有方法
		mth = aClass.getDeclaredMethods();
		for(int i=0;i<mth.length;i++){
			modifier = mth[i].getModifiers();//取得方法的控制符
			String thisModifier = Modifier.toString(modifier);//根据控制符编号取得控制符
			returnType = mth[i].getReturnType();
			paraType = mth[i].getParameterTypes();
			methodName = mth[i].getName();
			System.out.println("访问控制符："+thisModifier+"，返回值类型："+returnType+"，方法名称"+methodName+"，参数类型：");
			for(int j=0;j<paraType.length;j++){
				System.out.print(paraType[j]);
			}
			System.out.println();
		}
		//取得数据成员信息
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
			System.out.println("成员控制符："+modifierName+"，成员名称："+fieldName+"，成员类型："+typeName.getName());
			
		}
		System.out.println("————————取出父类属性信息，只有公共属性————————");
		field = aClass.getFields();
		for(int i=0;i<field.length;i++){
			modifier = field[i].getModifiers();
			modifierName = Modifier.toString(modifier);
			fieldName = field[i].getName();
			typeName = field[i].getType();
			System.out.println("成员控制符："+modifierName+"，成员名称："+fieldName+"，成员类型："+typeName.getName());
		}
		//利用反射调用成员方法
		try{
			Method method1 = aClass.getMethod("printDate");//无参数方法
			method1.invoke(aClass.newInstance());
			Method method2 = aClass.getMethod("tellInfo", String.class);
			method2.invoke(aClass.newInstance(), "第一条第一款");
		}catch(Exception e){
			e.printStackTrace();
		}
		//调用setter和getter方法
		Object obj = null;
		try{
			obj = aClass.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		setter(obj,"autoType","小客车",String.class);
		setter(obj,"address","北京市",String.class);
		getter(obj,"autoType");
		getter(obj,"address");
		//利用反射操作数据成员
		Field autoTypeField = null;
		Field addressField = null;
		try{
			autoTypeField = aClass.getDeclaredField("autoType");
			addressField = aClass.getDeclaredField("address");
			autoTypeField.setAccessible(true);//设置访问权限，外部可访问
			addressField.setAccessible(true);
			autoTypeField.set(obj, "小客车");
			addressField.set(obj, "北京市");
			System.out.println("违章车辆类型："+autoTypeField.get(obj)+"，违章地点："+addressField.get(obj));
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
