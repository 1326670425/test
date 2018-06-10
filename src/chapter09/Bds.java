package chapter09;

class BeidouSystem<T>{
	private String city;
	private T longitude;//经度
	private T latitude;//纬度
	private T elevations;//海拔
	public T getLongitude(){
		return longitude;
	}
	public void setLongitude(T longitude){
		this.longitude = longitude;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}
	public T getLatitude(){
		return latitude;
	}
	public void setLatitude(T latitude){
		this.latitude = latitude;
	}
	public T getElevations(){
		return elevations;
	}
	public void setElevations(T elevations){
		this.elevations = elevations;
	}
	public String getCoordinate(){
		return "\n城市是："+city
				+"\n经度是："+longitude
				+"\n纬度是："+latitude
				+"\n海拔是："+elevations;
	}
}

public class Bds {
	public static void main(String[] args){
		BeidouSystem<String> bs = new BeidouSystem<String>();
		bs.setCity("北京");
		bs.setLongitude("东经115度");
		bs.setLatitude("北纬39度");
		bs.setElevations("平均海拔43米");
		System.out.println(bs.getCoordinate());
		BeidouSystem<Double> bs2 = new BeidouSystem<Double>();
		bs2.setCity("拉萨");
		bs2.setLongitude(91.0);
		bs2.setLatitude(29.0);
		bs2.setElevations(3650.0);
		System.out.println(bs2.getCoordinate());
		//System.out.println("北京和拉萨经度差为："+(bs.getLongitude()-bs2.getLongitude()));
	}
}
