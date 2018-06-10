package chapter15;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane {
	public static void main(String[] args){
		JFrame frame = new JFrame("JTabbedPane����");
		frame.setSize(400, 400);
		frame.setLocation(300, 300);
		Container cont = frame.getContentPane();
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		cont.add(tab);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		tab.addTab("ѡ�1", p1);
		tab.addTab("ѡ�2", p2);
		tab.addTab("ѡ�3", p3);
		p1.add(new JLabel("����ѡ��1"));
		p2.add(new JLabel("����ѡ��2"));
		p3.add(new JLabel("����ѡ��3"));
		frame.setVisible(true);
	}
}
