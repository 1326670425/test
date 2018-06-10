package chapter15;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RadioButton extends JFrame{
	JRadioButton jb1 = new JRadioButton("男");
	JRadioButton jb2 = new JRadioButton("女");
	ButtonGroup bg = new ButtonGroup();
	JPanel jp = new JPanel();
	public RadioButton(){
		this.setTitle("选择按钮测试");
		this.setBounds(300, 300, 300, 300);
		bg.add(jb1);
		bg.add(jb2);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Action事件");
			}
		});
		jb2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				System.out.println("选项发生改变");
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
