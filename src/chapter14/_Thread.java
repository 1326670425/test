package chapter14;

class MyThread implements Runnable{
	public void run(){
		for(int i=0;i<4;i++){
			try{
				System.out.println(Thread.currentThread().getName()+"ÐÝÃß10Ãë");
				Thread.sleep(10000);
				System.out.println("ÐÝÃß½áÊø");
			}catch(InterruptedException e){
				System.out.println("ÐÝÃß±»ÖÕÖ¹");
				return ;
			}
		}
		System.out.println("run·½·¨Õý³£½áÊø");
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
