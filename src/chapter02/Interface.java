package chapter02;

interface Function{
	void photograph();
	void browse();
}

abstract class Feature{
	private String name;
	private double price;
	public Feature(String name,double price){
		this.name = name;
		this.price = price;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	
	abstract public String getInfo();
}

class CellPhone extends Feature implements Function{
	private String OS;
	public CellPhone(String name,double price,String os){
		super(name,price);
		this.OS = os;
	}
	public void photograph(){
		System.out.println("利用手机开始照相");
	}
	public void browse(){
		System.out.println("利用手机浏览图片");
	}
	public String getInfo(){
		return "名称"+this.getName()
		+",价格"+this.getPrice()
		+",手机操作系统"+this.OS;
	}
	public void passmessage(String message){
		System.out.println(this.getName()+"发送了个消息："+message);
	}
	
}

class Camera extends Feature implements Function{
	private double zoom;//变焦倍数
	public Camera(String name,double price,double zoom){
		super(name,price);
		this.zoom = zoom;
	}
	public void photograph(){
		System.out.println("利用相机拍照");
	}
	public void browse(){
		System.out.println("利用相机浏览照片");
	}
	public String getInfo(){
		return "名称"+this.getName()
		+",价格"+this.getPrice()
		+",变焦倍数"+this.zoom;
	}
	public void printPhoto(){
		System.out.println("利用相机打印图片");
	}
}

public class Interface {
	public static void main(String[] args){
		CellPhone cp = new CellPhone("三星",2800,"Android");
		Camera cr = new Camera("索尼",1200,20);
		System.out.println("手机信息：\n"+cp.getInfo());
		System.out.println("相机信息：\n"+cr.getInfo());
		cp.photograph();
		cp.browse();
		cp.passmessage("hello world");
		cr.photograph();
		cr.browse();
		cr.printPhoto();
	}
}
