package chapter10;
import java.util.Arrays;

class EnergyConsumption implements Comparable<EnergyConsumption>{
	public static String standard = "万吨煤";
	private String department;
	private double consumption;
	public EnergyConsumption(String department,double consumption){
		this.department = department;
		this.consumption = consumption;
	}
	public int compareTo(EnergyConsumption ec){
		if(this.consumption>ec.consumption)
			return 1;
		else if(this.consumption<ec.consumption)
			return -1;
		else
			return 0;
	}
	public String toString(){
		return "\n"+department+"，"+consumption;
	}
}

public class Compare {
	public static void main(String[] args){
		EnergyConsumption ec1 = new EnergyConsumption("农业",7999.99);
		EnergyConsumption ec2 = new EnergyConsumption("煤炭开采",6999.99);
		EnergyConsumption ec3 = new EnergyConsumption("石油和天然气",5999.99);
		EnergyConsumption ec4 = new EnergyConsumption("金属矿",4999.99);
		EnergyConsumption ec5 = new EnergyConsumption("非金属矿",3999.99);
		EnergyConsumption ec6 = new EnergyConsumption("食品制造",2999.99);
		EnergyConsumption ec[] = {ec1,ec2,ec3,ec4,ec5,ec6};
		System.out.println("排序前");
		System.out.println(Arrays.toString(ec));
		Arrays.sort(ec);
		System.out.println("排序之后");
		System.out.println(Arrays.toString(ec));
	}
}
