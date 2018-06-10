package chapter15;
import javax.swing.*;
import javax.swing.event.*;

public class ProgressBar extends JFrame{
	private JPanel jp = new JPanel();
	private JProgressBar jpb = new JProgressBar(0,1000);
	private JLabel[] jlArray = {new JLabel("进度条")}; 
	public ProgressBar(){
		jp.setLayout(null);
		for(int i=0;i<jlArray.length;i++){
			jlArray[i].setBounds(20,20+i*100,80,30);
			jp.add(jlArray[i]);
		}
		jpb.setBounds(20, 150, 450, 25);
		jp.add(jpb);
		jpb.setValue(500);
		jpb.setStringPainted(true);
		//jpb.setIndeterminate(true);模糊模式
		this.add(jp);
		this.setTitle("进度条测试");
		this.setBounds(300, 300, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		new ProgressBar();
	}
}