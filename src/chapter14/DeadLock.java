package chapter14;

class MasterA{
	public void say(){
		System.out.println("A��B˵�����Ҵ�");
	}
	public void get(){
		System.out.println("A�õ�����");
	}
}
class MasterB{
	public void say(){
		System.out.println("B��A˵�����ҽ���");
	}
	public void get(){
		System.out.println("B�õ�������");
	}
}

public class DeadLock implements Runnable{
	private static MasterA ma = new MasterA();
	private static MasterB mb = new MasterB();
	private boolean flag = true;
	public void run(){
		if(flag){
			synchronized(ma){
				ma.say();
				System.out.println("A���ڵȴ�B�Ĵ�");
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(mb){
					ma.get();
				}
			}
		}
		else{
			synchronized(mb){
				mb.say();
				System.out.println("B���ڵȴ�A�Ľ���");
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(ma){
					mb.get();
				}
			}
		}
	}
	public static void main(String[] args){
		DeadLock t1 = new DeadLock();
		DeadLock t2 = new DeadLock();
		t1.flag = true;
		t2.flag = false;
		Thread thA = new Thread(t1);
		Thread thB = new Thread(t2);
		thA.start();
		thB.start();
	}
}
