package chapter15;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RadioButton extends JFrame{
	JRadioButton jb1 = new JRadioButton("��");
	JRadioButton jb2 = new JRadioButton("Ů");
	ButtonGroup bg = new ButtonGroup();
	JPanel jp = new JPanel();
	public RadioButton(){
		this.setTitle("ѡ��ť����");
		this.setBounds(300, 300, 300, 300);
		bg.add(jb1);
		bg.add(jb2);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Action�¼�");
			}
		});
		jb2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				System.out.println("ѡ����ı�");
			}
		});
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new RadioButton();
	}
}
