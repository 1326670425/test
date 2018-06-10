package chapter12;
import java.util.*;

class USACO implements Comparable<USACO>{
	private String src;
	private double discharge;
	public USACO(String src,double discharge){
		this.src = src;
		this.discharge = discharge;
	}
	public String toString(){
		return "排放源："+src+" 排放量："+discharge;
	}
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(!(obj instanceof USACO))
			return false;
		USACO usa = (USACO)obj;
		if(this.src.equals(usa.src)&&this.discharge==usa.discharge)
			return true;
		return false;
	}
	public int hashCode(){
		return this.hashCode();
	}
	public int compareTo(USACO usa){
		if(this.discharge>usa.discharge)
			return 1;
		else if(this.discharge<usa.discharge)
			return -1;
		else
			return this.src.compareTo(usa.src);
			//return 0;
	}
}

public class _TreeSet {
	public static void main(String[] args){
		Set<USACO>mySet = new TreeSet<USACO>();
		mySet.add(new USACO("空气",2609));
		mySet.add(new USACO("制冰",3479));
		mySet.add(new USACO("空调",21231));
		mySet.add(new USACO("热水",2333));
		System.out.println(mySet);
		mySet.remove(new USACO("制冰",3479));
		System.out.println(mySet);
	}
}
