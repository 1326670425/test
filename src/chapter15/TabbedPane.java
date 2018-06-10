package chapter15;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane {
	public static void main(String[] args){
		JFrame frame = new JFrame("JTabbedPane测试");
		frame.setSize(400, 400);
		frame.setLocation(300, 300);
		Container cont = frame.getContentPane();
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		cont.add(tab);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		tab.addTab("选项卡1", p1);
		tab.addTab("选项卡2", p2);
		tab.addTab("选项卡3", p3);
		p1.add(new JLabel("这是选项1"));
		p2.add(new JLabel("这是选项2"));
		p3.add(new JLabel("这是选项3"));
		frame.setVisible(true);
	}
}
