package chapter15;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class SplitPane {
	public static void main(String[] args){
		JFrame frame = new JFrame("JSplitPane����");
		frame.setLocation(300, 300);
		frame.setSize(400, 400);
		JPanel pLeft = new JPanel();
		pLeft.setLayout(new GridLayout(5,1));
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT ,pLeft,new JTextField(""));
		sp.setDividerSize(10);//���÷ָ��ߴ�С
		frame.add(sp);
		
		JLabel label1 = new JLabel("ѡ��1");
		JLabel label2 = new JLabel("ѡ��2");
		JLabel label3 = new JLabel("ѡ��3");
		pLeft.add(label1);
		pLeft.add(label2);
		pLeft.add(label3);
		frame.setVisible(true);
	}
}
