package chapter15;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameEvent {
	public static void main(String[] args){
		JFrame frame = new JFrame("�����¼�");
		frame.setSize(300, 300);
		frame.setLocation(300, 300);
		JLabel label = new JLabel("�����¼�����");
		frame.add(label);
		MyWindowListener myListener = new MyWindowListener();
		frame.addWindowListener(myListener);
		frame.setVisible(true);
	}
}

class MyWindowListener implements WindowListener{
	public void windowOpened(WindowEvent e){
		System.out.println("�򿪴���");
	}
	public void windowClosed(WindowEvent e){
		System.out.println("�رմ���");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("���ڹرմ���");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("��С������");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڻָ�����");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڱ�����");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����ʧ��");
	}
}