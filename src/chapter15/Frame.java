package chapter15;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
class MyFrame{
	private int height;
	private int width;
	private int x;
	private int y;
	private JFrame aFrame = new JFrame();
	public MyFrame(int height,int width,int x,int y){
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		Dimension d= new Dimension();//ʵ���������С����
		d.setSize(this.height, this.width);
		Point p = new Point(this.x, this.y);
		aFrame.setSize(d);
		aFrame.setLocation(p);
	}
	public void showFrame(){
		aFrame.setVisible(true);
	}
	public void closeFrame(){
		System.exit(JFrame.EXIT_ON_CLOSE);
	}
	public void setFrameTitle(String name){
		aFrame.setTitle(name);
	}
}
public class Frame {
	public static void main(String[] args){
/*		JFrame frame = new JFrame("һ������");
		frame.setSize(300, 300);
		frame.setLocation(300, 300);
		frame.setVisible(true);
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		frame.setTitle("�޸Ĵ������");*/
		MyFrame frame = new MyFrame(300,300,300,300);
		frame.showFrame();
		frame.setFrameTitle("һ������");
		try{

			System.out.println("�ȴ�����رմ���");
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		frame.closeFrame();
	}
}
