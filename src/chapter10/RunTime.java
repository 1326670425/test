package chapter10;

public class RunTime {
	public static void main(String[] args){
		Runtime runtime = Runtime.getRuntime();//ͨ����̬����ȡ��JVM��һ��ʵ��
/*		runtime.gc();//��ʼ����ǰ��Ҫ�ͷ������ռ�
		long maxMemory = runtime.maxMemory();
		long freeMemory = runtime.freeMemory();
		long usedMemory = maxMemory-freeMemory;
		System.out.println("JVM����ڴ棺"+maxMemory);
		System.out.println("JVM�����ڴ棺"+freeMemory);
		System.out.println("JVM��ʹ���ڴ棺"+usedMemory);
		
		String str = "Runtime���Ӧ��";
		long freeMemory2 = runtime.freeMemory();
		System.out.println("JVM�����ڴ�2��"+freeMemory2);
		
		for(int i=0;i<100;i++){
			str += i;
		}
		long freeMemory3 = runtime.freeMemory();
		System.out.println("JVM�����ڴ�3��"+freeMemory3);
		runtime.gc();
		long freeMemory4 = runtime.freeMemory();
		System.out.println("JVM�����ڴ�4��"+freeMemory4);*/
		Process pro = null;
		try{
			pro = runtime.exec("mspaint.exe");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			Thread.sleep(6000);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("mspaint.exe��������6�룬�Զ��ر�");
		pro.destroy();
	}
}
