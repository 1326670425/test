package chapter15;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameEvent {
	public static void main(String[] args){
		JFrame frame = new JFrame("窗体事件");
		frame.setSize(300, 300);
		frame.setLocation(300, 300);
		JLabel label = new JLabel("窗体事件测试");
		frame.add(label);
		MyWindowListener myListener = new MyWindowListener();
		frame.addWindowListener(myListener);
		frame.setVisible(true);
	}
}

class MyWindowListener implements WindowListener{
	public void windowOpened(WindowEvent e){
		System.out.println("打开窗口");
	}
	public void windowClosed(WindowEvent e){
		System.out.println("关闭窗口");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("正在关闭窗口");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("最小化窗口");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口恢复正常");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口被激活");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口失活");
	}
}