package chapter02;

interface Window{
	public void open();//�򿪴���
	public void close();//�رմ���
	public void activated();//�����
	public void iconified();//��С��
	public void deiconified();//�ָ����ڴ�С
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
		System.out.println("�ҵĴ��ڡ����򿪴���");
	}
	public void close(){
		System.out.println("�ҵĴ��ڡ����رմ���");
	}
}

class AppWindow extends WindowAdapter{
	public void open(){
		System.out.println("Ӧ�ó��򡪡��򿪴���");
	}
	public void activated(){
		System.out.println("Ӧ�ó��򡪡������");
	}
}

public class Adapter {
	public static void main(String[] args){
		System.out.println("��ʾ�ҵĴ��ڲ�����");
		Window win = new MyWindow();
		win.open();
		win.close();
		System.out.println("��ʾӦ�ó���Ĵ��ڲ�����");
		Window app = new AppWindow();
		app.open();
		app.activated();
		System.out.println(win);
		System.out.println(app.toString());
	}
}
