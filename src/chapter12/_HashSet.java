package chapter12;
import java.util.*;

class USACO2{
	private String src;
	private double discharge;
	public USACO2(String src,double discharge){
		this.src = src;
		this.discharge = discharge;
	}
	public String toString(){
		return "�ŷ�Դ��"+src+" �ŷ�����"+discharge;
	}
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(!(obj instanceof USACO2)){
			return false;
		}
		USACO2 usa = (USACO2)obj;
		if(this.src.equals(usa.src)&&this.discharge==usa.discharge)
			return true;
		return false;
		
	}
	public int hashCode(){
		return this.src.hashCode();
	}
}

public class _HashSet {
	//ArrayList
	private static List<USACO2>myList = new ArrayList<USACO2>();
	
	public static void main(String[] args){
		Set<USACO2>mySet = new HashSet<USACO2>();
		mySet.add(new USACO2("�յ�",14134));
		mySet.add(new USACO2("����",2202));
		
		mySet.add(new USACO2("��ˮ",2333));
		mySet.add(new USACO2("��ˮ",2333));	
		System.out.println(mySet);
		mySet.remove(new USACO2("����",2202));
		System.out.println(mySet);
		mySet.clear();
		System.out.println(mySet);
		//ArrayList
		addData();
		deleteData(0);
		deleteData(new USACO2("����",2609));
		printOneByOneInfo();
		printInfo();
		otherOperation();
		printOneByOneInfo();
	}
	public static void addData(){
		myList.add(new USACO2("�յ�",10132));
		myList.add(new USACO2("����",2609));
		myList.add(new USACO2("�Ʊ�",3469));
		myList.add(2, new USACO2("��ˮ",3212));
		//����Collection�ӿ�
		Collection<USACO2>myCollection = new ArrayList<USACO2>();
		myCollection.add(new USACO2("���",935));
		myCollection.add(new USACO2("����",6655));
		myList.addAll(myCollection);
	}
	public static void deleteData(int index){
		myList.remove(index);
	}
	public static void deleteData(Object o){
		myList.remove(o);
	}
	public static void printInfo(){
		Object usa[] = myList.toArray();
		System.out.println("���������ӡ��");
		for(int i=0;i<usa.length;i++){
			System.out.println(usa[i]);
		}
	}
	public static void otherOperation(){
		if(myList.isEmpty())
			System.out.println("����Ϊ��");
		else{
			List<USACO2>subList = myList.subList(1,3);
			subList.add(myList.get(myList.indexOf(new USACO2("����",6655))));
			myList=subList;
		}
	}
	public static void printOneByOneInfo(){
		System.out.println("��ǰ�����ӡ��");
		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i));
		}
		System.out.println("�Ӻ���ǰ��ӡ��");
		for(int i=myList.size()-1;i>=0;i--){
			System.out.println(myList.get(i));
		}
	}
}
