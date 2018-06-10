package chapter14;

class SaleTicket implements Runnable{
	private int ticket = 6;
	public void run(){
		for(int i=0;i<100;i++){
			synchronized(this){
				if(ticket>0){
					try{
						Thread.sleep(300);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"Âô³öµÚ£º"+ticket--+"ÕÅÆ±");
				}
			}
		}
	}
}

public class Tongbu {
	public static void main(String[] args){
		SaleTicket mt = new SaleTicket();
		Thread mt1 = new Thread(mt,"1");
		Thread mt2 = new Thread(mt,"2");
		Thread mt3 = new Thread(mt,"3");
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
