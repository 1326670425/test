package chapter15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Panel {
	public static void main(String[] args){
		JFrame frame = new JFrame("JPanel����");
		frame.setSize(200, 300);
		frame.setLayout(new BorderLayout());
		//����
		JPanel panUp = new JPanel();
		frame.add(panUp,BorderLayout.NORTH);
		JLabel labelNorth = new JLabel();
		Icon icon = new ImageIcon("F://image.jpg");
		labelNorth.setIcon(icon);
		panUp.add(labelNorth);
		//�в�
		JPanel panMiddle = new JPanel();
		Border border = new LineBorder(Color.RED);//����JPanel����
		panMiddle.setBorder(border);

		frame.add(panMiddle,BorderLayout.CENTER);
		JLabel labelLogin = new JLabel("�û�����");
		labelLogin.setSize(50,20);
		JTextField textLogin = new JTextField("");
		textLogin.setColumns(10);//��������
		textLogin.setSize(50,20);
		JLabel labelPw = new JLabel("��    �룺");
		labelPw.setSize(50,20);
		JPasswordField textPw = new JPasswordField();
		textPw.setColumns(10);
		textPw.setSize(50,20);
		panMiddle.add(labelLogin);
		panMiddle.add(textLogin);
		panMiddle.add(labelPw);
		panMiddle.add(textPw);
		//�ϲ�����
		JPanel panSouth = new JPanel();
		Border border2 = new LineBorder(Color.BLUE);
		panSouth.setBorder(border2);
		frame.add(panSouth, BorderLayout.SOUTH);
		JButton btCon = new JButton("����");
		JButton btExit = new JButton("�˳�");
		JButton btPro = new JButton("����");
		panSouth.add(btCon);
		panSouth.add(btExit);
		panSouth.add(btPro);
		frame.setVisible(true);
	}

}
