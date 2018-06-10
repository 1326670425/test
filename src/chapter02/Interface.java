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
		System.out.println("�����ֻ���ʼ����");
	}
	public void browse(){
		System.out.println("�����ֻ����ͼƬ");
	}
	public String getInfo(){
		return "����"+this.getName()
		+",�۸�"+this.getPrice()
		+",�ֻ�����ϵͳ"+this.OS;
	}
	public void passmessage(String message){
		System.out.println(this.getName()+"�����˸���Ϣ��"+message);
	}
	
}

class Camera extends Feature implements Function{
	private double zoom;//�佹����
	public Camera(String name,double price,double zoom){
		super(name,price);
		this.zoom = zoom;
	}
	public void photograph(){
		System.out.println("�����������");
	}
	public void browse(){
		System.out.println("������������Ƭ");
	}
	public String getInfo(){
		return "����"+this.getName()
		+",�۸�"+this.getPrice()
		+",�佹����"+this.zoom;
	}
	public void printPhoto(){
		System.out.println("���������ӡͼƬ");
	}
}

public class Interface {
	public static void main(String[] args){
		CellPhone cp = new CellPhone("����",2800,"Android");
		Camera cr = new Camera("����",1200,20);
		System.out.println("�ֻ���Ϣ��\n"+cp.getInfo());
		System.out.println("�����Ϣ��\n"+cr.getInfo());
		cp.photograph();
		cp.browse();
		cp.passmessage("hello world");
		cr.photograph();
		cr.browse();
		cr.printPhoto();
	}
}
