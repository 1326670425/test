package chapter10;

public class RunTime {
	public static void main(String[] args){
		Runtime runtime = Runtime.getRuntime();//通过静态方法取得JVM的一个实例
/*		runtime.gc();//开始测试前需要释放垃圾空间
		long maxMemory = runtime.maxMemory();
		long freeMemory = runtime.freeMemory();
		long usedMemory = maxMemory-freeMemory;
		System.out.println("JVM最大内存："+maxMemory);
		System.out.println("JVM空闲内存："+freeMemory);
		System.out.println("JVM已使用内存："+usedMemory);
		
		String str = "Runtime类的应用";
		long freeMemory2 = runtime.freeMemory();
		System.out.println("JVM空闲内存2："+freeMemory2);
		
		for(int i=0;i<100;i++){
			str += i;
		}
		long freeMemory3 = runtime.freeMemory();
		System.out.println("JVM空闲内存3："+freeMemory3);
		runtime.gc();
		long freeMemory4 = runtime.freeMemory();
		System.out.println("JVM空闲内存4："+freeMemory4);*/
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
		System.out.println("mspaint.exe程序运行6秒，自动关闭");
		pro.destroy();
	}
}
