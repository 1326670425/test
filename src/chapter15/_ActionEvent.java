package chapter15;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyFont{
	private JButton btRed = new JButton("红色字体");
	private JButton btBlue = new JButton("蓝色字体");
	private JButton btYellow = new JButton("黄色字体");
	public JTextArea text = new JTextArea("颜色管理器");
	private JFrame frame = new JFrame("动作事件测试");
	private MyActionListener MyAction = new MyActionListener();
	public MyFont(){
		frame.setSize(400, 400);
		frame.setLocation(500, 500);
		frame.setLayout(new FlowLayout());
		frame.add(btRed);
		frame.add(btBlue);
		frame.add(btYellow);
		text.setSize(100, 100);
		frame.add(text);
		btRed.addActionListener(MyAction);
		btBlue.addActionListener(MyAction);
		btYellow.addActionListener(MyAction);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent event){
				System.out.println("窗口关闭，退出程序");
				System.exit(1);
			}
		});
		frame.setVisible(true);
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btRed){
				text.setFont(new Font("华文行楷",Font.BOLD,30));
				text.setForeground(Color.RED);
			}
			else if(e.getSource() == btBlue){
				text.setFont(new Font("隶书",Font.BOLD,40));
				text.setForeground(Color.BLUE);				
			}
			else if(e.getSource() == btYellow){
				text.setFont(new Font("华文仿宋",Font.BOLD,50));
				text.setForeground(Color.YELLOW);
			}
		}
	}
}

public class _ActionEvent {
	public static void main(String[] args){
		new MyFont();
	}
}
