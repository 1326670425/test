package chapter14;

class MyThread implements Runnable{
	public void run(){
		for(int i=0;i<4;i++){
			try{
				System.out.println(Thread.currentThread().getName()+"����10��");
				Thread.sleep(10000);
				System.out.println("���߽���");
			}catch(InterruptedException e){
				System.out.println("���߱���ֹ");
				return ;
			}
		}
		System.out.println("run������������");
	}
}

public class _Thread {
	public static void main(String[] args){
		MyThread mt = new MyThread();
		Thread th = new Thread(mt,"A");
		th.start();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		th.interrupt();
	}

}
