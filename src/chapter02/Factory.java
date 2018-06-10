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
		System.out.println(this.getName()+"停止运行");
		this.setState(false);
	}
	public void start(){
		System.out.println(this.getName()+"开始运行");
		this.setState(true);
	}
	public void close(){
		if(this.getState()){
			System.out.println("关闭之前请先停止运行");
		}
		else{
			System.out.println("关闭"+this.getName()+"的运行");
		}
	}
	public String getInfo(){
		return "电器名称："+this.getName()
		+"，电器功率："+this.getPower()
		+"电器状态："
		+"处于"+(this.getState()?"运行":"停止")+"状态"
		+"转盘直径："+this.turntable;
	}
}

class Refrigerator extends BaseInfo implements ElectricalEquipment{
	private String coolingType;
	public Refrigerator(String name,double power,String coolingType){
		super(name,power);
		this.coolingType = coolingType;
	}
	public void stop(){
		System.out.println(this.getName()+"停止运行");
		this.setState(false);
	}
	public void start(){
		System.out.println(this.getName()+"开始运行");
		this.setState(true);
	}
	public void close(){
		if(this.getState()){
			System.out.println("关闭之前请先停止运行");
		}
		else{
			System.out.println("关闭"+this.getName()+"的运行");
		}
	}
	public String getInfo(){
		return "电器名称："+this.getName()
		+"，电器功率："+this.getPower()
		+"电器状态："
		+"处于"+(this.getState()?"运行":"停止")+"状态"
		+"制冷方式："+this.coolingType;
	}
}

class StaticFactory {
	public static ElectricalEquipment getInstance(String className){
		ElectricalEquipment ee = null;
		if("MicrowaveOven".equals(className)){
			ee = new MicrowaveOven("格兰仕微波炉",300D,10);
		}
		if("Refrigerator".equals(className)){
			ee = new Refrigerator("新飞电冰箱",400,"冷气强制循环");
		}
		return ee;
	}
}

public class Factory{
	public static void main(String[] args){
		ElectricalEquipment e1 = StaticFactory.getInstance("MicrowaveOven");
		ElectricalEquipment e2 = StaticFactory.getInstance("Refrigerator");
		
		System.out.println("微波炉状态:\n");
		e1.start();
		System.out.println(e1.getInfo());
		System.out.println("电冰箱状态：\n");
		e2.close();
		e2.stop();
		System.out.println(e2.getInfo());
	}
}