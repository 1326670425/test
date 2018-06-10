package chapter09;

class BeidouSystem<T>{
	private String city;
	private T longitude;//����
	private T latitude;//γ��
	private T elevations;//����
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
		return "\n�����ǣ�"+city
				+"\n�����ǣ�"+longitude
				+"\nγ���ǣ�"+latitude
				+"\n�����ǣ�"+elevations;
	}
}

public class Bds {
	public static void main(String[] args){
		BeidouSystem<String> bs = new BeidouSystem<String>();
		bs.setCity("����");
		bs.setLongitude("����115��");
		bs.setLatitude("��γ39��");
		bs.setElevations("ƽ������43��");
		System.out.println(bs.getCoordinate());
		BeidouSystem<Double> bs2 = new BeidouSystem<Double>();
		bs2.setCity("����");
		bs2.setLongitude(91.0);
		bs2.setLatitude(29.0);
		bs2.setElevations(3650.0);
		System.out.println(bs2.getCoordinate());
		//System.out.println("�������������Ȳ�Ϊ��"+(bs.getLongitude()-bs2.getLongitude()));
	}
}
