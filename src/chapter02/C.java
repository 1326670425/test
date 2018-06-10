package chapter02;

interface A{
	String slogan = "��ˮ�ж�";
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
		System.out.println("����B");
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
		System.out.println("��"+chapter+"��"+this.getClause());
	}
	public void print(){
		System.out.println("����C");
	}
	public static void main(String[] args){
		//new C("�����ල����",2).printInfo();
		B b = new C("�����ල����",2);
		System.out.println(b instanceof C);
		C c = (C)b;
		c.print();
		System.out.println(new java.util.Date());
	}
}
