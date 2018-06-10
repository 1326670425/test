package chapter02;

interface A{
	String slogan = "滴水行动";
	void printInfo();
}

class B{
	private String clause;
	public B(String clause){
		this.clause = clause;
	}
	public String getClause(){
		return clause;
	}
	public void setClause(String clause){
		this.clause = clause;
	}
	public void print(){
		System.out.println("父类B");
	}
}

public class C extends B implements A{
	private int chapter;
	public C(String clause,int chapter){
		super(clause);
		this.chapter = chapter;
	}
	public void printInfo(){
		System.out.println(A.slogan);
		System.out.println("第"+chapter+"章"+this.getClause());
	}
	public void print(){
		System.out.println("子类C");
	}
	public static void main(String[] args){
		//new C("环境监督管理",2).printInfo();
		B b = new C("环境监督管理",2);
		System.out.println(b instanceof C);
		C c = (C)b;
		c.print();
		System.out.println(new java.util.Date());
	}
}
