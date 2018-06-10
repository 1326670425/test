package chapter02;

interface ElectricalEquipment{
	void stop();
	void start();
	void close();
	String getInfo();
}

class BaseInfo{
	private String name;
	private double power;
	private boolean state;
	public BaseInfo(String name,double power){
		this.name = name;
		this.power = power;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getPower(){
		return power;
	}
	public void setPower(double power){
		this.power = power;
	}
	public boolean getState(){
		return state;
	}
	public void setState(boolean state){
		this.state = state;
	}
}

class MicrowaveOven extends BaseInfo implements ElectricalEquipment{
	private int turntable;
	public MicrowaveOven(String name,double power,int turntable){
		super(name,power);
		this.turntable = turntable;
	}
	public void stop(){
		System.out.println(this.getName()+"ֹͣ����");
		this.setState(false);
	}
	public void start(){
		System.out.println(this.getName()+"��ʼ����");
		this.setState(true);
	}
	public void close(){
		if(this.getState()){
			System.out.println("�ر�֮ǰ����ֹͣ����");
		}
		else{
			System.out.println("�ر�"+this.getName()+"������");
		}
	}
	public String getInfo(){
		return "�������ƣ�"+this.getName()
		+"���������ʣ�"+this.getPower()
		+"����״̬��"
		+"����"+(this.getState()?"����":"ֹͣ")+"״̬"
		+"ת��ֱ����"+this.turntable;
	}
}

class Refrigerator extends BaseInfo implements ElectricalEquipment{
	private String coolingType;
	public Refrigerator(String name,double power,String coolingType){
		super(name,power);
		this.coolingType = coolingType;
	}
	public void stop(){
		System.out.println(this.getName()+"ֹͣ����");
		this.setState(false);
	}
	public void start(){
		System.out.println(this.getName()+"��ʼ����");
		this.setState(true);
	}
	public void close(){
		if(this.getState()){
			System.out.println("�ر�֮ǰ����ֹͣ����");
		}
		else{
			System.out.println("�ر�"+this.getName()+"������");
		}
	}
	public String getInfo(){
		return "�������ƣ�"+this.getName()
		+"���������ʣ�"+this.getPower()
		+"����״̬��"
		+"����"+(this.getState()?"����":"ֹͣ")+"״̬"
		+"���䷽ʽ��"+this.coolingType;
	}
}

class StaticFactory {
	public static ElectricalEquipment getInstance(String className){
		ElectricalEquipment ee = null;
		if("MicrowaveOven".equals(className)){
			ee = new MicrowaveOven("������΢��¯",300D,10);
		}
		if("Refrigerator".equals(className)){
			ee = new Refrigerator("�·ɵ����",400,"����ǿ��ѭ��");
		}
		return ee;
	}
}

public class Factory{
	public static void main(String[] args){
		ElectricalEquipment e1 = StaticFactory.getInstance("MicrowaveOven");
		ElectricalEquipment e2 = StaticFactory.getInstance("Refrigerator");
		
		System.out.println("΢��¯״̬:\n");
		e1.start();
		System.out.println(e1.getInfo());
		System.out.println("�����״̬��\n");
		e2.close();
		e2.stop();
		System.out.println(e2.getInfo());
	}
}