package chapter15;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Layout2 extends JFrame implements ActionListener{
	
	int i;
	JButton jb = new JButton("创建按钮");
	JPanel jp = new JPanel();
	public Layout2(){
		this.setTitle("布局管理器测试");
		this.setBounds(300, 300, 300, 300);
		jp.setLayout(new GridLayout(3,2));
		jp.add(jb);
		jb.addActionListener(this);
		this.add(jp);
		this.setVisible(true);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		++i;
		JButton jbi = new JButton("按钮"+i);
		jp.add(jbi);
		//this.show(true);
		jp.revalidate();
	}
	public static void main(String[] args){
		new Layout2();
	}
	
}
