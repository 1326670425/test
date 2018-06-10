package chapter15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyColor{
	private JLabel lbRed = new JLabel("红色字体");
	private JLabel lbBlue = new JLabel("蓝色字体");
	private JLabel lbYellow = new JLabel("黄色字体");
	private JLabel lbGreen = new JLabel("绿色字体");
	private JLabel info = new JLabel("变色");
	private JFrame frame = new JFrame("鼠标事件测试");
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
				JOptionPane.showMessageDialog(null, "系统被关闭", "警告信息", 2);
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
			System.out.println("鼠标被单击");
			System.out.println("横坐标："+e.getX());
			System.out.println("纵坐标："+e.getY());
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
			info.setFont(new Font("隶书", Font.BOLD, 40));
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
