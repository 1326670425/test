package chapter14;

class MasterA{
	public void say(){
		System.out.println("A对B说，给我醋");
	}
	public void get(){
		System.out.println("A得到醋了");
	}
}
class MasterB{
	public void say(){
		System.out.println("B对A说，给我酱油");
	}
	public void get(){
		System.out.println("B得到酱油了");
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
				System.out.println("A正在等待B的醋");
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
				System.out.println("B正在等待A的酱油");
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
