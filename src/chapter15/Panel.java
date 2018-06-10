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
		JFrame frame = new JFrame("JPanel测试");
		frame.setSize(200, 300);
		frame.setLayout(new BorderLayout());
		//北部
		JPanel panUp = new JPanel();
		frame.add(panUp,BorderLayout.NORTH);
		JLabel labelNorth = new JLabel();
		Icon icon = new ImageIcon("F://image.jpg");
		labelNorth.setIcon(icon);
		panUp.add(labelNorth);
		//中部
		JPanel panMiddle = new JPanel();
		Border border = new LineBorder(Color.RED);//设置JPanel边线
		panMiddle.setBorder(border);

		frame.add(panMiddle,BorderLayout.CENTER);
		JLabel labelLogin = new JLabel("用户名：");
		labelLogin.setSize(50,20);
		JTextField textLogin = new JTextField("");
		textLogin.setColumns(10);//设置列数
		textLogin.setSize(50,20);
		JLabel labelPw = new JLabel("密    码：");
		labelPw.setSize(50,20);
		JPasswordField textPw = new JPasswordField();
		textPw.setColumns(10);
		textPw.setSize(50,20);
		panMiddle.add(labelLogin);
		panMiddle.add(textLogin);
		panMiddle.add(labelPw);
		panMiddle.add(textPw);
		//南部区域
		JPanel panSouth = new JPanel();
		Border border2 = new LineBorder(Color.BLUE);
		panSouth.setBorder(border2);
		frame.add(panSouth, BorderLayout.SOUTH);
		JButton btCon = new JButton("连接");
		JButton btExit = new JButton("退出");
		JButton btPro = new JButton("属性");
		panSouth.add(btCon);
		panSouth.add(btExit);
		panSouth.add(btPro);
		frame.setVisible(true);
	}

}
