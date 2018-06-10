package chapter02;

interface Window{
	public void open();//打开窗口
	public void close();//关闭窗口
	public void activated();//激活窗口
	public void iconified();//最小化
	public void deiconified();//恢复窗口大小
}

abstract class WindowAdapter implements Window{
	public void open(){};
	public void close(){};
	public void activated(){};
	public void iconified(){};
	public void deiconified(){};
}

class MyWindow extends WindowAdapter{
	public void open(){
		System.out.println("我的窗口——打开窗口");
	}
	public void close(){
		System.out.println("我的窗口——关闭窗口");
	}
}

class AppWindow extends WindowAdapter{
	public void open(){
		System.out.println("应用程序——打开窗口");
	}
	public void activated(){
		System.out.println("应用程序——激活窗口");
	}
}

public class Adapter {
	public static void main(String[] args){
		System.out.println("演示我的窗口操作：");
		Window win = new MyWindow();
		win.open();
		win.close();
		System.out.println("演示应用程序的窗口操作：");
		Window app = new AppWindow();
		app.open();
		app.activated();
		System.out.println(win);
		System.out.println(app.toString());
	}
}
