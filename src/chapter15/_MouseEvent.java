package chapter15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyColor{
	private JLabel lbRed = new JLabel("��ɫ����");
	private JLabel lbBlue = new JLabel("��ɫ����");
	private JLabel lbYellow = new JLabel("��ɫ����");
	private JLabel lbGreen = new JLabel("��ɫ����");
	private JLabel info = new JLabel("��ɫ");
	private JFrame frame = new JFrame("����¼�����");
	public MyColor(){
		frame.setSize(400,400);
		frame.setLocation(300, 300);
		frame.setLayout(new FlowLayout());
		frame.add(lbRed);
		frame.add(lbBlue);
		frame.add(lbGreen);
		frame.add(lbYellow);
		frame.add(info);
		MyMouseListener myListener = new MyMouseListener();
		lbRed.addMouseListener(myListener);
		lbBlue.addMouseListener(myListener);
		lbGreen.addMouseListener(myListener);
		lbYellow.addMouseListener(myListener);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				JOptionPane.showMessageDialog(null, "ϵͳ���ر�", "������Ϣ", 2);
				System.exit(1);
			}
		});
		frame.addMouseListener(myListener);
		this.frame.setVisible(true);
	}
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("��걻����");
			System.out.println("�����꣺"+e.getX());
			System.out.println("�����꣺"+e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			info.setFont(new Font("����", Font.BOLD, 40));
			if(e.getSource() == lbRed)
				info.setForeground(Color.RED);
			else if(e.getSource() == lbBlue)
				info.setForeground(Color.BLUE);
			else if(e.getSource() == lbGreen)
				info.setForeground(Color.GREEN);
			else if(e.getSource() == lbYellow)
				info.setForeground(Color.YELLOW);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
public class _MouseEvent {
	public static void main(String[] args){
		new MyColor();
	}
}
